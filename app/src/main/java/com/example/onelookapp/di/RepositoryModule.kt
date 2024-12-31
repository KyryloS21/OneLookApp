package com.example.onelookapp.di

import com.example.onelookapp.data.repository.SettingRepository
import com.example.onelookapp.data.repository.SettingRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<SettingRepository> { SettingRepositoryImpl(get()) }
}
