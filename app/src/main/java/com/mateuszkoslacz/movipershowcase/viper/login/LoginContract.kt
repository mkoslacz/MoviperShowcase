package com.mateuszkoslacz.movipershowcase.viper.login

import android.app.Activity

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import com.mateuszkoslacz.movipershowcase.data.LoginBundle
import com.mateuszkoslacz.movipershowcase.data.UserModel
import io.reactivex.Observable
import io.reactivex.Single

interface LoginContract {

    interface View : MvpView {
        val loginClicks: Observable<LoginBundle>
        val helpClicks: Observable<Any>
        fun showLoading()
        fun showError(error: Throwable)
    }

    interface Interactor : ViperRxInteractor {
        fun performLogin(loginBundle: LoginBundle): Single<UserModel>
    }

    interface Routing : ViperRxRouting<Activity> {
        fun goToHelpScreen()
        fun goToProfileScreen(user: UserModel)
        fun finish()
    }
}
