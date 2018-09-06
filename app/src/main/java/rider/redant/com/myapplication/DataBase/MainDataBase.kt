package rider.redant.com.myapplication.DataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import rider.redant.com.myapplication.Models.Location
import rider.redant.com.myapplication.Models.Name


@Database(entities = arrayOf(Location::class, Name::class), version = 1)
abstract class MainDataBase : RoomDatabase(){

    abstract fun weatherDataDao(): UserLocationDao
    abstract fun userNameDao(): UserNameDao

    companion object {
        private var INSTANCE: MainDataBase? = null

        fun getInstance(context: Context): MainDataBase? {
            if (INSTANCE == null) {
                synchronized(MainDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            MainDataBase::class.java, "surya.db")
                            .allowMainThreadQueries()
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