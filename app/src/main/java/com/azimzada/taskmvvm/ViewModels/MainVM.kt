package com.azimzada.taskmvvm.ViewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azimzada.taskmvvm.Retrofit.RetrofitClient
import com.azimzada.taskmvvm.api.Api
import com.azimzada.taskmvvm.model.Data
import com.azimzada.taskmvvm.model.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainVM : ViewModel(){
    lateinit var  data : Data
    lateinit var api: Api
    var result = MutableLiveData<Data>()

    fun getData(context: Context, key: String) {
        var call = RetrofitClient
            .getRetrofitInstance()?.getApi()?.getData(key)
        call?.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                result.value = response.body()

            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Log.d("Error " , "T error ")
            }

        } )
    }
    fun getSearch(context: Context ,  search :  String)
    {
        var call = RetrofitClient
            .getRetrofitInstance()?.getApi()?.getMakeForManufacturer(search , "format=json")
        call?.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                result.value = response.body()
            }
            override fun onFailure(call: Call<Data?>, t: Throwable) {

            }
        } )
    }
    fun  observResult()  : LiveData<Data>
    {
        return  result
    }
}