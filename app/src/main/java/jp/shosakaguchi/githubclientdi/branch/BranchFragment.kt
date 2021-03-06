package jp.shosakaguchi.githubclientdi.branch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.shosakaguchi.githubclientdi.MainViewModel
import jp.shosakaguchi.githubclientdi.R
import org.koin.android.ext.android.inject

class BranchFragment : Fragment() {
    private val viewModel: BranchViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_branch, container, false)
    }
}