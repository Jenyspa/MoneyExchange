package com.jenyspa.moneyexchange.data.repository

import com.jenyspa.moneyexchange.data.datasource.LocalDataSource
import com.jenyspa.moneyexchange.data.model.Result

class ExchangeMoneyRepository {

    private val dataSource = LocalDataSource()

    fun convertMoney(exchange: String) : List<Result>{
        val exchangeRate = dataSource.getRates(exchange)
        val list = mutableListOf<Result>()

        for(exchange in exchangeRate.conversionRates) {
            list.add(Result(exchange.key, exchange.value))
        }
        return list
    }
}