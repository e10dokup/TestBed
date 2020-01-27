package dev.dokup.testbed.ui.dog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import dev.dokup.testbed.R
import dev.dokup.testbed.databinding.ActivityDogBinding
import dev.dokup.testbed.databinding.ItemDogBinding
import dev.dokup.testbed.domain.dog.Dogs
import javax.inject.Inject

class DogActivity : DaggerAppCompatActivity(), DogContract.View {

    private lateinit var binding: ActivityDogBinding

    @Inject lateinit var presenter: DogPresenter

    private val adapter: DogAdapter by lazy {
        DogAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dog)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setTitle(R.string.dog_sample)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

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
        adapter.set(dogs.urls)
    }

    override fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, DogActivity::class.java)
        }
    }
}

class DogAdapter(
    context: Context,
    private var list: MutableList<String> = arrayListOf()
) : RecyclerView.Adapter<DogViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogViewHolder {
        val binding = DataBindingUtil.inflate<ItemDogBinding>(
            inflater,
            R.layout.item_dog,
            parent,
            false
        )
        return DogViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogUrl = list[position]
        Glide.with(holder.binding.image)
            .load(dogUrl)
            .into(holder.binding.image)
    }

    fun set(newList: List<String>) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                list[oldItemPosition] == newList[newItemPosition]

            override fun getOldListSize(): Int = list.size

            override fun getNewListSize(): Int = newList.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                list[oldItemPosition] == newList[newItemPosition]
        }, true)
        list = newList.toMutableList()
        diff.dispatchUpdatesTo(this)
    }
}

class DogViewHolder(
    val binding: ItemDogBinding
) : RecyclerView.ViewHolder(binding.root)
