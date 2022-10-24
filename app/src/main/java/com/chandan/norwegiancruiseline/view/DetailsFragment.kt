package com.chandan.norwegiancruiseline.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.chandan.norwegiancruiseline.databinding.FragmentDetailsBinding
import com.chandan.norwegiancruiseline.utils.setTextOrHideIfNullOrEmpty
import com.chandan.norwegiancruiseline.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val type = requireArguments().getString(MainFragment.ARGUMENT_TYPE, "null")
        viewModel.setCruiseType(type)

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.cruiseData.observe(viewLifecycleOwner) {
            binding.shipName.setTextOrHideIfNullOrEmpty(it.name)
            binding.passengerCapacity.setTextOrHideIfNullOrEmpty(it.passengerCapacity)
            binding.crew.setTextOrHideIfNullOrEmpty(it.crew)
            binding.inauguarationDate.setTextOrHideIfNullOrEmpty(it.inauguralDate)

            (requireActivity() as AppCompatActivity).supportActionBar?.title = it.name
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it == true) View.VISIBLE else View.INVISIBLE
        }

        viewModel.errorData.observe(viewLifecycleOwner) {
            AlertDialog.Builder(requireContext())
                .setTitle(it.first)
                .setMessage(it.second)
                .setPositiveButton("OK") { _, _ ->
                    findNavController().popBackStack()
                }.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
