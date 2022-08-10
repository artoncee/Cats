package com.example.catsbook.ui.details

import com.example.catsbook.data.Cat
import moxy.MvpView

interface IDetailActivity: MvpView {

    fun setOfCat(cat: Cat)

}