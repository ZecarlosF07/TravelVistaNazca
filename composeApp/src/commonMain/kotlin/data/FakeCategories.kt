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
        add(Category(0, "Todo", Res.drawable.star))
        add(Category(1, "Ica", Res.drawable.category1))
        add(Category(2, "Pisco", Res.drawable.category2))
        add(Category(3, "Nazca", Res.drawable.category3))
        add(Category(4, "Chincha", Res.drawable.category4))
        add(Category(5, "Palpa", Res.drawable.category4))
    }

}
