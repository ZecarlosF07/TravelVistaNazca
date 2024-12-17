package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.TabOptions
import data.FakeArticles
import di.HomeScreenModelProvider
import model.Destination
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import travelvista.composeapp.generated.resources.Res
import travelvista.composeapp.generated.resources.arrow_forward
import travelvista.composeapp.generated.resources.category
import travelvista.composeapp.generated.resources.home_tab
import travelvista.composeapp.generated.resources.menu_home
import travelvista.composeapp.generated.resources.popular_destination
import travelvista.composeapp.generated.resources.view_all
import ui.component.ArticleCard
import ui.component.ChildLayout
import ui.component.LoadItemAfterSafeCast
import ui.component.NearestLocationItem
import ui.component.Tabx
import ui.component.TitleWithViewAllItem
import ui.component.VerticalScrollLayout
import ui.component.destinationSmallItem
import ui.component.homeHeader
import ui.component.loadCategoryItems
import ui.component.loadDestinationLargeItems
import ui.viewmodel.HomeScreenModel
import util.BOTTOM_NAV_SPACE

enum class HomeScreenContents {
    HEADER_SECTION,
    CATEGORY_VIEW_ALL,
    CATEGORY_SECTION,
    DESTINATION_LARGE_SECTION,
    DESTINATION_VIEW_ALL,
    NEAREST_LOCATIONS,
    ARTICLES,
    DESTINATION_SMALL_SECTION,
}

data object HomeTab : Tabx {
    override fun defaultTitle(): StringResource = Res.string.home_tab
    override fun defaultIcon(): DrawableResource = Res.drawable.menu_home

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.home_tab)
            val icon = painterResource(Res.drawable.menu_home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(HomeScreen)
    }

}

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = HomeScreenModelProvider.homeScreenModel
        val navigator = LocalNavigator.currentOrThrow
        HomeScreenView(navigator = navigator, viewModel = screenModel)
    }
}


@Composable
fun HomeScreenView(
    viewModel: HomeScreenModel,
    navigator: Navigator
) {
    val destinations by viewModel.destinations.collectAsState()
    val nearestDestinations = FakeArticles.destinations
    val categories by viewModel.categories.collectAsState()
    var artvisible by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.background(color = Color.White).fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        var mDestinations by remember { mutableStateOf(destinations) }

        var mDestinations2 by remember { mutableStateOf(destinations) }

        mDestinations2 = arrayListOf<Destination>().apply {
            addAll(destinations.filter { it.type == "Festividad" })
        }

        var mHoteles by remember { mutableStateOf(destinations) }
        var mNearestDestinations by remember { mutableStateOf(nearestDestinations) }
        VerticalScrollLayout(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.White),
            ChildLayout(
                contentType = HomeScreenContents.HEADER_SECTION.name,
                content = {
                    homeHeader()
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.CATEGORY_VIEW_ALL.name,
                content = {
                    TitleWithViewAllItem(
                        stringResource(Res.string.category),
                        stringResource(Res.string.view_all),
                        Res.drawable.arrow_forward
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.CATEGORY_SECTION.name,
                content = {
                    loadCategoryItems(categories) { category ->
                        when (category.title) {
                            "Todo" -> {
                                artvisible = false
                                mDestinations = arrayListOf<Destination>().apply {
                                    addAll(destinations.filter { it.type == "Turismo" })
                                }

                                mDestinations2 = arrayListOf<Destination>().apply {
                                    addAll(destinations.filter { it.type == "Festividad" })
                                }
                            }
                            else -> {
                                artvisible = true
                                mDestinations = arrayListOf<Destination>().apply {
                                    addAll(destinations.filter { it.category == category && it.type == "Festividad" || it.category == category && it.type == "Turismo"})
                                }
                                mHoteles = arrayListOf<Destination>().apply {
                                    addAll(destinations.filter { it.category == category && it.type == "Hoteles" })
                                }
                                mNearestDestinations = arrayListOf<Destination>().apply {
                                    addAll(nearestDestinations.filter { it.category == category })
                                }

                            }
                        }
                    }
                }
            ),

            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_LARGE_SECTION.name,
                content = {
                    loadDestinationLargeItems(
                        destinations = mDestinations,
                        checkFavorite = {
                            viewModel.checkFavorite(it)
                        },
                        addFavorite = {
                            viewModel.addFavorite(it)
                        },
                        removeFavorite = {
                            viewModel.removeFavorite(it)
                        },
                        onItemClicked = {
                            viewModel.setBottomNavBarVisible(false)
                            navigator.push(DestinationDetailScreen(it))
                        }
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_VIEW_ALL.name,
                content = {
                    TitleWithViewAllItem(
                        stringResource(Res.string.popular_destination),
                        stringResource(Res.string.view_all),
                        Res.drawable.arrow_forward
                    )
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_SMALL_SECTION.name,
                items = if (artvisible == true){
                    mHoteles
                }else{
                    mDestinations2
                },
                content = { item ->
                    LoadItemAfterSafeCast<Destination>(item) {
                        destinationSmallItem(it) {
                            viewModel.setBottomNavBarVisible(false)
                            navigator.push(DestinationDetailScreen(it))
                        }
                    }
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_VIEW_ALL.name,
                content = {
                    if (artvisible == true) {
                        TitleWithViewAllItem(
                            "Restaurantes",
                            stringResource(Res.string.view_all),
                            Res.drawable.arrow_forward
                        )
                    }
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.NEAREST_LOCATIONS.name,
                content = {
                    if (artvisible == true) {
                        LazyRow(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(mNearestDestinations) {
                                NearestLocationItem(it) {
                                    viewModel.setBottomNavBarVisible(false)
                                    navigator.push(DestinationDetailScreen(it))
                                }
                            }
                        }
                    }
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.DESTINATION_VIEW_ALL.name,
                content = {
                    if (artvisible == true) {
                        TitleWithViewAllItem(
                            "Articles",
                            stringResource(Res.string.view_all),
                            Res.drawable.arrow_forward
                        )
                    }
                }
            ),
            ChildLayout(
                contentType = HomeScreenContents.ARTICLES.name,
                content = {
                    if (artvisible == true) {
                        Column(
                            modifier = Modifier.padding(start = 16.dp, top = 12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            FakeArticles.articles.forEach {
                                ArticleCard(modifier = Modifier, article = it) {
                                    viewModel.setBottomNavBarVisible(false)
                                    navigator.push(ArticleDetailScreen(it))
                                }
                            }
                        }
                    }
                }
            )
        )
    }

}


