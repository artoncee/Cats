package com.example.catsbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.catsbook.act.DetailPresenter
import com.example.catsbook.act.IDetailActivity
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
        setContentView(R.layout.activity_detail)

        presenter.cat = intent.getParcelableExtra(Constants.Extras.CAT) ?: throw IllegalArgumentException("")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun setOfCat(cat: Cat) {
        binding.textDetail.text= cat.details
//        binding.imageDetail.setImageResource(cat.imageId)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
//
//        val cat= intent.getParcelableExtra<Cat>(MainActivity.parce)
//
//        val img = findViewById<ImageView>(R.id.imageDetail)
//        val txt= findViewById<TextView>(R.id.textDetail)
//
//        if (cat != null) {
//            img.setImageResource(cat.imageId)
//        }
//        if (cat != null) {
//            txt.text= cat.details
//        }
//    }
}