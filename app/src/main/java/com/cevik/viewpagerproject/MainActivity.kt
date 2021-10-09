package com.cevik.viewpagerproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager:ViewPager
    private  val fragmentList: ArrayList<Fragment> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //burdan başlıyıp
        val cameraFragment = CameraFragment.newInstance()
        val callListFragment = CallListFragment.newInstance()
        val chatListFragment = ChatListFragment.newInstance()
        val statusFragment = StatusFragment.newInstance()


        fragmentList.add(cameraFragment)
        fragmentList.add(callListFragment)
        fragmentList.add(chatListFragment)
        fragmentList.add(statusFragment)

        val fragmentTitleList: ArrayList<String> = arrayListOf()
        fragmentTitleList.add("")
        fragmentTitleList.add("CHATS")
        fragmentTitleList.add("STATUS")
        fragmentTitleList.add("CALLS")

        viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val adapter = WhatsAppPagerAdapter(fragmentList, fragmentTitleList, supportFragmentManager)
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)
        //buraya kadar normal viewPager implemantasyonu
       //-----

        val tabLayoutCamera=tabLayout.getTabAt(0)
        tabLayoutCamera?.icon=ContextCompat.getDrawable(this,R.drawable.ic_camera)


        val tabLayoutChats=tabLayout.getTabAt(1)
        tabLayoutChats?.text="CHATS"


        val tabLayoutStatus=tabLayout.getTabAt(2)
        tabLayoutStatus?.text="STATUS"


        val tabLayoutCallList=tabLayout.getTabAt(3)
        tabLayoutCallList?.text="CALLS"




        //javadan gördüğümüz ananymous interface kullanımı yapıyoruz
       viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
           //2 & 3 eğer elle kaydırırsak 2 tıklarsak 3. olarak çalışır
           override fun onPageScrolled(
               position: Int,
               positionOffset: Float,
               positionOffsetPixels: Int
           ) {
               val title=(viewPager.adapter as WhatsAppPagerAdapter).getPageTitle(position)
               "OnPageScrolled" showLog "title= $title"
           }
           //3 & 2 eğer elle kaydırırsak 3 tıklarsak 2. olarak çalışır
           override fun onPageSelected(position: Int) {
               "onPageSelected" showLog "title= $title"
           }

           //1 & 1
           override fun onPageScrollStateChanged(state: Int) {
               "onPageScrollStateChanged" showLog " state= $state"
           }

       })
        //geçiş animasyonu örneği
        viewPager.setPageTransformer(true,ZoomOutPageTransformer())

        //Default olarak bu indexten başlaması için
        viewPager.currentItem=1


    }

    override fun onBackPressed() {


        if (viewPager.currentItem==0){
            super.onBackPressed()
        }else{
            viewPager.currentItem=fragmentList.size-1
        }

    }
}

infix fun String.showLog(text:String){
    Log.e(this,text)
}