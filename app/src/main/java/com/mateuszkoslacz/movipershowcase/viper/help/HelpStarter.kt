package com.mateuszkoslacz.movipershowcase.viper.help

import android.content.Context
import android.content.Intent

class HelpStarter {

    fun start(context: Context) = context.startActivity(Intent(context, HelpActivity::class.java))
}