package com.mert.hpapp.network

import com.mert.hpapp.data.CharHP
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RetrofitService {
    // Define functions that return data as observables
    @GET("characters")
    fun getAllCharacters(): Observable<ArrayList<CharHP>>

    @GET("characters/students")
    fun getStudents(): Observable<ArrayList<CharHP>>

    @GET("characters/staff")
    fun getStaff(): Observable<ArrayList<CharHP>>
}