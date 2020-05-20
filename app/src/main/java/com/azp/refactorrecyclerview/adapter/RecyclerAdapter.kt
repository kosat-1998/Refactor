package com.azp.refactorrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azp.refactorrecyclerview.R
import com.azp.refactorrecyclerview.model.InputText
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter(var listText: List<InputText> = ArrayList()) : RecyclerView.Adapter<RecyclerAdapter.TextItemViewHolder>() {
    fun updateList(inputText: List<InputText>){
        listText = inputText
        notifyDataSetChanged()
    }

//    var data = ArrayList<InputText>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {

//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater
//            .inflate(R.layout.item_recycler,
//                parent, false)
//
//        return TextItemViewHolder(view)

        return TextItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int = listText.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = listText[position]
        holder.bind(item)
    }

    class TextItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: InputText){
            itemView.itemInput.text = item.textInput
        }

        companion object {
            fun from(parent: ViewGroup): TextItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_recycler, parent, false)

                return TextItemViewHolder(view)
            }
        }
    }
}