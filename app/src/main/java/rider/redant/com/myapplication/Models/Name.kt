package rider.redant.com.myapplication.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "Name")
data class Name(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "firstName") val firstName:String){
    constructor(firstName:String): this(null,firstName)
}