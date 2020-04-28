package com.jenyspa.moneyexchange.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jenyspa.moneyexchange.R

class MainActivity : AppCompatActivity() {

    lateinit var currencyBase: EditText
    lateinit var baseMoney: EditText
    lateinit var buttonConverter: Button
    lateinit var currencyMoneyValue: EditText

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        currencyBase = findViewById(R.id.base_currency_value)
        baseMoney = findViewById(R.id.base_money_value)
        buttonConverter = findViewById(R.id.button_converter)
        currencyMoneyValue = findViewById(R.id.currency_money_value)

        buttonConverter.setOnClickListener {
            convertMoney()
        }

        observeListExchange()
    }

    fun convertMoney() {
        mainViewModel.convertMoney(currencyBase.text.toString(), baseMoney.text.toString())
    }

    fun observeListExchange() {
        mainViewModel.liveData.observe(this, Observer {
            var filterResult = ""
            for(result in it) {
                filterResult +=  "${result.currencyName} - ${result.currencyValue} \n"
                Log.d("MainActivity", "${result.currencyName} - ${result.currencyValue}")
            }
            currencyMoneyValue.setText(filterResult)
        })
    }

}
