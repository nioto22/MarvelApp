package com.aprouxdev.marvelapp.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity
data class Comics(
    @PrimaryKey
    @ColumnInfo( name = "collection_uri")
    @SerializedName("collectionURI")
    val collectionURI: String = "",
    @ColumnInfo( name = "available")
    @SerializedName("available")
    val available: Int = 0,
    @ColumnInfo( name = "returned")
    @SerializedName("returned")
    val returned: Int = 0,
    @ColumnInfo( name = "items")
    @SerializedName("items")
    val items: List<String?>?
) : Serializable