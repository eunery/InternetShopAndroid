package com.example.internetshopandroid.di

import com.example.internetshopandroid.viewmodels.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppBindsModule::class,
])
interface IAppComponent {
    fun viewModelFactory(): ViewModelFactory
}