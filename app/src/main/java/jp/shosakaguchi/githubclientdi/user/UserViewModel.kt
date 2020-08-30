package jp.shosakaguchi.githubclientdi.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.shosakaguchi.githubclientdi.github.GithubServiceImpl
import jp.shosakaguchi.githubclientdi.model.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val githubService: GithubServiceImpl) : ViewModel() {

    var userName: MutableLiveData<String> = MutableLiveData()
    var reposData: MutableLiveData<List<GithubRepository>> = MutableLiveData()
    private val emmpty = GithubRepository.EMPTY
    private var emptyList: MutableList<GithubRepository> = mutableListOf()

    fun searchUsers(user: String)
//            : List<GithubRepository>
    {
        emptyList = mutableListOf()
        emptyList.add(emmpty)
        var repos: List<GithubRepository>? = null
        githubService.reposForuser(user).enqueue(object : Callback<List<GithubRepository>> {
            override fun onResponse(
                call: Call<List<GithubRepository>>,
                response: Response<List<GithubRepository>>
            ) {
                val _repos: List<GithubRepository>? = response.body()
                if(_repos.isNullOrEmpty()){
                    repos = emptyList
                } else {
                    repos = _repos
                }
                reposData.postValue(repos)
            }
            override fun onFailure(
                call: Call<List<GithubRepository>?>,
                t: Throwable?
            ) {
                repos = emptyList
                reposData.postValue(repos)
            }
        })
    }

}