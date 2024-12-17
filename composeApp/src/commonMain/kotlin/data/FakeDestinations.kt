package data

import model.Destination

object FakeDestinations {
    val destinations = arrayListOf<Destination>().apply {
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Palmera de 7 Cabezas",
                description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
                rating = 4.3f,
                location = "Ica, Perú",
                price = "$48",
                type = "Turismo",
                category = FakeCategories.categories[1],
                image = FakeImages.randomImageUrls(4),
                dates = arrayListOf("Lunes a Viernes: 9:00 AM - 9:00 PM", "Sabado y Domingo: 9:00 AM - 9:00 PM"),
                meetingPoints = arrayListOf("Serang", "Baranga", "Manchester", "Folio"),
                facilities = arrayListOf("999-999-999", "correo@gmail.com"),
                via = "Peshawar",
                estimation = "10 km"
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Laguna de Huacachina",
                description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
                rating = 4.0f,
                location = "Ica, Perú",
                price = "$30",
                type = "Turismo",
                category = FakeCategories.categories[1],
                image =FakeImages.randomImageUrls(4),
                dates = arrayListOf("Lunes a Viernes: 9:00 AM - 9:00 PM", "Sabado y Domingo: 9:00 AM - 9:00 PM"),
                meetingPoints = arrayListOf("Serang", "Baranga", "Manchester", "Folio"),
                facilities = arrayListOf("999-999-999", "correo@gmail.com"),
                via = "Peshawar",
                estimation = "10 km"
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Lombok Mountain",
                description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
                rating = 3.7f,
                location = "Pisco, Perú",
                price = "$30",
                type = "Turismo",
                category = FakeCategories.categories[2],
                image = FakeImages.randomImageUrls(3),
                dates = arrayListOf("Lunes a Viernes: 9:00 AM - 9:00 PM", "Sabado y Domingo: 9:00 AM - 9:00 PM"),
                meetingPoints = arrayListOf("Serang", "Baranga", "Manchester", "Folio"),
                facilities = arrayListOf("999-999-999", "correo@gmail.com"),
                via = "Karachi",
                estimation = "10 km"
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Lineas de Nazca",
                description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
                rating = 2.7f,
                location = "Nazca, Perú",
                price = "$18",
                type = "Festividad",
                category = FakeCategories.categories[3],
                image = FakeImages.randomImageUrls(4),
                dates = arrayListOf("Lunes a Viernes: 9:00 AM - 9:00 PM", "Sabado y Domingo: 9:00 AM - 9:00 PM"),
                meetingPoints = arrayListOf("Serang", "Baranga", "Manchester", "Folio"),
                facilities = arrayListOf("999-999-999", "correo@gmail.com"),
                via = "Lahore",
                estimation = "10 km"
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Rinjani Mountain",
                description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
                rating = 2.7f,
                location = "Chincha, Perú",
                price = "$18",
                type = "Festividad",
                category = FakeCategories.categories[4],
                image = FakeImages.randomImageUrls(4),
                dates = arrayListOf("Lunes a Viernes: 9:00 AM - 9:00 PM", "Sabado y Domingo: 9:00 AM - 9:00 PM"),
                meetingPoints = arrayListOf("Serang", "Baranga", "Manchester", "Folio"),
                facilities = arrayListOf("999-999-999", "correo@gmail.com"),
                via = "Lahore",
                estimation = "10 km"
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Hotel Cielo",
                description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
                rating = 2.7f,
                location = "Pisco, Perú",
                price = "$18",
                type = "Hoteles",
                category = FakeCategories.categories[2],
                image = FakeImages.randomImageUrls(4),
                dates = arrayListOf("Lunes a Viernes: 9:00 AM - 9:00 PM", "Sabado y Domingo: 9:00 AM - 9:00 PM"),
                meetingPoints = arrayListOf("Serang", "Baranga", "Manchester", "Folio"),
                facilities = arrayListOf("999-999-999", "correo@gmail.com"),
                via = "Lahore",
                estimation = "10 km"
            )
        )
    }
}