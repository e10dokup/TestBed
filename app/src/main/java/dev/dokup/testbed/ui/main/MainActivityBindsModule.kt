package dev.dokup.testbed.ui.main

import android.content.Context
import dagger.Binds
import dagger.Module

@Module
interface MainActivityBindsModule {
    @Binds
    fun bindContext(activity: MainActivity): Context
}
