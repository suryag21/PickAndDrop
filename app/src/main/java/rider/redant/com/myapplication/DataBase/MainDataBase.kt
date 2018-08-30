package rider.redant.com.myapplication.DataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import rider.redant.com.myapplication.Models.Location


@Database(entities = arrayOf(Location::class), version = 1)
abstract class MainDataBase : RoomDatabase(){

    abstract fun weatherDataDao(): UserLocationDao

    companion object {
        private var INSTANCE: MainDataBase? = null

        fun getInstance(context: Context): MainDataBase? {
            if (INSTANCE == null) {
                synchronized(MainDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MainDataBase::class.java, "weather.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}