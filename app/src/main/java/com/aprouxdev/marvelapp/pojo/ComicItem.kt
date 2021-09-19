package com.aprouxdev.marvelapp.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class ComicItem(
    @PrimaryKey
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String?,
    @SerializedName("resourceURI")
    @ColumnInfo(name = "resource_uri")
    val resourceURI: String?
) : Serializable