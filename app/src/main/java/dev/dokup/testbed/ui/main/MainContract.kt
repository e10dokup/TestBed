package dev.dokup.testbed.ui.main

interface MainContract {
    interface View {
        // no interface
    }

    interface Presenter {
        fun attachView(view: View)
        fun onClickLogcatSample()
        fun onClickExpenseSample()
        fun onClickDogSample()
        fun onClickMemoryLeakSample()
    }
}
