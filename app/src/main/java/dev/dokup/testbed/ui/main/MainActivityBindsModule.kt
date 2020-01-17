package dev.dokup.testbed.ui.main

import android.app.Activity
import dagger.Binds
import dagger.Module

@Module
interface MainActivityBindsModule {
    @Binds
    fun bindActivity(activity: MainActivity): Activity
}
