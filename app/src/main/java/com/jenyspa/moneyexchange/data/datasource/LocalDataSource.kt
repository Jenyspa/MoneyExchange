package com.jenyspa.moneyexchange.data.datasource

import com.jenyspa.moneyexchange.data.model.ExchangeRate

class LocalDataSource {

    fun getRates(exchange: String) : ExchangeRate{
         return ExchangeRate(123456, mapOf(
            "USD" to  1.0,
            "AUD" to 1.4817,
            "BGN" to 1.7741,
            "CAD" to 1.3168,
            "CHF" to 0.9774,
            "CNY" to 6.9454,
            "EGP" to 15.7361,
            "EUR" to 0.9013,
            "GBP" to 0.7679
        ))
    }
}