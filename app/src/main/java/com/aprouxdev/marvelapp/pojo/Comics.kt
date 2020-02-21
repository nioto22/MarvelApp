package com.aprouxdev.marvelapp.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Comics(@SerializedName("collectionURI")
                  val collectionURI: String = "",
                  @SerializedName("available")
                  val available: Int = 0,
                  @SerializedName("returned")
                  val returned: Int = 0,
                  @SerializedName("items")
                  val items: List<ComicItem>?) : Serializable