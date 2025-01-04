package com.example.onelookapp.di

import androidx.room.Room
import com.example.onelookapp.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "user_database")
            .build()
    }
    single { get<AppDatabase>().userDao() }
}
