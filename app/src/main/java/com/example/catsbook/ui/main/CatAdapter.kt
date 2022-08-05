package com.example.catsbook.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbook.utils.replaceWith
import com.example.catsbook.databinding.CatItemBinding

class CatAdapter (private val listener : (Int) -> Unit): RecyclerView.Adapter<CatAdapter.CatHolder>() {
    private val cats = mutableListOf<Cat>()

    class CatHolder private constructor(private val binding: CatItemBinding,private val listener : (Int) -> Unit):
        RecyclerView.ViewHolder(binding.root){
        companion object {
            fun create(parent: ViewGroup, listener: (Int) -> Unit): CatHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CatItemBinding.inflate(layoutInflater, parent, false)
                return CatHolder(binding, listener)
            }
        }

        fun bindView (cats: Cat){
//            binding.imageView.setImageResource(cats.imageId)
            binding.textView.text=cats.breed
            binding.textView1.text=cats.woolLength
        }
        init {
            itemView.setOnClickListener { listener.invoke(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CatHolder.create(parent, listener)

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        holder.bindView(cats[position])
    }

    override fun getItemCount(): Int = cats.size

    fun setItems(items: List<Cat>) {
        this.cats.replaceWith(items)
        notifyDataSetChanged()
    }
}