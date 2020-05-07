package com.jenyspa.moneyexchange.ext

fun Double.formatMoney() : String{
    return "%.2f".format(this)
}