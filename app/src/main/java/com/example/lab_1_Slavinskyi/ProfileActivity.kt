package com.example.lab_1_Slavinskyi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_1_Slavinskyi.data.model.Animal
import com.example.lab_1_Slavinskyi.ui.theme.MyTheme

class ProfileActivity : AppCompatActivity() {

    private val animal: Animal by lazy {
        intent?.getSerializableExtra(PUPPY_ID) as Animal
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ProfileScreen(animal)
            }
        }
    }

    companion object {
        private const val PUPPY_ID = "puppy_id"
        fun newIntent(context: Context, animal: Animal) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID, animal)
            }
    }
}
