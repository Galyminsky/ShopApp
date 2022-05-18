package com.jobforandroid.shopapp.domain

class AddShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun addShopItem (shopItem : ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}