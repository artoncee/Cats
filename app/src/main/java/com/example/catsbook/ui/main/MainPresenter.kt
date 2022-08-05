package com.example.catsbook.act

import com.example.catsbook.utils.Utils
import com.example.catsbook.data.Cat
import moxy.MvpPresenter

class MainPresenter(private val utils: Utils): MvpPresenter<IMainActivity>() {
    private lateinit var catList: List<Cat>
    override fun onFirstViewAttach() {

        catList = utils.getJSON()
        viewState.showCatList(catList)
    }

    fun onCatClick(position: Int) {
        viewState.openDetails(catList[position])
    }
}