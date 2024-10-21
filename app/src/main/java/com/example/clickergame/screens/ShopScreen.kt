package com.example.clickergame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoMode
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.clickergame.data.ClickerViewModel

@Composable
fun ShopScreen(
    ViewModel: ClickerViewModel,
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { navController.navigate(Routes.GAME_SCREEN) },
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 10.dp, y = 20.dp),
            ) {
                Image(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                )
            }
            Text(
                text = "Магазин",
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .offset(x = 0.dp, y = 24.dp),
                fontSize = 60.sp,
            )
            Text(
                text = "У вас ${ViewModel.currentCount} кливков",
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(x = 0.dp, y = -300.dp),
                fontSize = 32.sp,
            )
            Text(
                text = "Цена: 100 кликов",
                modifier = Modifier
                    .offset(x = 0.dp, y = 220.dp),
                fontSize = 24.sp
            )
            Text(
                text = "Цена: ${ViewModel.multiClickCost} CC",
                modifier = Modifier
                    .offset(x = 160.dp, y = 360.dp),
                fontSize = 18.sp
            )
            Button(onClick = {
                ViewModel.autoClicker()
                             ViewModel.startAutoClicker()},
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = 270.dp, y = 250.dp)
            ) {
                Image(
                    imageVector = Icons.Default.AutoMode,
                    contentDescription = "AutoClick"
                )
            }
            Text(
                text = "${ViewModel.autoclick} кликов в секунду",
                modifier = Modifier
                    .offset(x = 250.dp, y = 360.dp),
                fontSize = 18.sp
            )
            Text(
                text = "Цена: ${ViewModel.autoClickCost} кликоинов",
                modifier = Modifier
                    .offset(x = 250.dp, y = 220.dp),
                )
            Column(

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                ) {
                    Button(
                        onClick = {
                            ViewModel.buyClickCoin()
                        },
                        modifier = Modifier
                            .size(100.dp)
                            .offset(x = 20.dp, y = 250.dp)
                    ) {
                        Image(
                            imageVector = Icons.Default.CurrencyExchange,
                            contentDescription = "ClickCoin",
                        )
                    }
                    Text(
                        text = "${ViewModel.clickCoin} ClickCoin's",
                        modifier = Modifier
                            .offset(x = -90.dp, y = 320.dp),
                        fontSize = 24.sp
                    )
                    Button(
                        onClick = {
                            ViewModel.MultiClick()
                        },
                        modifier = Modifier
                            .size(100.dp)
                            .offset(x = -60.dp, y = 250.dp)
                    )
                    {
                        Image(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "MultiClick"
                        )
                    }

                    Text(
                        text = "${ViewModel.multiClick} клик за клик",
                        modifier = Modifier
                            .offset(x = -140.dp, y = 170.dp),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
