package dev.dokup.testbed.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
