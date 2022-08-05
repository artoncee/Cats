package com.example.catsbook

import android.app.Application
import com.example.catsbook.mvp.presenterModule
import com.example.catsbook.mvp.utilsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(presenterModule, utilsModule))
        }
    }

}