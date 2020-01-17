package dev.dokup.testbed.di

import dagger.Module
import dev.dokup.testbed.ui.logcat.LogcatActivityModule
import dev.dokup.testbed.ui.logcat.LogcatPresenter
import dev.dokup.testbed.ui.main.MainActivityModule

@Module(
    includes = [
        MainActivityModule::class,
        LogcatActivityModule::class
    ]
)
interface ActivityModule
