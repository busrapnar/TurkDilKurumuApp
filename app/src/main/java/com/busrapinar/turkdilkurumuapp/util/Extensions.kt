package com.busrapinar.turkdilkurumuapp.util

import android.view.View

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

infix fun View.visibleIf(b: Boolean) {
    if (b) this.visible() else this.gone()
}