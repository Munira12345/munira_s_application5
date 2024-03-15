package com.munirasapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityLoginBinding
import com.munirasapplication.app.modules.homescreen.ui.HomescreenActivity
import com.munirasapplication.app.modules.login.`data`.viewmodel.LoginVM
import com.munirasapplication.app.modules.register.ui.RegisterActivity
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = RegisterActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnRegisterInsteadOne.setOnClickListener {
        val destIntent = RegisterActivity.getIntent(this, null)
        startActivity(destIntent)
      }
      binding.btnLoginOne.setOnClickListener {
        val destIntent = HomescreenActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "LOGIN_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, LoginActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
