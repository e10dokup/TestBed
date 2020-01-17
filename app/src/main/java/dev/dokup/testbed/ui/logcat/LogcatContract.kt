package dev.dokup.testbed.ui.logcat

interface LogcatContract {
    interface View {
        // no interface
    }

    interface Presenter {
        fun attachView(view: View)
        fun onClickLogd()
    }
}
