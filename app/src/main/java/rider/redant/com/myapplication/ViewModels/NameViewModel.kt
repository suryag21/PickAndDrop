package rider.redant.com.myapplication.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import rider.redant.com.myapplication.DataBase.MainDataBase
import rider.redant.com.myapplication.Models.Location
import rider.redant.com.myapplication.Models.Name


class NameViewModel() : ViewModel() {

    // Create a LiveData with a String
     var mCurrentName= MutableLiveData<Location>()
     init {
         mCurrentName.value = Location(1,"name","Adress",
                 "9948499020","Status","www.google.com") //as MutableLiveData<Location>
     }

    val  currentName: MutableLiveData<Location>
        get() {
            if (mCurrentName == null) {
                mCurrentName = MutableLiveData()
            }
            return mCurrentName
        }
}