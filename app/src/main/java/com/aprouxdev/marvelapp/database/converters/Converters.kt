package com.aprouxdev.marvelapp.database.converters

import androidx.room.TypeConverter
import com.aprouxdev.marvelapp.database.AppDatabase
import com.aprouxdev.marvelapp.pojo.ComicItem
import com.aprouxdev.marvelapp.pojo.Comics
import com.aprouxdev.marvelapp.pojo.Thumbnail

/*
* Created by antoine on 19.09.21.
*/

class Converters {
    @TypeConverter
    fun thumbnailToString(image: Thumbnail?): String? {
        return image?.let {
            return it.getUrl()
        }
    }

    @TypeConverter
    fun fromString(url: String?): Thumbnail? {
        return url?.let {
            val splitSize = url.split(".").size
            if (splitSize >= 2)
            Thumbnail(
                path = url.split(".")[splitSize - 2],
                extension = url.split(".")[splitSize - 1]
            )
            else
                null
        }
    }


    @TypeConverter
    fun comicsToString(comics: Comics?): String? {
        return comics?.collectionURI
    }


    @TypeConverter
    fun itemsToStrings(comicItems: List<ComicItem?>?): List<String?>? {
        return comicItems?.map { it?.resourceURI }
    }
}