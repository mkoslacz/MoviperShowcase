package com.mateuszkoslacz.movipershowcase.viper.login

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.movipershowcase.util.retrySubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter :
        BaseRxPresenter<LoginContract.View,
                LoginContract.Interactor,
                LoginContract.Routing>(),
        ViperPresenter<LoginContract.View> {

    override fun attachView(attachingView: LoginContract.View?) {
        super.attachView(attachingView)

        addSubscription(
                view
                        ?.loginClicks
                        ?.doOnNext { view?.showLoading() }
                        ?.observeOn(Schedulers.io())
                        ?.flatMapSingle { interactor.performLogin(it) }
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.retrySubscribe(
                                {
                                    routing.goToProfileScreen(it)
                                    routing.finish()
                                },
                                { view?.showError(it) }))


        addSubscription(
                view
                        ?.helpClicks
                        ?.retrySubscribe(
                                { routing.goToHelpScreen() },
                                { view?.showError(it) }))

    }

    override fun createRouting() = LoginRouting()

    override fun createInteractor() = LoginInteractor()
}
