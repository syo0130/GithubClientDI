package jp.shosakaguchi.githubclientdi

import jp.shosakaguchi.githubclientdi.branch.BranchViewModel
import jp.shosakaguchi.githubclientdi.github.GithubServiceImpl
import jp.shosakaguchi.githubclientdi.github.IGithubService
import jp.shosakaguchi.githubclientdi.repository.RepositoryViewModel
import jp.shosakaguchi.githubclientdi.user.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    viewModel { UserViewModel(get()) }
    single { GithubServiceImpl() }
    viewModel { MainViewModel(get()) }
    viewModel { BranchViewModel(get()) }
    viewModel { RepositoryViewModel(get()) }
}