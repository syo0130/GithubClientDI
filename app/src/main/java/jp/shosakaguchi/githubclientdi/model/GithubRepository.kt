package jp.shosakaguchi.githubclientdi.model

data class GithubRepository(val name: String){
    companion object{
        val EMPTY = GithubRepository(
            name = ""
        )
    }
}
