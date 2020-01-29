package dev.dokup.testbed

import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.dokup.testbed.di.RoomModule
import timber.log.Timber

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .roomModule(RoomModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}

class CrashReportingTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        // Do crash reporting...
    }
}
