package rider.redant.com.myapplication.Activities

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_home.*
import rider.redant.com.myapplication.DataBase.MainDataBase
import rider.redant.com.myapplication.Models.Location
import rider.redant.com.myapplication.Models.Name
import rider.redant.com.myapplication.R
import rider.redant.com.myapplication.ViewModels.NameViewModel
import java.text.SimpleDateFormat
import java.util.*
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.app.PendingIntent
import android.content.Intent
import android.support.v4.app.NotificationManagerCompat
import android.graphics.BitmapFactory
import android.graphics.Bitmap








class HomeActivity : AppCompatActivity() {

    var isRun:Boolean = false

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                frame.setBackgroundColor( resources.getColor(R.color.primary_material_light))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                frame.setBackgroundColor( resources.getColor(R.color.colorAccent))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                frame.setBackgroundColor( resources.getColor(R.color.colorTrice))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    var appDataBase: MainDataBase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        appDataBase = MainDataBase.getInstance(applicationContext);
        var mViewModel: NameViewModel = ViewModelProviders.of(this).get(NameViewModel::class.java)
        mViewModel.currentName.observe(this, Observer { it->textView.text = it?.name })
        nButton.setOnClickListener {
            val sdf = SimpleDateFormat("dd/MMM/yyyy hh:mm:ss")

            val current = sdf.format(Date())
        var location = Location(5,current,"","","","")
            mViewModel.currentName.value = location
            appDataBase?.userNameDao()?.insert(Name("surya"))
            Log.d("surya","Size is "+appDataBase?.userNameDao()?.getAll()?.size)
            createNotificationChannel()
        }
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Surya"
            val description = "Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
        val b = BitmapFactory.decodeResource(resources, R.drawable.credit_visa)
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val mBuilder = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.started)
                .setContentTitle("My notification")
                .setLargeIcon(b)
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..." +
                                "Much longer text that cannot fit one line..."))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.reached, "Reached",
                        pendingIntent)
                .addAction(R.drawable.reached, "Started",
                        pendingIntent);

        val notificationManager = NotificationManagerCompat.from(this)

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, mBuilder.build())
    }
}
