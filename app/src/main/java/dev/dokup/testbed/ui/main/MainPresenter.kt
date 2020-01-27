package dev.dokup.testbed.ui.main

import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val navigator: MainNavigator
) : MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun onClickLogcatSample() {
        navigator.navigateToLogcatSample()
    }

    override fun onClickExpenseSample() {
        navigator.navigateToExpenseSample()
    }

    override fun onClickDogSample() {
        navigator.navigateToDogSample()
    }
}
