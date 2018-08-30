package rider.redant.com.myapplication.DataBase

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import rider.redant.com.myapplication.Models.Location

@Dao
interface UserLocationDao{

    @Query("SELECT * from Location")
    fun getAll(): List<Location>

    @Insert(onConflict = REPLACE)
    fun insert(weatherData: Location)

    @Query("DELETE from Location")
    fun deleteAll()

}