package com.example.cicironeapp.koin

import androidx.fragment.app.FragmentActivity
import com.example.cicironeapp.R
import com.example.cicironeapp.cicirone.MyAppNavigator
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import org.koin.core.module.Module
import org.koin.dsl.module

val navigationModule: Module = module {

    single { Cicerone.create() }

    factory {
        get<Cicerone<Router>>().router
    }

    factory<Navigator> { (activity: FragmentActivity) ->
        MyAppNavigator(activity, R.id.container)
    }

    factory {
        val router = get<Cicerone<Router>>()
        router.getNavigatorHolder()
    }
}

val allModules = listOf(navigationModule)