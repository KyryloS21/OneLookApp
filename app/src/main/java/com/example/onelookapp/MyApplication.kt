package com.example.onelookapp

import android.app.Application
import com.example.onelookapp.di.databaseModule
import com.example.onelookapp.di.repositoryModule
import com.example.onelookapp.di.sharedPreferencesModule
import com.example.onelookapp.di.userRepositoryModule
import com.example.onelookapp.di.viewModelModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        startKoin {
            androidContext(this@MyApplication)
            modules(
                databaseModule, repositoryModule, sharedPreferencesModule, viewModelModule,
                userRepositoryModule
            )
        }
    }
}