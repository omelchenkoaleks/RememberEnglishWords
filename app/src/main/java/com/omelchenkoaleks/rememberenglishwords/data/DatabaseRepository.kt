package com.omelchenkoaleks.rememberenglishwords.data

import androidx.lifecycle.LiveData
import com.omelchenkoaleks.rememberenglishwords.data.models.AppWords

interface DatabaseRepository {
    val allWords: LiveData<List<AppWords>>
    suspend fun insertWord(word: AppWords, onSuccess: () -> Unit)
    suspend fun deleteWord(word: AppWords, onSuccess: () -> Unit)
}