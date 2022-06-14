package com.paddy.mindvalley.channel.utils

import android.view.View

fun Boolean?.isNotNullAndTrue(): Boolean {
    return this != null && this
}

fun <E> Collection<E>?.isListNotEmpty(): Boolean {
    return this != null && this.isNotEmpty()
}

fun View?.show(){
    this?.visibility = View.VISIBLE
}

fun View?.gone(){
    this?.visibility = View.GONE
}