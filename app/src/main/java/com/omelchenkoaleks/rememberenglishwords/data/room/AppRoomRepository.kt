package com.omelchenkoaleks.rememberenglishwords.data.room

import androidx.lifecycle.LiveData
import com.omelchenkoaleks.rememberenglishwords.data.models.AppWords
import com.omelchenkoaleks.rememberenglishwords.data.DatabaseRepository

class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {

    override val allWords: LiveData<List<AppWords>>
        get() = appRoomDao.getAllWords()

    override suspend fun insertWord(word: AppWords, onSuccess: () -> Unit) {
        appRoomDao.deleteWord(word)
        onSuccess()
    }

    override suspend fun deleteWord(word: AppWords, onSuccess: () -> Unit) {
        appRoomDao.deleteWord(word)
        onSuccess()
    }

}