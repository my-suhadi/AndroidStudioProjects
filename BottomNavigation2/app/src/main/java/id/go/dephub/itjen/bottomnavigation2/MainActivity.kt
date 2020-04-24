package id.go.dephub.itjen.bottomnavigation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fLayout = findViewById<FrameLayout>(R.id.frame_layout)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val androidFr = AndroidFragment()
        val gameFr = GameFragment()
        val webFr = WebFragment()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            val theFragment = supportFragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.menu_android -> {
                    theFragment.replace(R.id.frame_layout, androidFr)
                    theFragment.commit()
                    true
                }
                R.id.menu_game -> {
                    theFragment.replace(R.id.frame_layout, gameFr)
                    theFragment.commit()
                    true
                }
                R.id.menu_web -> {
                    theFragment.replace(R.id.frame_layout, webFr)
                    theFragment.commit()
                    true
                }
                else -> false
            }
        }
    }
}
