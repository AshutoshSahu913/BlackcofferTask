package com.example.blackcoffertask.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blackcoffertask.Adapters.ViewPagerAdapter
import com.example.blackcoffertask.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayoutMediator

class ExploreFragment : Fragment() {

    lateinit var binding: FragmentExploreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(inflater, container, false)

        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter


        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
    }
}