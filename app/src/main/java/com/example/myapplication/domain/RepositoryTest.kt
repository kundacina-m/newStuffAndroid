package com.example.myapplication.domain

import io.reactivex.Single

class RepositoryTest {

    private val data = DomainModel("Iz repository","Strava")

    fun fetchData() = Single.just(data)


    fun fetchDataparams(userId:Int,string: String) = Single.just(data)
}