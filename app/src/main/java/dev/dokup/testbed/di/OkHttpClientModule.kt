package dev.dokup.testbed.di

import android.app.Application
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dev.dokup.testbed.App
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class OkHttpClientModule(val application: Application) {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addNetworkInterceptor(
                FlipperOkhttpInterceptor(
                    (application as App).networkFlipperPlugin
                )
            )
            .build()
}
