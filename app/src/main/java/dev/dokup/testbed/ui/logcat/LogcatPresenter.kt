package dev.dokup.testbed.ui.logcat

import android.util.Log
import javax.inject.Inject

class LogcatPresenter @Inject constructor() : LogcatContract.Presenter {

    private lateinit var view: LogcatContract.View

    override fun attachView(view: LogcatContract.View) {
        this.view = view
    }

    override fun onClickLogd() {
        Log.d("LogcatPresenter", "Debug log output")
    }
}
