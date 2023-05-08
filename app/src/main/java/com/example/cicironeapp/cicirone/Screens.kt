package com.example.cicironeapp.cicirone

import com.example.cicironeapp.ui.FirstFragment
import com.example.cicironeapp.ui.SecondFragment
import com.example.cicironeapp.ui.ThirdFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun firstFr() = FragmentScreen("first_fr") { context ->
         FirstFragment()
    }

    fun secondFr() = FragmentScreen("second_fr") { context ->
         SecondFragment()
    }

    fun third() = FragmentScreen("third") { context ->
         ThirdFragment()
    }

}