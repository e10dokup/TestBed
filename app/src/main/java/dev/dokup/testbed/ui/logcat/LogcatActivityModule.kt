package dev.dokup.testbed.ui.logcat

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.dokup.testbed.ui.main.MainActivity

@Module
interface LogcatActivityModule {
    @ContributesAndroidInjector(
        modules = [
            LogcatActivityBindsModule::class
        ]
    )
    fun contributeLogcatActivity(): LogcatActivity
}
