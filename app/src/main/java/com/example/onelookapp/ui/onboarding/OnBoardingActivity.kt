package com.example.onelookapp.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onelookapp.R
import com.example.onelookapp.data.repository.SettingRepository
import com.example.onelookapp.databinding.FragmentOnBoardingBinding
import com.example.onelookapp.ui.onboarding.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: FragmentOnBoardingBinding
    private val settingRepository: SettingRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        val adapter = PagerAdapter(
            listOf(
                R.layout.page_one_layout,
                R.layout.page_two_layout,
                R.layout.page_three_layout
            ),
            this
        )

        with(binding) {
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

            tvArrow.setOnClickListener {
                val currentItem = viewPager.currentItem
                val itemCount = adapter.itemCount
                if (currentItem < itemCount - 1) {
                    viewPager.currentItem = currentItem + 1
                }
            }
            skipIntro.setOnClickListener {
                settingRepository.setWatchOnBoarding(true)
            }
        }


    }


}
