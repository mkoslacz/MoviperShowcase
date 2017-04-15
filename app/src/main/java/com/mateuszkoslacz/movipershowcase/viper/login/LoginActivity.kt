package com.mateuszkoslacz.movipershowcase.viper.login


import android.widget.Toast
import com.jakewharton.rxbinding2.view.RxView
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import com.mateuszkoslacz.movipershowcase.R
import com.mateuszkoslacz.movipershowcase.data.LoginBundle
import com.mateuszkoslacz.movipershowcase.util.gone
import com.mateuszkoslacz.movipershowcase.util.visible
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : ViperAiPassiveActivity<LoginContract.View>(), LoginContract.View {

    override val loginClicks by lazy {
        RxView.clicks(loginBtn)
                .map {
                    LoginBundle(login = loginField.text.toString(),
                            password = passwordField.text.toString())
                }!!
    }

    override val helpClicks by lazy { RxView.clicks(helpBtn) }

    override fun showLoading() {
        progressBar.visible()
        loginBtn.gone()
    }

    override fun showError(error: Throwable) {
        progressBar.gone()
        loginBtn.visible()
        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun createPresenter() = LoginPresenter()

    override fun getLayoutId() = R.layout.activity_login
}