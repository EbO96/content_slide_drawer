package com.example.sebastian.contentslidedrawer

interface UpdateMenu {

    fun onUpdateMenu(position: Int, block: () -> Unit)
}