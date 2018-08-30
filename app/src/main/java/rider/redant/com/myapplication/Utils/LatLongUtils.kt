package rider.redant.com.myapplication.Utils

import android.location.Location

object LatLongUtils{

        fun  distance(from : Location, to : Location): Double{

            from.latitude = 17.372102
            from.longitude = 78.484196

            to.latitude = 17.375775
            to.longitude = 78.469218

            return from.distanceTo(to).toDouble()
        }

}