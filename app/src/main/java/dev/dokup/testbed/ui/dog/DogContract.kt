package dev.dokup.testbed.ui.dog

import dev.dokup.testbed.domain.dog.Dogs

interface DogContract {
    interface View {
        fun showDogs(dogs: Dogs)
        fun showError(message: String)
    }

    interface Presenter {
        fun attachView(view: View)
        fun onCreate()
        fun dispose()
    }
}
