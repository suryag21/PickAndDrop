package rider.redant.com.myapplication.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask
import rider.redant.com.myapplication.DataBase.MainDataBase
import rider.redant.com.myapplication.Models.Name
import java.text.SimpleDateFormat
import java.util.*

class TitleViewModel(application: Application) : AndroidViewModel(application) {

    // Create a LiveData with a String
    var mCurrentName = MutableLiveData<String>()
    var name: MutableLiveData<Name>? = MutableLiveData<Name>()
    var appDataBase: MainDataBase? = null

    init {

        appDataBase = MainDataBase.getInstance(application);
//        name = appDataBase?.userNameDao()?.getAll()
    }

    val currentName: MutableLiveData<String>
        get() {
            if (name == null) {
                return (name?.value?.firstName) as MutableLiveData<String>
            }
            return "" as MutableLiveData<String>
        }


    val currentNames: MutableLiveData<String>
        get() {
            if (mCurrentName == null) {
                mCurrentName = MutableLiveData()
            }
            return mCurrentName
        }

    public fun addNameToDB() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val current = sdf.format(Date())
        appDataBase?.userNameDao()?.insert(Name(current))

//        Async(appDataBase).execute();
    }

    class Async(appDataBase: MainDataBase?) : AsyncTask<Void, Void, Void>() {
        var appDB: MainDataBase? = null

        init {
            appDB = appDataBase;
        }

        override fun doInBackground(vararg params: Void?): Void {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val current = sdf.format(Date())
            appDB?.userNameDao()?.insert(Name(current))
        }

    }
}
