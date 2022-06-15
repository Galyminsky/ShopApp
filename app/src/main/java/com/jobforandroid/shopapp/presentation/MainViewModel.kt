package com.jobforandroid.shopapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jobforandroid.shopapp.data.ShopListRepositoryImpl
import com.jobforandroid.shopapp.domain.DeleteShopItemUseCase
import com.jobforandroid.shopapp.domain.EditShopItemUseCase
import com.jobforandroid.shopapp.domain.GetShopListUseCase
import com.jobforandroid.shopapp.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list =  getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem (shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState (shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }


}