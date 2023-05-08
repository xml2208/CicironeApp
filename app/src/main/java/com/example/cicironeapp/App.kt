package com.example.cicironeapp

import android.app.Application
import com.example.cicironeapp.koin.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@App)
            modules(allModules)
        }
    }
}