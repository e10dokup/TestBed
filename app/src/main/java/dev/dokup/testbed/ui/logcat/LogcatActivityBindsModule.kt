package dev.dokup.testbed.ui.logcat

import android.app.Activity
import dagger.Binds
import dagger.Module

@Module
interface LogcatActivityBindsModule {
    @Binds
    fun bindActivity(activity: LogcatActivity): Activity
}
