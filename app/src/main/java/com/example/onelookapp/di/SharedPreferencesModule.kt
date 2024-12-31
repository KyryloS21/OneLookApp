package com.example.onelookapp.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences("SHARED_PREFERENCES_REPOSITORY", Context.MODE_PRIVATE)
    }
}
