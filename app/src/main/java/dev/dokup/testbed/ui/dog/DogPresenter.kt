package dev.dokup.testbed.ui.dog

import dev.dokup.testbed.domain.dog.DogRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber
import javax.inject.Inject

class DogPresenter @Inject constructor(
    private val repository: DogRepository
) : DogContract.Presenter {

    private lateinit var view: DogContract.View

    private val disposable = CompositeDisposable()

    override fun attachView(view: DogContract.View) {
        this.view = view
    }

    override fun onCreate() {
        loadDogs()
    }

    override fun dispose() {
        disposable.dispose()
    }

    private fun loadDogs() {
        repository.getDogs(DOG_LIMIT)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showDogs(it)
            }, {
                Timber.e(it, it.localizedMessage)
                view.showError(it?.localizedMessage ?: "Failure load expenses")
            })
            .addTo(disposable)
    }

    companion object {
        private const val DOG_LIMIT = 10
    }
}
