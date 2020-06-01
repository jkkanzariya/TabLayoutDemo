package com.example.tablayoutdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val vFragmentList = ArrayList<Fragment>()
    private val vFragmentTitle = ArrayList<String>()
    override fun getItem(position: Int): Fragment {
        return vFragmentList.get(position)
    }

    override fun getCount()=vFragmentList.size

    override fun getPageTitle(position: Int): CharSequence {
        return vFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        vFragmentList.add(fragment)
        vFragmentTitle.add(title)
    }
}