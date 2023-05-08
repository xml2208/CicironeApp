package com.example.cicironeapp.cicirone

import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.cicironeapp.ui.FirstFragment
import com.example.cicironeapp.ui.SecondFragment
import com.example.cicironeapp.ui.ThirdFragment
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MyAppNavigator(activity: FragmentActivity, container: Int) :
    AppNavigator(activity, container) {

    override fun commitNewFragmentScreen(screen: FragmentScreen, addToBackStack: Boolean) {
        super.commitNewFragmentScreen(screen, addToBackStack)
        when (screen) {
            Screens.firstFr() -> FirstFragment()
            Screens.secondFr() -> SecondFragment()
            Screens.third() -> ThirdFragment()
        }
    }

    override fun applyCommands(commands: Array<out Command>) {
        Log.i("command", "$commands")
        super.applyCommands(commands)
    }

}