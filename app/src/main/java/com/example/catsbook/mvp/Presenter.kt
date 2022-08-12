package com.example.catsbook.mvp

import com.example.catsbook.ui.details.DetailPresenter
import com.example.catsbook.ui.main.MainPresenter
import org.koin.dsl.module


val presenterModule = module {
    factory { MainPresenter(get()) }
    factory { DetailPresenter(get()) }
}