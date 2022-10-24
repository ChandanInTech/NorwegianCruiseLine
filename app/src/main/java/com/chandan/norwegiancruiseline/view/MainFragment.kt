package com.chandan.norwegiancruiseline.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.chandan.norwegiancruiseline.R
import com.chandan.norwegiancruiseline.databinding.FragmentMainBinding
import com.chandan.norwegiancruiseline.model.CruiseType

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBliss.setOnClickListener {
            navigateToDetailsFragment(CruiseType.BLISS)
        }
        binding.buttonSky.setOnClickListener {
            navigateToDetailsFragment(CruiseType.SKY)
        }
        binding.buttonEscape.setOnClickListener {
            navigateToDetailsFragment(CruiseType.ESCAPE)
        }
    }

    private fun navigateToDetailsFragment(type: CruiseType) {
        val bundle = bundleOf(ARGUMENT_TYPE to type.name)
        findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARGUMENT_TYPE = "TYPE"
    }
}
