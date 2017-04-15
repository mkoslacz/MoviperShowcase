package com.mateuszkoslacz.movipershowcase.viper.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mateuszkoslacz.movipershowcase.R
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        usernameText.text = intent.getStringExtra(EXTRA_USERNAME_STRING)
    }
}
