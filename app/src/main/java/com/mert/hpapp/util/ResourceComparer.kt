package com.mert.hpapp.util

import android.content.Context

class ResourceComparer {
    fun isEqual(c: Context, resId: Int, s: String): Boolean {
        return c.getString(resId)  == s
    }
}