package com.aprouxdev.marvelapp.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MarvelCharacter(@SerializedName("id")
                           val id: Int = 0,
                           @SerializedName("name")
                           val name: String = "",
                           @SerializedName("description")
                           val description: String = "",
                           @SerializedName("thumbnail")
                           val thumbnail: Thumbnail,
                           @SerializedName("comics")
                           val comics: Comics
                           ) : Serializable