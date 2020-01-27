package dev.dokup.testbed.ui.dog

import android.app.Activity
import dagger.Binds
import dagger.Module

@Module
interface DogActivityBindsModule {
    @Binds
    fun bindActivity(activity: DogActivity): Activity
}
