package com.example.terminal

class Model(title: String?, quantity: String?) {

    private var title: String
    private var quantity: String
    init {
        this.title = title!!
        this.quantity = quantity!!
    }
    fun getTitle(): String? {
        return title
    }
    fun setTitle(name: String?) {
        title = name!!
    }
    fun getQuantity(): String? {
        return quantity
    }
    fun setQuantity(quantity: String?) {
        this.quantity = quantity!!
    }


}