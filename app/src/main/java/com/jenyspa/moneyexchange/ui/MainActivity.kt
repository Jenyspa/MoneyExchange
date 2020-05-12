package com.jenyspa.moneyexchange.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jenyspa.moneyexchange.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var currencyBase: EditText
    lateinit var baseMoney: EditText
    lateinit var buttonConverter: Button
    lateinit var currencyMoneyValue: RecyclerView

    val mainViewModel: MainViewModel by viewModel()

    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        /**
         * LayoutManager define como os itens da lista serão apresentados (verticalmente,
         * horizontalmente, em grid etc.)
         * Tem ligação com os ViewGroups
         */
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        currencyMoneyValue.layoutManager = linearLayoutManager

        currencyMoneyValue.adapter = adapter
    }
}
