package com.example.catsbook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsbook.ui.details.DetailActivity
import com.example.catsbook.R
import com.example.catsbook.databinding.ActivityMainBinding
import com.example.catsbook.data.Cat
import com.example.catsbook.data.CatAdapter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get


class MainActivity: MvpAppCompatActivity(), IMainActivity {


    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { get<MainPresenter>() }
    private lateinit var adapter: CatAdapter
    private lateinit var layoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        adapter = CatAdapter(presenter::onCatClick)
        binding.rcView.layoutManager = layoutManager
        binding.rcView.adapter=adapter
        binding.addingButton.setOnClickListener{addCat()}
    }
    override fun showCatList(cat_: List<Cat>) {
        adapter.setItems(cat_)
    }

    override fun openDetails(cat: Cat) {
        startActivity(DetailActivity.makeIntent(this, cat))
    }
    private val cats = mutableListOf<Cat>()


    private fun addCat() {
        val inflate= LayoutInflater.from(this)
        val v= inflate.inflate(R.layout.add_item, null)
        val catBreed= v.findViewById<EditText>(R.id.breed1)
        val catWool = v.findViewById<EditText>(R.id.wool1)
        val catDetails= v.findViewById<EditText>(R.id.detail1)
        val addDialog= AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Добавить"){
                dialog,_->
            val breeds= catBreed.text.toString()
            val wools= catWool.text.toString()
            val detail= catDetails.text.toString()
            cats.add(Cat( "$breeds","$wools","$detail"))
            adapter.setItems(cats)
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Не надо..."){dialog,_->
            dialog.dismiss()
        }
        addDialog.create()
        addDialog.show()
    }
}