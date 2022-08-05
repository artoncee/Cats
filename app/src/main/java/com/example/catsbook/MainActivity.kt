package com.example.catsbook

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsbook.act.IMainActivity
import com.example.catsbook.act.MainPresenter
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



//    private lateinit var addButton: FloatingActionButton
//    private lateinit var rscView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        adapter = CatAdapter(presenter::onCatClick)
        binding.rcView.layoutManager = layoutManager
        binding.rcView.adapter=adapter

//        addButton= findViewById(R.id.addingButton)
////        addButton.setOnClickListener{addCat()}
//        rscView= findViewById<RecyclerView>(R.id.rcView)
//        rscView.layoutManager= LinearLayoutManager(this)
//        rscView.adapter= CatAdapter(this){
//            val intent = Intent(this, DetailActivity::class.java)
//            intent.putExtra(parce, it)
//            startActivity(intent)
//        }

    }
    override fun showCatList(cat_: List<Cat>) {
        adapter.setItems(cat_)
    }

    override fun openDetails(cat: Cat) {
        startActivity(DetailActivity.makeIntent(this, cat))
    }

//    private fun addCat() {
//        val inflate= LayoutInflater.from(this)
//        val v= inflate.inflate(R.layout.add_item, null)
//        val catBreed= v.findViewById<EditText>(R.id.breed1)
//        val catWool = v.findViewById<EditText>(R.id.wool1)
//        val addDialog= AlertDialog.Builder(this)
//        addDialog.setView(v)
//        addDialog.setPositiveButton("Добавить"){
//                dialog,_->
//            val breeds= catBreed.text.toString()
//            val wools= catWool.text.toString()
//            catList.add(Cat(imageId = 6, "$breeds","$wools",""))
//
//            dialog.dismiss()
//        }
//        addDialog.setNegativeButton("Не надо..."){dialog,_->
//            dialog.dismiss()
//
//        }
//        addDialog.create()
//        addDialog.show()
//
//    }

}