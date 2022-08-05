package com.example.catsbook.mvp

import com.example.catsbook.utils.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilsModule = module {
    single { Utils(androidContext()) }
}