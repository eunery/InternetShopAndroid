package com.example.internetshopandroid.di

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.AuthRepo
import com.example.data.storage.IStorage
import com.example.data.storage.Storage
import com.example.domain.repository.IAuthRepo
import com.example.domain.useCases.CheckLoginUseCase.CheckLoginUseCase
import com.example.domain.useCases.CheckLoginUseCase.ICheckLoginUseCase
import com.example.domain.useCases.LoginUseCase.ILoginUseCase
import com.example.domain.useCases.LoginUseCase.LoginUseCase
import com.example.domain.useCases.LogoutUseCase.ILogoutUseCase
import com.example.domain.useCases.LogoutUseCase.LogoutUseCase
import com.example.internetshopandroid.viewmodels.*
import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.IApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [AppModule::class])
abstract class AppBindsModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    abstract fun bindCartViewModel(cartViewModel: CartViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(FavouriteViewModel::class)
    abstract fun bindFavouriteViewModel(favouriteViewModel: FavouriteViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignUpViewModel(signUpViewModel: SignUpViewModel): ViewModel


    @Binds abstract fun bindStorage(storage: Storage): IStorage

    @Binds abstract fun bindAuthRepo(authRepo: AuthRepo): IAuthRepo
    @Binds abstract fun bindLogoutUseCase(logoutUseCase: LogoutUseCase): ILogoutUseCase
    @Binds abstract fun bindLoginUseCase(loginUseCase: LoginUseCase): ILoginUseCase
    @Binds abstract fun bindCheckLoginUseCase(checkLoginUseCase: CheckLoginUseCase): ICheckLoginUseCase

}
@Module
class AppModule(private val context: Context) {
    @Provides fun provideContext() = context
    @Provides
    fun provideApi(apiProvider: ApiProvider): IApi =
        apiProvider.getApi()
    @Provides
    fun provideSharedPref():SharedPreferences {
        return context.getSharedPreferences("appPrefs", 0)
    }
}