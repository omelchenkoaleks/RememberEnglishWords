package com.omelchenkoaleks.rememberenglishwords.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.omelchenkoaleks.rememberenglishwords.data.models.AppWords

@Database(entities = [AppWords::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getRoomDao(): AppRoomDao

    companion object {

        @Volatile
        private var database: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                ).build()
                database as AppRoomDatabase
            } else database as AppRoomDatabase
        }
    }
}