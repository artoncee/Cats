package com.example.catsbook.ui.main

import com.example.catsbook.data.Cat
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface IMainActivity: MvpView {

    fun showCatList(catList: List<Cat>)

    @OneExecution
    fun openDetails(cat: Cat)

    @OneExecution
    fun addingCat()


}