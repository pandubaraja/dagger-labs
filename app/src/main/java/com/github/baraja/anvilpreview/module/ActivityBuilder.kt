package com.github.baraja.anvilpreview.module

import com.github.baraja.anvilpreview.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindsMainActivity(): MainActivity
}