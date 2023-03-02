package com.example.criminallntent

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val a=CrimeListViewModel()
    @Test

    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_list(){
        assertEquals(100,a.crimes.size)
    }
    @Test
    fun test_type(){
        val adp=CrimeListAdapter(a.crimes)
        assertEquals(1,adp.getItemViewType(1))
    }
}