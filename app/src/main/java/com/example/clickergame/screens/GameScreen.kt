package com.example.clickergame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.clickergame.data.ClickerViewModel
import com.example.clickergame.screens.Routes.SHOP_SCREEN

@Composable
fun GameScreen(
    ViewModel: ClickerViewModel,
    navController: NavController,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
    ){
        Button(onClick ={
            ViewModel.incrementClicks()
        },
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .size(150.dp)
                .offset(x = 0.dp, y = -75.dp)
        ) {
            Text(
                text = "${ViewModel.currentCount}",
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically),
                color = Color.Red,
                fontSize = 36.sp
                )
        }
        Text(
            text = "Clicker Game",
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(y = 16.dp),
            fontSize = 36.sp,
            color = Color.Green
        )
        Button(
            onClick = { navController.navigate(SHOP_SCREEN) },
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .offset(x = 0.dp, y = -20.dp),
        ){
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shop",
                modifier = Modifier

            )
        }
        Button(
            onClick = {navController.navigate(Routes.SETTINGS_SCREEN)},
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .offset(x = -15.dp, y = 35.dp),
        ){
            Image(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically))
        }
        Text(
            text = "Жми, жми!",
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(x = 0.dp, y = 80.dp),
            color = Color.Magenta,
            fontSize = 36.sp
        )
        Text(
            text = "У вас "
        )
        Button(onClick = {
          ViewModel.GodButton()
        },
            modifier = Modifier.align(alignment = Alignment.CenterEnd)
        ){
            Text(text = "+1000")
        }
    }
}
