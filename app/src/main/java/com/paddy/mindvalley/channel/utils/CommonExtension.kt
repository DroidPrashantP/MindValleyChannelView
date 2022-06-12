package com.paddy.mindvalley.channel.utils

fun Boolean?.isNotNullAndTrue(): Boolean {
    return this != null && this
}

fun <E> Collection<E>?.isListNotEmpty(): Boolean {
    return this != null && this.isNotEmpty()
}