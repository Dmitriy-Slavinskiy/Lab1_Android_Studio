package com.example.lab_1_Slavinskyi.data.model

import java.io.Serializable

data class Animal(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val animalImageId: Int = 0
) : Serializable
