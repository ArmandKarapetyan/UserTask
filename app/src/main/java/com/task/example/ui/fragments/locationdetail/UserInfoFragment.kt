package com.task.example.ui.fragments.locationdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.task.example.R
import com.task.example.databinding.FragmentUserInfoBinding
import com.task.example.utils.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserInfoFragment : Fragment() {

    private val args: UserInfoFragmentArgs by navArgs()
    private val viewModel: UserInfoViewModel by viewModel() {
        parametersOf(args.userLogin)
    }

    private val binding: FragmentUserInfoBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.locationDetail.onEach {userInfo->
            userInfo?.let {
                with(binding) {
                    Glide.with(requireContext())
                        .load(it.avatarUrl)
                        .circleCrop()
                        .into(avatar)
                    name.text = context?.getString(R.string.name, it.fullName)
                    location.text = context?.getString(R.string.location, it.location)
                    followers.text = context?.getString(R.string.followers_count, it.followers)
                    following.text = context?.getString(R.string.following_count, it.following)
                    bio.text = context?.getString(R.string.bio, it.bio)
                    publicRepos.text = context?.getString(R.string.public_repos, it.publicRepo)
                    publicGists.text = context?.getString(R.string.public_gists, it.publicGists)
                    updateAt.text = context?.getString(R.string.updated, it.updateAt)
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}
