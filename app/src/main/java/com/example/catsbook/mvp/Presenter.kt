package com.example.catsbook.mvp

import com.example.catsbook.act.DetailPresenter
import com.example.catsbook.act.MainPresenter
import org.koin.dsl.module


val presenterModule = module {
    factory { MainPresenter(get()) }
    factory { DetailPresenter() }
}