package com.example.clickergame

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clickergame.data.ClickerViewModel
import com.example.clickergame.screens.ClickerNavigationGraph
import com.example.clickergame.screens.GameScreen
import com.example.clickergame.screens.Routes
import com.example.clickergame.screens.SettingsScreen
import com.example.clickergame.screens.ShopScreen
import com.example.clickergame.ui.theme.ClickerGameTheme
import dagger.hilt.android.HiltAndroidApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ClickerGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ClickerNavigationGraph()
                }
            }
        }
    }
}