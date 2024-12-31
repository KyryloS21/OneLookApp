package com.example.onelookapp.di

import com.example.onelookapp.data.repository.UserRepository
import org.koin.dsl.module

val userRepositoryModule = module {
    single { UserRepository(get()) }
}