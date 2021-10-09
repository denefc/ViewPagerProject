package com.cevik.viewpagerproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class WhatsAppPagerAdapter(
   private val fragmentList:List<Fragment>,
    private val fragmentTitleList:List<String>
    , fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment =  fragmentList[position]

    override fun getCount(): Int =  fragmentList.size

    //viewPager tablayout kullanımı
    override fun getPageTitle(position: Int): CharSequence? = fragmentTitleList[position]

}