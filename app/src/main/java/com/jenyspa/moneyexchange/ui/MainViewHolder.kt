package com.jenyspa.moneyexchange.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jenyspa.moneyexchange.R
import com.jenyspa.moneyexchange.data.model.Result
import com.jenyspa.moneyexchange.ext.formatMoney

/**
 * A função do viewholder é dizer o que fazer com o item da lista.
 * Eles sempre precisam receber uma view no construtor e chamam o super passando essa view.
 * Na hora de usar, essa view que foi passando construtor se torna o atributo itemView.
 */
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