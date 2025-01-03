package com.example.onelookapp.ui.home.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onelookapp.R
import com.example.onelookapp.databinding.FragmentHomeBinding
import com.example.onelookapp.ui.home.fragments.home.adapter.HealthStatsAdapter
import com.example.onelookapp.ui.home.fragments.home.model.HealthStat
import com.example.onelookapp.ui.home.fragments.home.model.HealthStatType


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = HealthStatsAdapter {}
    private val listHealthStat = listOf(
        HealthStat(
            R.drawable.ic_breath_rate_bgr,
            R.color.Violet_Light,
            "requireActivity().getString(R.string.breath_rate)",
            "12",
            HealthStatType.BREATH
        ), HealthStat(
            R.drawable.ic_breath_rate_bgr,
            R.color.Violet,
            "requireActivity().getString(R.string.breath_rate)",
            "123",
            HealthStatType.BREATH
        ), HealthStat(
            R.drawable.ic_breath_rate_bgr,
            R.color.Dust_Grey,
            "requireActivity().getString(R.string.breath_rate)",
            "124",
            HealthStatType.BREATH
        )

    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        binding.rvStates.adapter = adapter
        binding.rvStates.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter.submitList(listHealthStat)
    }


}