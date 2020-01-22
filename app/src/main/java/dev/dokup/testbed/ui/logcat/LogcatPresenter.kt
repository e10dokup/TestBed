package dev.dokup.testbed.ui.logcat

import android.util.Log
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
}


