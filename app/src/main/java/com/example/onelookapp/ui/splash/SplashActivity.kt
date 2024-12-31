package com.example.onelookapp.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.onelookapp.data.repository.SettingRepository
import com.example.onelookapp.databinding.ActivitySplashBinding
/*import com.example.onelookapp.ui.home.HomeActivity
import com.example.onelookapp.ui.auth.AuthActivity
import com.example.onelookapp.ui.onboarding.OnBoardingActivity*/
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val settingRepository: SettingRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvStart.setOnClickListener {
            //startActivity(Intent(this, AuthActivity::class.java))
        }
        //settingRepository.setWatchOnBoarding(false)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            /*if (settingRepository.getWatchOnBoarding()){
                if (settingRepository.getAuth()){
                    startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    startActivity(Intent(this, AuthActivity::class.java))
                }
            }else{
                startActivity(Intent(this, OnBoardingActivity::class.java))

            }*/
        }, 1000)
    }
}