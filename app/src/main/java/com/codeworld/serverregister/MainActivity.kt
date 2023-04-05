package com.codeworld.serverregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeworld.serverregister.common.LOGIN_FRAGMENT_TAG
import com.codeworld.serverregister.common.REGISTER_FRAGMENT_TAG
import com.codeworld.serverregister.ui.login_screen.LoginFragment
import com.codeworld.serverregister.ui.register_screen.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateRegisterFragment()

    }

    fun navigateRegisterFragment() {

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, RegisterFragment(), REGISTER_FRAGMENT_TAG).commitNow()

    }

    fun navigateLoginFragment() {

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, LoginFragment(), LOGIN_FRAGMENT_TAG).commitNow()

    }

}