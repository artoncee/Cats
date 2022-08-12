package com.example.catsbook.ui.details

import com.example.catsbook.data.Cat
import com.example.catsbook.utils.Utils
import moxy.MvpPresenter

class DetailPresenter(private val utils: Utils): MvpPresenter<IDetailActivity>() {

    lateinit var cat: Cat

    override fun onFirstViewAttach() {
        viewState.setOfCat(cat)
    }
    fun processDeleteClick() {
        utils.deleteCat(cat)
        viewState.close()
    }
}