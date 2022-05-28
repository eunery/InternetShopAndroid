package com.example.internetshopandroid.di

import android.content.Context
import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.IApi
import dagger.Module
import dagger.Provides

@Module(includes = [AppModule::class])
abstract class AppBindsModule {

}

@Module
class AppModule(private val context: Context) {
    @Provides fun provideContext() = context
    @Provides
    fun provideApi(apiProvider: ApiProvider): IApi =
        apiProvider.getApi()
}