package dev.dokup.testbed.ui.logcat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import dev.dokup.testbed.R
import dev.dokup.testbed.databinding.ActivityLogcatBinding
import javax.inject.Inject

class LogcatActivity : DaggerAppCompatActivity(), LogcatContract.View {

    private lateinit var binding: ActivityLogcatBinding

    @Inject lateinit var presenter: LogcatPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_logcat)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setTitle(R.string.logcat_sample)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        presenter.attachView(this)

        binding.logcatVButton.setOnClickListener {
            presenter.onClickLogv()
        }

        binding.logcatDButton.setOnClickListener {
            presenter.onClickLogd()
        }

        binding.logcatIButton.setOnClickListener {
            presenter.onClickLogi()
        }

        binding.logcatWButton.setOnClickListener {
            presenter.onClickLogw()
        }

        binding.logcatEButton.setOnClickListener {
            presenter.onClickLoge()
        }

        binding.timberVButton.setOnClickListener {
            presenter.onClickTimberv()
        }

        binding.timberDButton.setOnClickListener {
            presenter.onClickTimberd()
        }

        binding.timberIButton.setOnClickListener {
            presenter.onClickTimberi()
        }

        binding.timberWButton.setOnClickListener {
            presenter.onClickTimberw()
        }

        binding.timberEButton.setOnClickListener {
            presenter.onClickTimbere()
        }
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

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, LogcatActivity::class.java)
        }
    }
}
