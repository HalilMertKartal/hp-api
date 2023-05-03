package com.mert.hpapp

import com.mert.hpapp.data.CharHP
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock


class MainActivityViewModelTest {
    @Mock
    private lateinit var vm: MainActivityViewModel
    @Mock
    private lateinit var elements: ArrayList<CharHP>
    @Mock
    private lateinit var charHP: CharHP
    @Mock
    private lateinit var charHPv2: CharHP

    @Before
    fun setup() {
        vm = MainActivityViewModel()
        @Mock
        charHP = CharHP(
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
            "mock",
        )
        @Mock
        charHPv2 = CharHP(
            "mock2",
            "mock2",
            "mock2",
            "mock2",
            "mock2",
            "mock2",
            "mock2",
            "mock2",
            "mock2",
        )


        elements = arrayListOf(
            charHP,
            charHP,
            charHP
        )
    }

    @After
    fun teardown() {
        elements.clear()
    }

    @Test
    fun `empty list returns false`() {
        val result = vm.validateCharHPList(arrayListOf())
        assertEquals(result, false)
    }
    @Test
    fun `non empty list returns true`() {
        val result = vm.validateCharHPList(elements)
        assertEquals(result, true)
    }

    @Test
    fun `null list returns false`() {
        val result = vm.validateCharHPList(null)
        assertEquals(result, false)
    }

    @Test
    fun `null selected CharHP returns false`() {
        val result = vm.validateSelectedCharHP(null, elements)
        assertEquals(result, false)
    }

    @Test
    fun `selected CharHP not in list returns false`() {
        val result = vm.validateSelectedCharHP(charHPv2, elements)
        assertEquals(result, false)
    }

    @Test
    fun `legit CharHP returns true`() {
        val result = vm.validateSelectedCharHP(charHP, elements)
        assertEquals(result, true)
    }
}