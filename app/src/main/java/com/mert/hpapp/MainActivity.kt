package com.mert.hpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mert.hpapp.ui.CharactersFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val charactersFragment = CharactersFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()

    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerView.id, charactersFragment)
                .addToBackStack("charactersFragment")
                .commit()
        }
    }

}