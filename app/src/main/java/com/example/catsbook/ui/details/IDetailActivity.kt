package com.example.catsbook.act

import com.example.catsbook.data.Cat
import moxy.MvpView

interface IDetailActivity: MvpView {

    fun setOfCat(cat: Cat)

}