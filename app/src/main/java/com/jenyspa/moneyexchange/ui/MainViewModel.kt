package com.jenyspa.moneyexchange.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jenyspa.moneyexchange.data.model.Result
import com.jenyspa.moneyexchange.data.repository.ExchangeMoneyRepository

class MainViewModel(private val repository: ExchangeMoneyRepository): ViewModel() {

    val liveData = MutableLiveData<List<Result>>()

    fun convertMoney(currencySymbol: String, baseMoney: String) {
        val listMoneyExchange = repository.convertMoney(currencySymbol)
        val listConvertedMoney = mutableListOf<Result>()

        for(moneyExchange in listMoneyExchange) {
            val convert = moneyExchange.currencyValue * baseMoney.toDouble()

            listConvertedMoney.add(Result(moneyExchange.currencyName, convert))
        }
        liveData.postValue(listConvertedMoney)
    }
}
