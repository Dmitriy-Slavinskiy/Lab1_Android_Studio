package com.example.lab_1_Slavinskyi

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_1_Slavinskyi.data.DataProvider
import com.example.lab_1_Slavinskyi.data.model.Animal
import com.example.lab_1_Slavinskyi.ui.theme.graySurface
import com.example.lab_1_Slavinskyi.ui.theme.typography

@Composable
fun PuppyListItem(animal: Animal, navigateToProfile: (Animal) -> Unit,) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = graySurface,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row(Modifier.clickable { navigateToProfile(animal) }) {
            PuppyImage(animal)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = animal.title, style = typography.h6)
                Text(text = animal.sex, style = typography.caption)
            }
        }
    }
}

@Composable
private fun PuppyImage(animal: Animal) {
    Image(
        painter = painterResource(id = animal.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Preview
@Composable
fun PreviewPuppyItem() {
    val puppy = DataProvider.animal
    PuppyListItem(animal = puppy, navigateToProfile = {})
}
