package com.example.myshopapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshopapp.data.ShopListRepositoryImpl
import com.example.myshopapp.domain.DeleteShopItemUseCase
import com.example.myshopapp.domain.EditShopItemUseCase
import com.example.myshopapp.domain.GetShopListUseCase
import com.example.myshopapp.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl //need changed

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}