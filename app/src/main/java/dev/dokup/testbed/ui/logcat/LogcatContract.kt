package dev.dokup.testbed.ui.logcat

interface LogcatContract {
    interface View {
        // no interface
    }

    interface Presenter {
        fun attachView(view: View)
        fun onClickLogv()
        fun onClickLogd()
        fun onClickLogi()
        fun onClickLogw()
        fun onClickLoge()
        fun onClickTimberv()
        fun onClickTimberd()
        fun onClickTimberi()
        fun onClickTimberw()
        fun onClickTimbere()
    }
}
