package com.example.catsbook.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.catsbook.R
import com.example.catsbook.utils.Constants
import com.example.catsbook.databinding.ActivityDetailBinding
import com.example.catsbook.data.Cat
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

import org.koin.android.ext.android.get

class DetailActivity : MvpAppCompatActivity(), IDetailActivity {
    companion object {
        fun makeIntent(context: Context, cat: Cat) =
            Intent(context, DetailActivity::class.java).putExtra(Constants.Extras.CAT, cat)
    }
    private lateinit var binding: ActivityDetailBinding

    private val presenter by moxyPresenter { get<DetailPresenter>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.cat = intent.getParcelableExtra(Constants.Extras.CAT) ?: throw IllegalArgumentException("")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun setOfCat(cat: Cat) {
        binding.textDetail.text= cat.details
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.details_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.del -> {
                presenter.processDeleteClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    override fun close() {
        finish()
    }
}