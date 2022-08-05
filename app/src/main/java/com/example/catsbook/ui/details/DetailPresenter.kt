package com.example.catsbook.act

import com.example.catsbook.data.Cat
import moxy.MvpPresenter

class DetailPresenter: MvpPresenter<IDetailActivity>() {

    lateinit var cat: Cat

    override fun onFirstViewAttach() {
        viewState.setOfCat(cat)
    }

}