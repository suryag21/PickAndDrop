package rider.redant.com.myapplication.Activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import rider.redant.com.myapplication.R

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                frame.setBackgroundColor( resources.getColor(R.color.primary_material_light))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                frame.setBackgroundColor( resources.getColor(R.color.colorAccent))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                frame.setBackgroundColor( resources.getColor(R.color.colorTrice))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
