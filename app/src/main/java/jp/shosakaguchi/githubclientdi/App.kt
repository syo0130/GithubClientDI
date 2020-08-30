package jp.shosakaguchi.githubclientdi

import android.app.Application
import io.reactivex.schedulers.Schedulers.single
import jp.shosakaguchi.githubclientdi.github.GithubServiceImpl
import jp.shosakaguchi.githubclientdi.github.IGithubService
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(myModule)
        }
    }
}