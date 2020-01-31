package dev.dokup.testbed

import android.util.Log
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.soloader.SoLoader
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.dokup.testbed.di.RoomModule
import dev.dokup.testbed.glide.CustomAppGlideModule
import dev.dokup.testbed.glide.GlideModuleComponentInjector
import timber.log.Timber

class App : DaggerApplication(), GlideModuleComponentInjector {
    lateinit var component: AppComponent
        protected set

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent
            .builder()
            .roomModule(RoomModule(this))
            .build()
        return component
    }

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }

        if (BuildConfig.DEBUG) {
            setupStetho()
        }

        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            setupFlipper()
        }
    }

    override fun inject(module: CustomAppGlideModule) {
        component.inject(module)
    }

    private fun setupStetho() {
        Stetho.initializeWithDefaults(this)

//        デフォルト設定以外でStethoを使う際はInitializerBuilderを使う
//        Stetho.initialize(
//            Stetho.newInitializerBuilder(this)
//                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                .build()
//        )
    }

    private fun setupFlipper() {
        AndroidFlipperClient.getInstance(this).start()
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
