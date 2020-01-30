package dev.dokup.testbed

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.dokup.testbed.di.ActivityModule
import dev.dokup.testbed.di.ApiModule
import dev.dokup.testbed.di.RepositoryModule
import dev.dokup.testbed.di.RoomModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        RepositoryModule::class,
        RoomModule::class,
        ApiModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun roomModule(roomModule: RoomModule): Builder
        fun build(): AppComponent
    }

}
