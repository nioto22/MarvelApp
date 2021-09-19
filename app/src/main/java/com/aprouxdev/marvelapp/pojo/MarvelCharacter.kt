package com.aprouxdev.marvelapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class MarvelCharacter(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("comics")
    val comics: String?
) : Serializable


data class CharacterMinimal(
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,

)