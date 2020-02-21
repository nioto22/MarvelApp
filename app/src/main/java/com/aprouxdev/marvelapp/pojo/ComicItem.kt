package com.aprouxdev.marvelapp.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ComicItem(@SerializedName("name")
                     val name: String = "",
                     @SerializedName("resourceURI")
                     val resourceURI: String = "") : Serializable