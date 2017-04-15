package com.mateuszkoslacz.movipershowcase.viper.login

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor
import com.mateuszkoslacz.movipershowcase.data.LoginBundle
import com.mateuszkoslacz.movipershowcase.rdp.LoginRepository


class LoginInteractor : BaseRxInteractor(), LoginContract.Interactor {

    private val loginRepository = LoginRepository()

    override fun performLogin(loginBundle: LoginBundle) = loginRepository.performLogin(loginBundle)
}
