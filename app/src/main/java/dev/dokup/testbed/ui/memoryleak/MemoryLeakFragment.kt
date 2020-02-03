package dev.dokup.testbed.ui.memoryleak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dev.dokup.testbed.R
import dev.dokup.testbed.databinding.FragmentMemoryLeakBinding

class MemoryLeakFragment : Fragment() {

    private lateinit var binding: FragmentMemoryLeakBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_memory_leak,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.transitNextButton.setOnClickListener {
            fragmentManager?.let {
                it.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, MemoryLeakFragment()).commit()
            }
        }
    }
}
