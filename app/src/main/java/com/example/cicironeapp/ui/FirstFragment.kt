package com.example.cicironeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cicironeapp.R
import com.example.cicironeapp.cicirone.Screens
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject

class FirstFragment : Fragment() {

    private val router: Router by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.findViewById<Button>(R.id.go_btn).setOnClickListener {
            router.navigateTo(Screens.third())
        }

        return view
    }

}