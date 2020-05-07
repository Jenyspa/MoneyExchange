package com.jenyspa.moneyexchange.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jenyspa.moneyexchange.R
import com.jenyspa.moneyexchange.data.model.Result

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var listResult: List<Result> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_main, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listResult.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listResult[position])
    }

    fun setList(it: List<Result>) {
        listResult = it
        notifyDataSetChanged()
    }

}
