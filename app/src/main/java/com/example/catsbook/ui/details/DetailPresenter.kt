package com.example.catsbook.ui.details

import com.example.catsbook.data.Cat
import moxy.MvpPresenter

class DetailPresenter: MvpPresenter<IDetailActivity>() {

    lateinit var cat: Cat

    override fun onFirstViewAttach() {
        viewState.setOfCat(cat)
    }
}