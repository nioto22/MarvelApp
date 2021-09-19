package com.aprouxdev.marvelapp.pojo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity
data class Result(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("data")
    val data: Data?
)