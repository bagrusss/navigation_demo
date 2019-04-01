package ru.bagrusss.navigation_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHost.navController.apply {
            restoreState(savedInstanceState?.getBundle(NAV_STATE))
            setGraph(R.navigation.main)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBundle(NAV_STATE, controller.saveState())
    }

    companion object {
        private const val NAV_STATE = "NAV_STATE"
    }

}
