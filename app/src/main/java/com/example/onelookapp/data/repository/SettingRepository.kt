package com.example.onelookapp.data.repository

interface SettingRepository {

    fun getWatchOnBoarding():Boolean
    fun setWatchOnBoarding(isWatched:Boolean)
    fun getAuth():Boolean
    fun setAuth(isAuth:Boolean)

}
