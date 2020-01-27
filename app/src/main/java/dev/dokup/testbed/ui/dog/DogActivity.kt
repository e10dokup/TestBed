package dev.dokup.testbed.ui.dog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import dev.dokup.testbed.R
import dev.dokup.testbed.databinding.ActivityDogBinding
import dev.dokup.testbed.domain.dog.Dogs
import javax.inject.Inject

class DogActivity : DaggerAppCompatActivity(), DogContract.View {

    private lateinit var binding: ActivityDogBinding

    @Inject lateinit var presenter: DogPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dog)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setTitle(R.string.dog_sample)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        // binding.recyclerView.adapter = adapter

        presenter.attachView(this)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showDogs(dogs: Dogs) {

    }

    override fun showError(message: String) {
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, DogActivity::class.java)
        }
    }
}
