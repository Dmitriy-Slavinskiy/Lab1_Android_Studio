package com.example.lab_1_Slavinskyi

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lab_1_Slavinskyi.data.DataProvider
import com.example.lab_1_Slavinskyi.data.model.Animal
import com.example.lab_1_Slavinskyi.ui.theme.purple500

@Composable
fun ProfileScreen(animal: Animal, onNavIconPressed: () -> Unit = { }) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        scrollState,
                        animal,
                        this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(animal, this@BoxWithConstraints.maxHeight)
                }
            }
            AdoptFab(
                extended = scrollState.value == 0,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    animal: Animal,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = painterResource(id = animal.animalImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(animal: Animal, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Name(animal)

        ProfileProperty(stringResource(R.string.sex), animal.sex)

        ProfileProperty(stringResource(R.string.age), animal.age.toString())

        ProfileProperty(stringResource(R.string.personality), animal.description)

        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
    animal: Animal
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Name(
            animal = animal,
            modifier = Modifier.baselineHeight(32.dp)
        )
    }
}

@Composable
private fun Name(animal: Animal, modifier: Modifier = Modifier) {
    Text(
        text = animal.title,
        modifier = modifier,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
}

@Composable
fun AdoptFab(extended: Boolean, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { /* TODO */ },
        modifier = modifier
            .padding(16.dp)
            .padding()
            .height(48.dp)
            .widthIn(min = 48.dp),
        backgroundColor = purple500,
        contentColor = Color.White
    ) {
        AnimatingFabContent(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = stringResource(R.string.adopt_me)
                )
            },
            text = {
                Text(
                    text = stringResource(R.string.adopt_me),
                )
            },
            extended = extended

        )
    }
}

@Preview
@Composable
fun ProfilePreview() {
    val animal = DataProvider.animal
    ProfileScreen(animal = animal)
}
