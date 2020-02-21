package com.aprouxdev.marvelapp.pojo

import com.google.gson.annotations.SerializedName

data class Result(@SerializedName("code")
                  val code: Int = 0,
                  @SerializedName("data")
                  val data: Data)