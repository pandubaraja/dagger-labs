package com.github.baraja.anvilpreview

import android.app.Application
import com.github.baraja.anvilpreview.module.*
import com.github.baraja.base.scope.CoreScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@CoreScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ApiModule::class,
        RepositoryModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}