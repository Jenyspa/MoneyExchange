package com.jenyspa.moneyexchange.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jenyspa.moneyexchange.R
import com.jenyspa.moneyexchange.data.model.Result

/**
 * Recebe a lista de itens e configura os viewholders para cada item
 * Um adapter pode ter mais de um viewholder
 * Precisa de uma porta de entrada para enviarmos a lista que será exibida. Pode ser no construtor
 * ou em outro método (nesse caso usamos o setList).
 * O adapter:
 *  diz quantos itens a lista tem no total (getItemCount)
 *  define que viewholder para cada posição da lista (onCreateViewHolder)
 *  chama o viewholder para fazer algo (que o adapter não sabe) naquela posição da lista (onBindViewHolder)
 */
class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var listResult: List<Result> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        // Linka o layout à um view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_main, parent, false)

        // ...e entrega a view para o viewholder
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listResult.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listResult[position])
    }

    fun setList(list: List<Result>) {
        listResult = list

        /**
         * Informa o adapter que a lista que ele tava usando mudou e é necessário recriar
         * os viewholders
         */
        notifyDataSetChanged()
    }
}
