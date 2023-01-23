package com.example.lab_1_Slavinskyi.data

import com.example.lab_1_Slavinskyi.R
import com.example.lab_1_Slavinskyi.data.model.Animal

object DataProvider {

    val animal =
        Animal(
            id = 1,
            title = "Freddie",
            sex = "Male",
            age = 4,
            description = "Freddie is very friendly dog from Ohio he likes pizza.",
            animalImageId = R.drawable.p1
        )

    val animalLists = listOf(
        animal,
        Animal(
            id = 2,
            title = "Matilda",
            sex = "Female",
            age = 12,
            description = "Matilda lives in NY and likes to play with squirrel.",
            animalImageId = R.drawable.p2
        ),
        Animal(
            id = 3,
            title = "Theodore",
            sex = "Male",
            age = 3,
            description = "Theodore likes to play with Teddy bear.",
            animalImageId = R.drawable.p3
        ),
        Animal(
            id = 4,
            title = "Philip",
            sex = "Male",
            age = 10,
            description = "Philip is very funny dog from Las Vegas, likes to ride ih the car.",
            animalImageId = R.drawable.p4
        ),
        Animal(
            id = 5,
            title = "Carlos",
            sex = "Male",
            age = 5,
            description = "Carlos lives in Mexico on a ranch and grows blue agave.",
            animalImageId = R.drawable.p5
        ),
        Animal(
            id = 6,
            title = "Volt",
            sex = "Male",
            age = 6,
            description = "Volt is a very energetic dog, likes to play wiwh a ball.",
            animalImageId = R.drawable.p6
        ),
        Animal(
            id = 7,
            title = "Lucky",
            sex = "Male",
            age = 5,
            description = "Young and very talented dog!",
            animalImageId = R.drawable.p7
        ),
        Animal(
            id = 8,
            title = "Lewis",
            sex = "Male",
            age = 2,
            description = "Just good dog.",
            animalImageId = R.drawable.p8
        ),
        Animal(
            id = 9,
            title = "Goldy",
            sex = "Female",
            age = 8,
            description = " Goldy is very kind cat, likes to eat fried chicken.",
            animalImageId = R.drawable.p9
        ),
        Animal(
            id = 10,
            title = "Kowalski",
            sex = "Male",
            age = 7,
            description = "Kowalski is very smart cat who will always help you.",
            animalImageId = R.drawable.p10
        ),
        Animal(
            id = 11,
            title = "Rico",
            sex = "Male",
            age = 7,
            description = "Rico is very cheerful but sometimes noisy cat.",
            animalImageId = R.drawable.p11
        ),
        Animal(
            id = 12,
            title = "Lisa",
            sex = "Female",
            age = 8,
            description = "Lisa is very clewer cat from Springfield which likes to watch birds from the window.",
            animalImageId = R.drawable.p12
        ),
    )
}
