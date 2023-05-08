package com.example.cicironeapp.cicirone

import com.github.terrakok.cicerone.Router

class SamplePresenter(
    private val router: Router
) {

    fun onOpen1stScreen() {
        router.navigateTo(Screens.firstFr())
    }
    fun onOpen2ndScreen() {
        router.navigateTo(Screens.secondFr())
    }

    fun onBackPressed() {
        router.exit()
    }
}
