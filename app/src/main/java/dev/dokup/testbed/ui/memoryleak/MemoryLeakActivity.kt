package dev.dokup.testbed.ui.memoryleak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.dokup.testbed.R
import dev.dokup.testbed.databinding.ActivityMemoryLeakBinding

class MemoryLeakActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemoryLeakBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_memory_leak)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setTitle(R.string.memory_leak_sample)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, MemoryLeakFragment())
            .commit()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, MemoryLeakActivity::class.java)
        }
    }
}
