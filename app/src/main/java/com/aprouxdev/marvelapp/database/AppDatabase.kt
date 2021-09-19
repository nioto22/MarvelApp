package com.aprouxdev.marvelapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aprouxdev.marvelapp.database.converters.Converters
import com.aprouxdev.marvelapp.database.dao.CharacterDao
import com.aprouxdev.marvelapp.pojo.*

/*
* Created by antoine on 19.09.21.
*/

@Database(
    entities =
    arrayOf(
        MarvelCharacter::class,
        ComicItem::class,
        Comics::class,
        Data::class,
        Result::class,
        Thumbnail::class
    ),
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "Sample.db")
                .addTypeConverter(Converters::class.java)
                .build()
    }
}