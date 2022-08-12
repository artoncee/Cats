package com.example.catsbook.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbook.R
import com.example.catsbook.utils.replaceWith
import com.example.catsbook.databinding.CatItemBinding

class CatAdapter (private val listener : (Int) -> Unit,
                  private val onItemDeleteClick: (Int) -> Unit): RecyclerView.Adapter<CatAdapter.CatHolder>() {
    private val cats = mutableListOf<Cat>()



    class CatHolder private constructor(private val binding: CatItemBinding,
                                        private val listener : (Int) -> Unit,
                                        private val onItemDeleteClick: (Int) -> Unit):
        RecyclerView.ViewHolder(binding.root){
        companion object {
            fun create(parent: ViewGroup, listener: (Int) -> Unit, onItemDeleteClick: (Int) -> Unit): CatHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CatItemBinding.inflate(layoutInflater, parent, false)
                return CatHolder(binding, listener, onItemDeleteClick)
            }
        }
        private val arr= arrayOf(R.drawable.cat1,R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5)

        fun bindView (cat: Cat){
            binding.textView.text=cat.breed
            binding.textView1.text=cat.woolLength
            binding.deleteImageView.setOnClickListener{onItemDeleteClick.invoke(adapterPosition)}
            binding.imageView.setImageResource(arr[adapterPosition%5])
        }
        init {
            itemView.setOnClickListener { listener.invoke(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CatHolder.create(parent, listener, onItemDeleteClick)

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        holder.bindView(cats[position])
    }

    override fun getItemCount(): Int = cats.size

    fun setItems(items: List<Cat>) {
        this.cats.replaceWith(items)
        notifyDataSetChanged()
    }
    fun sortBreed (){
        cats.sortBy { it.breed.lowercase() }
        notifyDataSetChanged()

    }
    fun sortLength(){
        cats.sortWith(compareBy{it.breed.length})
        notifyDataSetChanged()
    }
}