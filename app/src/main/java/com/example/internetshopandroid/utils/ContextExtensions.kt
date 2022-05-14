package com.example.internetshopandroid.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

fun Context.loadDrawable(id: Int): Drawable? {
    return ResourcesCompat.getDrawable(resources, id, null)
}