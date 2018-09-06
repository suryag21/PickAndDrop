package rider.redant.com.myapplication.DataBase

import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import rider.redant.com.myapplication.Models.Name

@Dao
interface UserNameDao{
    @Query("SELECT * from Name")
    fun getAll(): List<Name>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherData: Name)

    @Query("DELETE from Name")
    fun deleteAll()
}