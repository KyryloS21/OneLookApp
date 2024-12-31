package com.example.onelookapp

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        /*FirebaseApp.initializeApp(this)
        startKoin {
            androidContext(this@MyApplication)
            modules(
                databaseModule, repositoryModule, sharedPreferencesModule, viewModelModule,
                userRepositoryModule
            )
        }*/
    }
}