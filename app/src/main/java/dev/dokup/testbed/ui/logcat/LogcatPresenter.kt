package dev.dokup.testbed.ui.logcat

import android.util.Log
import timber.log.Timber
import javax.inject.Inject

class LogcatPresenter @Inject constructor() : LogcatContract.Presenter {

    private lateinit var view: LogcatContract.View

    override fun attachView(view: LogcatContract.View) {
        this.view = view
    }

    override fun onClickLogv() {
        Log.v("LogcatPresenter", "Verbose log output")
    }

    override fun onClickLogd() {
        Log.d("LogcatPresenter", "Debug log output")
    }

    override fun onClickLogi() {
        Log.i("LogcatPresenter", "Info log output")
    }

    override fun onClickLogw() {
        Log.w("LogcatPresenter", "Warn log output")
    }

    override fun onClickLoge() {
        Log.e("LogcatPresenter", "Error log output")
    }

    override fun onClickTimberv() {
        Timber.v("Verbose timber output")
    }

    override fun onClickTimberd() {
        Timber.d("Debug timber output")
    }

    override fun onClickTimberi() {
        Timber.i("Info timber output")
    }

    override fun onClickTimberw() {
        Timber.w("Warn timber output")
    }

    override fun onClickTimbere() {
        Timber.e("Error timber output")
    }
}


