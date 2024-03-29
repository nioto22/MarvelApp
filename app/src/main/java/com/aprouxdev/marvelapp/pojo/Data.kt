package com.aprouxdev.marvelapp.pojo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
//@Entity
data class Data(
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("offset")
    val offset: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<MarvelCharacter>?
)