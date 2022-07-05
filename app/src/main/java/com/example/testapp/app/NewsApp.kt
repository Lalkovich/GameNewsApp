package com.example.testapp.app

import android.app.Application
import com.example.testapp.di.allModule
import com.example.testapp.di.newsApiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NewsApp:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin(){
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@NewsApp)
            modules(newsApiModule, allModule)
        }
    }
}