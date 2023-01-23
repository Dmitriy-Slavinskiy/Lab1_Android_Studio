package com.example.lab_1_Slavinskyi

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.lab_1_Slavinskyi.data.DataProvider
import com.example.lab_1_Slavinskyi.data.model.Animal

@Composable
fun BarkHomeContent(navigateToProfile: (Animal) -> Unit) {
    val puppies = remember { DataProvider.animalLists }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = puppies,
            itemContent = {
                AnimalListItem(animal = it, navigateToProfile)
            }
        )
    }
}
