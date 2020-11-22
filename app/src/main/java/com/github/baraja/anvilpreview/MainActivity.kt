package com.github.baraja.anvilpreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.baraja.anvilpreview.databinding.ActivityMainBinding
import com.github.baraja.feature_joke.JokeFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, JokeFragment.newInstance())
            .addToBackStack(JokeFragment.TAG)
            .commit()
    }
}