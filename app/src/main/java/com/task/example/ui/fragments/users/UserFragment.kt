package com.task.example.ui.fragments.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.task.example.databinding.FragmentUsersBinding
import com.task.example.utils.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModel()
    private val binding: FragmentUsersBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private var imagesAdapter = UserAdapter {
        val destination = UserFragmentDirections
            .actionHomeToLocationDetail(it)
        findNavController().navigate(destination)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvData.adapter = imagesAdapter

        viewModel.users.onEach {
            imagesAdapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}
