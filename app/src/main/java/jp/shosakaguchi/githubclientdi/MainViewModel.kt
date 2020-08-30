package jp.shosakaguchi.githubclientdi

import androidx.lifecycle.ViewModel
import jp.shosakaguchi.githubclientdi.github.IGithubService

class MainViewModel(private val githubService: IGithubService) : ViewModel()