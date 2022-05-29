package com.example.internetshopandroid

import android.app.Application
import android.content.Context
import com.example.internetshopandroid.di.AppModule
import com.example.internetshopandroid.di.DaggerIAppComponent
import com.example.internetshopandroid.di.IAppComponent

class App: Application() {
    lateinit var appComponent: IAppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerIAppComponent.builder().appModule(AppModule(this)).build()
    }
}

fun Context.findAppComponent(): IAppComponent =
    (this.applicationContext as App).appComponent