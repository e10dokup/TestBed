package dev.dokup.testbed.di

import dagger.Module
import dev.dokup.testbed.ui.main.MainActivityModule

@Module(
    includes = [
        MainActivityModule::class
    ]
)
interface ActivityModule
