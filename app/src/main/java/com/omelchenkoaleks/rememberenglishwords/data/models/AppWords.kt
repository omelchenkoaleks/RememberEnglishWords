package com.omelchenkoaleks.rememberenglishwords.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class AppWords(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val englishWord: String = "",
    @ColumnInfo val russianWord: String = ""
)