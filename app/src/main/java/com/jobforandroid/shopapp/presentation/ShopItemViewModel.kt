package com.jobforandroid.shopapp.presentation

import androidx.lifecycle.ViewModel
import com.jobforandroid.shopapp.data.ShopListRepositoryImpl
import com.jobforandroid.shopapp.domain.AddShopItemUseCase
import com.jobforandroid.shopapp.domain.EditShopItemUseCase
import com.jobforandroid.shopapp.domain.GetShopItemUseCase
import com.jobforandroid.shopapp.domain.ShopItem


class ShopItemViewModel : ViewModel()  {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItem (shopItemId: Int) {
        val item = getShopItemUseCase.getShopItem(shopItemId)

    }

    fun addShopItem (shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun editShopItem (shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

}