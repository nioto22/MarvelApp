package com.aprouxdev.marvelapp.pojo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Thumbnail(
    @SerializedName("path")
    val path: String = "",
    @SerializedName("extension")
    val extension: String = ""
) : Serializable {
    fun getUrl(): String {
        return this.path + "." + this.extension
    }

    fun getUrlLargeImage(): String {
        return this.path + "/portrait_xlarge." + this.extension
    }
}