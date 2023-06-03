package com.azimzada.taskmvvm.Retrofit

import com.azimzada.taskmvvm.Constants.Constants
import com.azimzada.taskmvvm.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        var instance : RetrofitClient? = null
        lateinit var api : Api
        fun getRetrofitInstance(): RetrofitClient? {
            if (instance == null) {
                instance = RetrofitClient()
                val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create<Api>(Api::class.java)
            }
            return instance
        }
    }

    fun getApi(): Api? {
        return api
    }
}