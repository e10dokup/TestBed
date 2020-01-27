package dev.dokup.testbed.ui.dog

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogActivityModule {
    @ContributesAndroidInjector(
        modules = [
            DogActivityBindsModule::class
        ]
    )
    fun contributeDogActivity(): DogActivity
}
