package dev.dokup.testbed

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.dokup.testbed.di.*
import dev.dokup.testbed.glide.CustomAppGlideModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        RepositoryModule::class,
        RoomModule::class,
        ApiModule::class,
        OkHttpClientModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun roomModule(roomModule: RoomModule): Builder
        fun okHttpClientModule(okHttpClientModule: OkHttpClientModule): Builder
        fun build(): AppComponent
    }

    fun inject(module: CustomAppGlideModule): CustomAppGlideModule
}
