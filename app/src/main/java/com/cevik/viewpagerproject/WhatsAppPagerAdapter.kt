package com.cevik.viewpagerproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter



//PagerAdapter->                RecyclerView.Adapter

//FragmentPagerAdapter->        FragmentStateAdapter
//FragmentStateAdapter->        FragmentStateAdapter
class WhatsAppPagerAdapter(
   private val fragmentList:List<Fragment>
    , fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int =fragmentList.size


    override fun createFragment(position: Int): Fragment =fragmentList[position]


}