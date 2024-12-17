package ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import model.Destination
import org.jetbrains.compose.resources.painterResource
import theme.ColorInicio
import theme.ColorTexto
import theme.White
import theme.craneRegular
import theme.PrimaryColor
import theme.Red
import theme.SecondTextColor
import theme.TextColor
import travelvista.composeapp.generated.resources.Res
import travelvista.composeapp.generated.resources.back
import travelvista.composeapp.generated.resources.ci_location
import travelvista.composeapp.generated.resources.humberg_icon
import travelvista.composeapp.generated.resources.menu_fav
import travelvista.composeapp.generated.resources.profile_icon
import kotlin.text.append

@Composable
fun homeHeader() {

    val MyTextStyle = TextStyle(
        fontSize = 25.sp,
        fontFamily = craneRegular,
        color = ColorTexto,
        fontWeight = FontWeight.Bold
    )
    val annotatedString = buildAnnotatedString {
        pushStyle(MyTextStyle.toSpanStyle())
        append("Conoce todo lo que ")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = ColorInicio)) {
            append("ICA")
        }
        append(" \n tiene para ti")
        pop()
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding( top = 20.dp, start = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = annotatedString)

            }
        Image(
            modifier = Modifier.size(60.dp).padding(end = 16.dp)
                .clickable {

            },
            painter = painterResource(Res.drawable.humberg_icon),
            contentDescription = null
        )

        }
    }


@Composable
fun destinationDetailHeader(
    navigator: Navigator,
    destination: Destination,
    checkFavorite: (Destination) -> Boolean,
    addFavorite: (Destination) -> Unit,
    removeFavorite: (Destination) -> Unit,
    updateBottomNavBarVisible: () -> Unit
) {
    val isFav = remember { mutableStateOf(checkFavorite(destination)) }
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(36.dp)
                .clickable {
                    updateBottomNavBarVisible.invoke()
                    navigator.pop()
                },
            painter = painterResource(Res.drawable.back),
            contentDescription = null
        )

        Box(
            modifier = Modifier.size(36.dp)
                .background(
                    color = White,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable {
                    if (isFav.value) {
                        removeFavorite(destination)
                        isFav.value = false
                    } else {
                        addFavorite(destination)
                        isFav.value = true
                    }
                }
        ) {
            val tintColor = if (isFav.value) Red else TextColor
            Icon(
                modifier = Modifier.padding(6.dp),
                painter = painterResource(Res.drawable.menu_fav),
                tint = tintColor,
                contentDescription = null
            )
        }
    }
}