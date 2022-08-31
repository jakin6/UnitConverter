package com.jcompanny.unitconverter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ConversionResult::class], version = 1)
abstract class ConvertDatabase:RoomDatabase() {

    abstract val convertDAO: ConvertDAO

    companion object {
        @Volatile
        private var INSTANCE: ConvertDatabase? = null
        fun getInstance(context: Context): ConvertDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConvertDatabase::class.java,
                        "converter_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}