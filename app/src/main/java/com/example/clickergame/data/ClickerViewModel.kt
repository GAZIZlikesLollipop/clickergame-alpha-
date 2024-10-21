package com.example.clickergame.data


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ClickerViewModel : ViewModel() {
    var clickCoin by mutableStateOf(0)
    var currentCount by mutableStateOf(0)
    var countMulti by mutableStateOf(1)
    var rebirths by mutableStateOf(0)

    // Список цен (100, 200, ..., 10200)
    val coinPrices: List<Int> = List(102) { (it + 1) * 100 }

    // Увеличение количества кликов
    fun incrementClicks() {
        currentCount += countMulti
    }

    // Состояние для отслеживания покупки сотен
    var currency by mutableStateOf(false)

    // Покупка кликоинов за 100 кликов
    fun buyClickCoin() {
        if (currentCount >= 100) {
            currency = true
            clickCoin += 1
            currentCount -= 100
        } else {
            currency = false
        }
    }

    // Логика для мультикликов (удваивает клики)
    var multiClickCost by mutableStateOf(2)
    var multiClick by mutableStateOf(1)

    fun MultiClick() {
        if (clickCoin >= multiClickCost) {
            countMulti *= 2
            clickCoin -= multiClickCost
            multiClickCost *= 2
            multiClick *= 2
        }
    }
    fun startAutoClicker() {
        viewModelScope.launch {
            autoClicker2()
        }
    }
    var autoclick by mutableStateOf(0)
    var autoClickCost by mutableStateOf(10)
    var autoClickerEnabled by mutableStateOf(false)
    fun autoClicker(){
        if(clickCoin >= autoClickCost){
            autoclick += 1
            clickCoin -= autoClickCost
            autoClickCost += 10
            autoClickerEnabled = true
            startAutoClicker()
        }
    }
    suspend fun autoClicker2() {
        while (autoClickerEnabled) {
            delay(1000)
            if(clickCoin >= autoClickCost){
                autoClickerEnabled = true
                currentCount += autoclick
                clickCoin -= autoclick
            } else{
                autoClickerEnabled = false
            }
        }
    }
    fun GodButton(){
        currentCount += 1000
    }
    var rebirthCount by mutableStateOf(100)
    var rebirthCost by mutableStateOf(100)
    fun rebirth() {
        if (clickCoin >= rebirthCost) {
            rebirthCost *= 2
            clickCoin -= rebirthCost
            rebirthCount += 1
            countMulti *= 2
            autoclick == 0
        }
    }
}
