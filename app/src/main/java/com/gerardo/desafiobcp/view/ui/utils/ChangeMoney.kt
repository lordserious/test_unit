package com.gerardo.desafiobcp.view.ui.utils

class ChangeMoney {

    // TODO SI VOY CON SOLES ES QUE VOY A COMPRANDO
    fun solesToDolares(cantidad: Double): Double {
        return cantidad / DOLARES_COMPRA
    }

    // TODO SI VOY CON DOLARES ES QUE VOY A VENDER
    fun dolaresToSoles(cantidad: Double): Double {
        return cantidad * SOLES_VENTA
    }


    companion object {
        private const val DOLARES_COMPRA = 3.25
        private const val SOLES_VENTA = 3.29
        private const val EUROPEAN_UNION = 4.50
        private const val JAPAN = 5.00
    }
}