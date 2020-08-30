package jp.shosakaguchi.githubclientdi.github


import jp.shosakaguchi.githubclientdi.model.GithubRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface IGithubService {
    @GET("/users/{user}/repos")
    fun reposForuser(@Path("user") user: String?): Call<List<GithubRepository>>
}