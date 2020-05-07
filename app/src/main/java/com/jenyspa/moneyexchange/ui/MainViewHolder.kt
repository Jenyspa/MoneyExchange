package com.jenyspa.moneyexchange.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jenyspa.moneyexchange.R
import com.jenyspa.moneyexchange.data.model.Result
import com.jenyspa.moneyexchange.ext.formatMoney

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    lateinit var money: TextView
    lateinit var currency: TextView

    fun bind(result: Result) {
        money = itemView.findViewById(R.id.money_view_holder)
        currency = itemView.findViewById(R.id.currency_view_holder)

        money.text = result.currencyName
        currency.text = result.currencyValue.formatMoney()
    }
}