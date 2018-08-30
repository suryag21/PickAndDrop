package rider.redant.com.myapplication.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Location")
data class Location(@PrimaryKey(autoGenerate = true) var id: Long?,
                    @ColumnInfo(name = "humidity") val name:String,
                    @ColumnInfo(name = "humidity") val address:String,
                    @ColumnInfo(name = "humidity") val mobile:String,
                    @ColumnInfo(name = "humidity") val status:String,
                    @ColumnInfo(name = "humidity") val link:String
                    ) {
    constructor():this(null,"","","","","")

}