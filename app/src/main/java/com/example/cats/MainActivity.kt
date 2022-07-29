package com.example.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private  var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerView.Adapter<CatAdapter.CatHolder>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init () = with (binding){
        layoutManager=LinearLayoutManager(this@MainActivity)
        rcView.layoutManager= layoutManager
        adapter= CatAdapter()
        rcView.adapter= adapter

    }
}