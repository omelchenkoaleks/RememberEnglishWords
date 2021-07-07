package com.omelchenkoaleks.rememberenglishwords.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.omelchenkoaleks.rememberenglishwords.data.models.AppWords

@Dao
interface AppRoomDao {

    @Query("SELECT * from words_table")
    fun getAllWords(): LiveData<List<AppWords>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: AppWords)

    @Delete
    suspend fun deleteWord(word: AppWords)

}