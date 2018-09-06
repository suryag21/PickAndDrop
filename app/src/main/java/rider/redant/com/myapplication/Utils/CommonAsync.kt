package rider.redant.com.myapplication.Utils

import android.os.AsyncTask

 abstract class CommonAsync() : AsyncTask<Void,Void,Void>(){

    abstract fun doWork()
    abstract fun workDone()
    override fun doInBackground(vararg params: Void?): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
    }



}