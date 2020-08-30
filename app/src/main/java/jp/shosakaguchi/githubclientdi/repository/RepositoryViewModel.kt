package jp.shosakaguchi.githubclientdi.repository

import androidx.lifecycle.ViewModel
import jp.shosakaguchi.githubclientdi.github.GithubServiceImpl

class RepositoryViewModel(private val githubService: GithubServiceImpl) : ViewModel()