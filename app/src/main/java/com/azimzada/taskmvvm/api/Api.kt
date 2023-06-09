package com.azimzada.taskmvvm.api

import com.azimzada.taskmvvm.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("api/vehicles/getallmanufacturers")
    fun getData(@Query("format") format: String): Call<Data?>?

    @GET("GetMakeForManufacturer/{manufacturer}")
    fun getMakeForManufacturer(
        @Path("manufacturer") manufacturer: String,
        @Query("format") format: String
    ): Call<Data?>?
}