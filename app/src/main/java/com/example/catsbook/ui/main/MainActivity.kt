package com.example.catsbook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsbook.ui.details.DetailActivity
import com.example.catsbook.R
import com.example.catsbook.databinding.ActivityMainBinding
import com.example.catsbook.data.Cat
import com.example.catsbook.data.CatAdapter
import com.example.catsbook.databinding.ActivityDetailBinding
import com.example.catsbook.databinding.AddItemBinding
import com.example.catsbook.databinding.CatItemBinding
import com.example.catsbook.utils.Utils
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
        adapter = CatAdapter(presenter::onCatClick,  presenter::processDeleteClick)
        binding.rcView.layoutManager = layoutManager
        binding.rcView.adapter=adapter
        binding.addingButton.setOnClickListener{addingCat()}
    }
    override fun showCatList(cat_: List<Cat>) {
        adapter.setItems(cat_)
    }

    override fun openDetails(cat: Cat) {
        startActivity(DetailActivity.makeIntent(this, cat))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.sortBreed-> adapter.sortBreed()
            R.id.sortLength->adapter.sortLength()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun addingCat() {
        val dialog = android.app.AlertDialog.Builder(this)
        val dialogView= AddItemBinding.inflate(layoutInflater)
        dialog.setNegativeButton("Не надо...") { d, _ ->
            d.dismiss()
        }
        dialog.setPositiveButton("Добавить") { d, _ ->
            if(dialogView.breed1.text.isNotEmpty()&& dialogView.wool1.text.isNotEmpty()){
                presenter.processDialogButtonClick(
                    dialogView.breed1.text.toString(),
                    dialogView.wool1.text.toString(),
                    dialogView.detail1.text.toString()
                )
            }
            else Toast.makeText(this, "Заполните первые 2 поля", Toast.LENGTH_SHORT).show()
            d.dismiss()
        }
        dialog.setView(dialogView.root)
        dialog.show()
    }
}