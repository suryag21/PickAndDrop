package rider.redant.com.myapplication.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Location")
data class Location(@PrimaryKey(autoGenerate = true) var id: Long?,
                    @ColumnInfo(name = "name") val name:String,
                    @ColumnInfo(name = "address") val address:String,
                    @ColumnInfo(name = "mobile") val mobile:String,
                    @ColumnInfo(name = "status") val status:String,
                    @ColumnInfo(name = "link") val link:String
                    ) {
    constructor():this(null,"","","","","")

}