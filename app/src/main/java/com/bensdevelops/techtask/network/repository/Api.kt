package com.bensdevelops.techtask.network.repository

import com.bensdevelops.techtask.network.model.PropertyDto
import com.bensdevelops.techtask.network.model.PropertyListDto
import retrofit2.http.GET

interface Api {

    @GET("properties.json")
    suspend fun get(): Result<PropertyListDto>
}