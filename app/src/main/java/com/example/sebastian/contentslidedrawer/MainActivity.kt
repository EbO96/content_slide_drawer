package com.example.sebastian.contentslidedrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_activity_content.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slideDrawer({
            itemsDividerEnabled = true
            menuShowHideAnimation = false
            drawerTitle = "Spis treści"
        }, {

            getContentView()?.setOnClickListener {
                if (isOpen()) close() else open()
            }

            setMenu(arrayListOf<SlideDrawer.DrawerMenuItem>().apply {
                add(SlideDrawer.DrawerMenuItem("element 1", "subtitle 1"))
                add(SlideDrawer.DrawerMenuItem("element 2", ""))
                add(SlideDrawer.DrawerMenuItem("element 3", "subtitle 3"))
                add(SlideDrawer.DrawerMenuItem("element 4", "subtitle 4"))
                add(SlideDrawer.DrawerMenuItem("element 5", "subtitle 5"))
            }, GlobalMenuTheme(titleColorSelected = R.color.colorAccent, subtitleColorSelected = R.color.colorAccent))

            setMenuItemClickListener(object : SlideDrawer.MenuItemsClickListener {
                override fun onClick(position: Int, drawerMenuItem: SlideDrawer.DrawerMenuItem) {
                    contentTextView.text = drawerMenuItem.title
                }
            })
        })
    }
}
