package jp.shosakaguchi.githubclientdi.branch

import androidx.lifecycle.ViewModel
import jp.shosakaguchi.githubclientdi.github.GithubServiceImpl

class BranchViewModel(private val githubService: GithubServiceImpl) : ViewModel()
