package com.example.cats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cats.databinding.CatItemBinding

 class CatAdapter: RecyclerView.Adapter<CatAdapter.CatHolder> () {

    var txt = arrayOf("сиамская кошка", "обычный кот", "тигровый кот", "сфинкс", "придворный кот")
    var txt1= arrayOf("короткошерстный", "длинношерстный", "короткошерстный", "короткошерстный", "длинношерстный")
    val img = arrayOf(R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5)


    class CatHolder(item: View): RecyclerView.ViewHolder (item) {
        var txtView: TextView
        var txt1View: TextView
        var imgView: ImageView
        init {
            txtView= item.findViewById(R.id.textView)
            txt1View= item.findViewById(R.id.textView1)
            imgView= item.findViewById(R.id.imageView)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val view= LayoutInflater.from (parent.context).inflate(R.layout.cat_item, parent, false)
        return CatHolder(view)
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        holder.txtView.text=txt[position]
        holder.txt1View.text= txt1[position]
        holder.imgView.setImageResource(img[position])
    }

    override fun getItemCount(): Int {
        return txt.size
    }
}