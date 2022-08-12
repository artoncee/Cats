package com.example.catsbook.ui.main

import com.example.catsbook.utils.Utils
import com.example.catsbook.data.Cat
import com.example.catsbook.data.CatAdapter
import moxy.MvpPresenter
import java.util.*
import kotlin.Comparator

class MainPresenter(private val utils: Utils): MvpPresenter<IMainActivity>() {
    private lateinit var catList: MutableList<Cat>

    override fun attachView(view: IMainActivity?) {
        super.attachView(view)
        catList = utils.getList()
        viewState.showCatList(catList)
    }

    fun processDialogButtonClick(breed: String, whool: String, detail: String) {
        catList.add(Cat(breed, whool, detail))
        utils.saveList(catList)
        viewState.showCatList(catList)
    }

    fun onCatClick(position: Int) {
        viewState.openDetails(catList[position])
    }

    fun processDeleteClick(position: Int) {
        catList.removeAt(position)
        utils.saveList(catList)
        viewState.showCatList(catList)
    }
}