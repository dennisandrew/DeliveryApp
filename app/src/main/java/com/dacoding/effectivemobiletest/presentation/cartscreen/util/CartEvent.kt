package com.dacoding.effectivemobiletest.presentation.cartscreen.util

sealed class CartEvent {
    data class CartPlus(val position: Product): CartEvent()
    data class CartMinus(val position: Product): CartEvent()
    data class CartPositionRemove(val position: Product): CartEvent()
    object OrderConfirmed: CartEvent()

}
