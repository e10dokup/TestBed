package dev.dokup.testbed.ui.expense

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import dev.dokup.testbed.R
import dev.dokup.testbed.databinding.ActivityExpenseBinding
import dev.dokup.testbed.databinding.ItemExpenseBinding
import dev.dokup.testbed.domain.expense.ExpenseEntity
import javax.inject.Inject

class ExpenseActivity : DaggerAppCompatActivity(), ExpenseContract.View {

    private lateinit var binding: ActivityExpenseBinding

    @Inject lateinit var presenter: ExpensePresenter

    private val adapter: ExpenseAdapter by lazy {
        ExpenseAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_expense)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setTitle(R.string.expense_sample)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.saveButton.setOnClickListener {
            val name = binding.nameEdit.text.toString()
            val price = binding.priceEdit.text.toString()
            presenter.onClickSaveButton(name, price)
        }

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

    override fun showExpenses(expenseList: List<ExpenseEntity>) {
        adapter.set(expenseList)
    }

    override fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ExpenseActivity::class.java)
        }
    }
}

class ExpenseAdapter(
    context: Context,
    private var list: MutableList<ExpenseEntity> = arrayListOf()
) : RecyclerView.Adapter<ExpenseViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExpenseViewHolder {
        val binding = DataBindingUtil.inflate<ItemExpenseBinding>(
            inflater,
            R.layout.item_expense,
            parent,
            false
        )
        return ExpenseViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = list[position]
        holder.binding.name.text = expense.name
        holder.binding.price.text = expense.price.toString()
        holder.binding.createdAt.text = expense.createdAtString
    }

    fun set(newList: List<ExpenseEntity>) {
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

class ExpenseViewHolder(
    val binding: ItemExpenseBinding
) : RecyclerView.ViewHolder(binding.root)
