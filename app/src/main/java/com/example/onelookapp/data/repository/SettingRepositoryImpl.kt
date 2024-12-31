package com.example.onelookapp.data.repository

import android.content.SharedPreferences

const val WATCH_ON_BOARDING = "watch_on_boarding"
const val AUTH = "auth"
class SettingRepositoryImpl(private val sharedPref: SharedPreferences) : SettingRepository {
    private val editor:SharedPreferences.Editor = sharedPref.edit()
    override fun getWatchOnBoarding(): Boolean {
        return sharedPref.getBoolean(WATCH_ON_BOARDING,false)
    }

    override fun setWatchOnBoarding(isWatched: Boolean) {
        editor.putBoolean(WATCH_ON_BOARDING, isWatched).apply()
    }

    override fun getAuth(): Boolean {
        return sharedPref.getBoolean(AUTH,false)
    }

    override fun setAuth(isAuth: Boolean) {
        editor.putBoolean(AUTH, isAuth).apply()
    }
}