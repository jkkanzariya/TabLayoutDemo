package com.example.tablayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(ChatFragment(), "Chat")
        adapter.addFragment(CallFragment(), "Call")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        val exampleList = generateDummyList(500)
        recyler_view.adapter = RecyclerViewAdapter(exampleList)
        recyler_view.layoutManager = LinearLayoutManager(this)
        recyler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 1 until size) {
            val drawable = when (i % 2) {
                0 -> R.drawable.ic_launcher_foreground
                else -> R.drawable.ic_launcher_background
            }
            val item = ExampleItem(drawable, "Title $i", "Description")
            list += item
        }
        return list
    }
}