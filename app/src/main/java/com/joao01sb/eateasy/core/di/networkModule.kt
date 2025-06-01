package com.joao01sb.eateasy.core.di

import android.content.Context
import com.joao01sb.eateasy.core.data.remote.ApiService
import com.joao01sb.eateasy.core.data.remote.MockApiServiceImpl
import org.koin.dsl.module

val networkModule = module {
    single<ApiService> {
        MockApiServiceImpl(context = get<Context>(),)
    }
}