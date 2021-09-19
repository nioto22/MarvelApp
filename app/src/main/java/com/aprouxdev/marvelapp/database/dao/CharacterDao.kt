package com.aprouxdev.marvelapp.database.dao

import androidx.room.*
import com.aprouxdev.marvelapp.pojo.CharacterMinimal
import com.aprouxdev.marvelapp.pojo.MarvelCharacter

/*
* Created by antoine on 19.09.21.
*/
@Dao
interface CharacterDao {

    @Transaction
    open fun updateData(characters: List<MarvelCharacter>) {
        deleteAllUsers()
        insertAll(characters)
    }

    @Insert
    fun insertAll(users: List<MarvelCharacter>)
    @Query("DELETE FROM MarvelCharacter")
    fun deleteAllUsers()

    @Query("SELECT * FROM MarvelCharacter")
    fun getAllCharacters(): List<MarvelCharacter>

    @Query("SELECT * FROM MarvelCharacter WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): MarvelCharacter


    @Query("SELECT id, name, thumbnail FROM MarvelCharacter")
    fun getCharacterMinimal(): List<CharacterMinimal>



    /*@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User
     */
}