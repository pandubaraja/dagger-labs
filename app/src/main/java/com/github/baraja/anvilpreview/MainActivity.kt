package com.github.baraja.anvilpreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.baraja.anvilpreview.databinding.ActivityMainBinding
import com.github.baraja.feature_joke.JokeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, JokeFragment.newInstance())
            .addToBackStack(JokeFragment.TAG)
            .commit()
    }
}