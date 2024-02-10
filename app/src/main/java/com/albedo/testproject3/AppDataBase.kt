package com.albedo.testproject3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.data.source.local.UsersDao
import com.albedo.testproject3.services.ListTypeConverter
import dagger.hilt.android.qualifiers.ApplicationContext


@Database(entities = [UserUIState::class, ], version = 1, exportSchema = true)
@TypeConverters(ListTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {


    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(@ApplicationContext context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "application_data_base"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}

