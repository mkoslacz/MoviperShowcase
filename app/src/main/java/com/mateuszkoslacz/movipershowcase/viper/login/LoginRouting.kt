package com.mateuszkoslacz.movipershowcase.viper.login

import android.app.Activity

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting
import com.mateuszkoslacz.movipershowcase.data.UserModel
import com.mateuszkoslacz.movipershowcase.viper.help.HelpStarter
import com.mateuszkoslacz.movipershowcase.viper.profile.ProfileStarter

class LoginRouting : BaseRxRouting<Activity>(), LoginContract.Routing {

    private val helpStarter = HelpStarter()
    private val profileStarter = ProfileStarter()

    override fun goToHelpScreen() {
        relatedContext?.let { helpStarter.start(it) }
    }

    override fun goToProfileScreen(user: UserModel) {
        relatedContext?.let { profileStarter.start(it, user) }
    }

    override fun finish() {
        relatedContext?.finish()
    }
}
