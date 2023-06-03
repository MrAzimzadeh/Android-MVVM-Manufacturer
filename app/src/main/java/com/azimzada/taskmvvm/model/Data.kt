package com.azimzada.taskmvvm.model

data class Data(
    var Count : Int,
    val Message : String ,
    val SearchCriteria :  String,
    val Results  :List<Results>,
)
