package com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.repositories

import com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLives() = retrofitService.getAllLives()

}