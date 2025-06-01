package com.joao01sb.eateasy

import android.app.Application
import com.joao01sb.eateasy.core.di.networkModule
import com.joao01sb.eateasy.features.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppAplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppAplication)
            modules(listOf(homeModule, networkModule))
        }
    }

}