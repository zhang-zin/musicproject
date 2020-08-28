package com.example.musicproject.data.binding

import androidx.core.view.GravityCompat
import androidx.databinding.BindingAdapter
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.musicproject.R
import com.google.android.material.tabs.TabLayout
import com.zj.architecture.ui.adapter.CommonViewPagerAdapter

@BindingAdapter(value = ["openDrawer"], requireAll = false)
fun openDrawer(drawerLayout: DrawerLayout, isOpenDrawer: Boolean) {
    if (isOpenDrawer && !drawerLayout.isDrawerOpen(GravityCompat.START)) {
        drawerLayout.openDrawer(GravityCompat.START)
    } else {
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}

@BindingAdapter(value = ["allowDrawerOpen"], requireAll = false)
fun allowDrawerOpen(drawerLayout: DrawerLayout, allowDrawer: Boolean) {
    /*
     DrawerLayout.LOCK_MODE_LOCKED_CLOSED //关闭手势滑动
     DrawerLayout.LOCK_MODE_UNLOCKED //打开手势滑动
     */
    drawerLayout.setDrawerLockMode(if (allowDrawer) DrawerLayout.LOCK_MODE_UNDEFINED else DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
}

@BindingAdapter(value = ["initTabAndPage"], requireAll = false)
fun initTabAndPage(tabLayout: TabLayout, initTabAndPage: Boolean) {
    if (initTabAndPage) {
        val tabCount = tabLayout.tabCount
        val title = arrayOfNulls<String>(tabCount)
        for (i in 0 until tabCount) {
            val tab = tabLayout.getTabAt(i)
            if (tab != null && tab.text != null) {
                title[i] = tab.text.toString()
            }
        }
        val viewPager = tabLayout.rootView.findViewById<ViewPager>(R.id.view_pager)
        viewPager?.run {
            viewPager.adapter = CommonViewPagerAdapter(tabCount, initTabAndPage, title)
            tabLayout.setupWithViewPager(viewPager)
        }
    }
}

@BindingAdapter(value = ["tabSelectedListener"], requireAll = false)
fun tabSelectedListener(tabLayout: TabLayout, listener: TabLayout.OnTabSelectedListener) {
    tabLayout.addOnTabSelectedListener(listener)
}

