package com.example.cicironeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.cicironeapp.R
import com.example.cicironeapp.cicirone.Screens
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val router: Router by inject()
    private val navigator: Navigator by inject { parametersOf(this) }
    private val navHolder: NavigatorHolder by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.navigateTo(Screens.firstFr())

        handleBackPressedEvent { router.exit() }
        val btnNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        btnNav.setOnItemSelectedListener { id ->
            when(id.itemId) {
               R.id.first_fr -> router.navigateTo(Screens.firstFr())
               R.id.second_fr -> router.navigateTo(Screens.secondFr())
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navHolder.removeNavigator()
    }

    private fun handleBackPressedEvent(onBack: () -> Unit) {
        this.onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBack()
            }
        })
    }

}

