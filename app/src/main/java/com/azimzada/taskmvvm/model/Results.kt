package com.azimzada.taskmvvm.model

import java.io.Serializable

data class Results (
    val Country :  String ,
    val Mfr_CommonName : String ,
    val Mfr_ID :  Int ,
    val Mfr_Name :  String ,
    var VehicleTypes : List<VehicleTypes>?
        ) :  Serializable