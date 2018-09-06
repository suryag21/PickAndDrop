package rider.redant.com.myapplication.ViewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import rider.redant.com.myapplication.Models.Location

class LocationViewModel:ViewModel(){

    var location =MutableLiveData<Location>()

    fun getStopsList(): MutableLiveData<Location> {

        location = Location(1,"surya","161Hig","9948499020","true","www.google.com") as MutableLiveData<Location>;
        return location
    }

    fun getLocation(location:Location): MutableLiveData<Location> {
        this.location =location as MutableLiveData<Location>
        return  this.location
    }


}