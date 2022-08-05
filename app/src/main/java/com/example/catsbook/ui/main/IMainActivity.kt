package com.example.catsbook.act

import com.example.catsbook.data.Cat
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface IMainActivity: MvpView {

    fun showCatList(catlist: List<Cat>)

    @OneExecution
    fun openDetails(cat: Cat)

}