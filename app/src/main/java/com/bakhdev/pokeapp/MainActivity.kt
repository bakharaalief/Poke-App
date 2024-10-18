package com.bakhdev.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bakhdev.pokeapp.theme.PokeAppTheme
import com.bakhdev.pokeapp.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeAppTheme(
                dynamicColor = false
            ) {
                MainScreen()
            }
        }
    }
}