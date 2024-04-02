package com.artpim.foodiesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.artpim.foodiesapp.data.ProductsItem

class SharedViewModel: ViewModel() {

    var productsItem by mutableStateOf<ProductsItem?>(null)
        private set

    fun addItem(newItem: ProductsItem){
        productsItem = newItem
    }
}