package com.albedo.testproject3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.albedo.testproject3.data.models.CoordinatesInner
import com.albedo.testproject3.data.models.DodInner
import com.albedo.testproject3.data.models.IdInner
import com.albedo.testproject3.data.models.LocationInner
import com.albedo.testproject3.data.models.LoginInner
import com.albedo.testproject3.data.models.NameInner
import com.albedo.testproject3.data.models.PictureInner
import com.albedo.testproject3.data.models.RegisteredInner
import com.albedo.testproject3.data.models.StreetInner
import com.albedo.testproject3.data.models.TimeZoneInner
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.data.source.local.UsersDao
import com.albedo.testproject3.services.ListTypeConverter


@Database(entities = [
    UserDataUIState::class,
    NameInner::class,
    LocationInner::class,
    StreetInner::class,
    CoordinatesInner::class,
    TimeZoneInner::class,
    DodInner::class,
    LoginInner::class,
    RegisteredInner::class,
    IdInner::class,
    PictureInner::class], version = 1, exportSchema = true)
@TypeConverters(ListTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {


    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
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

