package com.example.onelookapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.onelookapp.R
import com.example.onelookapp.databinding.ActivityHomeBinding
import com.example.onelookapp.ui.home.fragments.ActivityFragment
import com.example.onelookapp.ui.home.fragments.home.HomeFragment
import com.example.onelookapp.ui.home.fragments.ProgressFragment
import com.example.onelookapp.ui.home.fragments.SettingsFragment

class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding()
        setupBottomNavigation()
    }
    private fun setupViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupBottomNavigation() {
        loadFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.home -> HomeFragment()
                R.id.activity -> ActivityFragment()
                R.id.progress -> ProgressFragment()
                R.id.settings -> SettingsFragment()
                else -> HomeFragment()
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}