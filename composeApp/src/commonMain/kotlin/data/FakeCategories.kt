package data

import model.Category
import travelvista.composeapp.generated.resources.Res
import travelvista.composeapp.generated.resources.category1
import travelvista.composeapp.generated.resources.category2
import travelvista.composeapp.generated.resources.category3
import travelvista.composeapp.generated.resources.category4
import travelvista.composeapp.generated.resources.star

object FakeCategories {

    val categories = arrayListOf<Category>().apply {
        add(Category(0, "Destinos", Res.drawable.star))
        add(Category(1, "Taxi", Res.drawable.category3))
        add(Category(2, "Policia", Res.drawable.category2))
        add(Category(3, "Bomberos", Res.drawable.category3))
        add(Category(4, "Hospitales", Res.drawable.category3))
    }

}
