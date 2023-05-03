package com.mert.hpapp.util

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.mert.hpapp.R
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock

class ResourceComparerTest {
    @Mock
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun isStringResourceSameAsString_ReturnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result =  resourceComparer.isEqual(context, R.string.app_name, "HPApp")
        assertEquals(true, result)
    }

    @Test
    fun isStringResourceDifferentFromString_ReturnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result =  resourceComparer.isEqual(context, R.string.app_name, "yannis")
        assertEquals(false, result)
    }
}