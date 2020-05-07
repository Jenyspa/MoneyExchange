package com.jenyspa.moneyexchange.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jenyspa.moneyexchange.R

class MainActivity : AppCompatActivity() {

    lateinit var currencyBase: EditText
    lateinit var baseMoney: EditText
    lateinit var buttonConverter: Button
    lateinit var currencyMoneyValue: RecyclerView

    lateinit var mainViewModel: MainViewModel

    val adapter = MainAdapter()

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
        setupRecyclerView()
    }

    fun convertMoney() {
        mainViewModel.convertMoney(currencyBase.text.toString(), baseMoney.text.toString())
    }

    fun observeListExchange() {
        mainViewModel.liveData.observe(this, Observer {
            adapter.setList(it)
        })
    }

    fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        currencyMoneyValue.layoutManager = linearLayoutManager
        currencyMoneyValue.adapter = adapter
    }

}
