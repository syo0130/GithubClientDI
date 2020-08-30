package jp.shosakaguchi.githubclientdi.github

import jp.shosakaguchi.githubclientdi.model.GithubRepository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class GithubServiceImpl : IGithubService {
    @GET("/users/{user}/repos")
    override fun reposForuser(@Path("user") user: String?): Call<List<GithubRepository>> {
        val builder = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.build()

        val client: IGithubService = retrofit.create<IGithubService>(IGithubService::class.java)
        val call: Call<List<GithubRepository>> =
            client.reposForuser(user)
        return call
    }
}