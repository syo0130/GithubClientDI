package jp.shosakaguchi.githubclientdi.user

import GithubRepositoryAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import jp.shosakaguchi.githubclientdi.R
import jp.shosakaguchi.githubclientdi.databinding.FragmentUserBinding
import jp.shosakaguchi.githubclientdi.model.GithubRepository
import org.koin.android.ext.android.inject

class UserFragment : Fragment() {
    private val viewModel: UserViewModel by inject()
    private lateinit var binding: FragmentUserBinding
    private var searchText: String? = null
    private var list: List<GithubRepository> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.userName.observe(this, Observer {
            searchText = it
        })
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        binding.viewModel = viewModel
        binding.goSearch.setOnClickListener {
            if (!searchText.isNullOrEmpty()) {
                viewModel.searchUsers(searchText!!)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel!!.reposData.observe(this, Observer {
            list = it
            if (!list.isNullOrEmpty()) {
                binding.userList.adapter = GithubRepositoryAdapter(list, context!!)
            }
        })
    }
}