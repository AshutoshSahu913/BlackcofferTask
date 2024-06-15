package com.example.blackcoffertask.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.blackcoffertask.Fragments.BusinessesFragment
import com.example.blackcoffertask.Fragments.PersonalFragment
import com.example.blackcoffertask.Fragments.Servicesfragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragments = arrayOf(PersonalFragment(), Servicesfragment(), BusinessesFragment())
    private val fragmentTitles = arrayOf("Personal", "Services", "Businesses")

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getTitle(position: Int): String = fragmentTitles[position]
}
