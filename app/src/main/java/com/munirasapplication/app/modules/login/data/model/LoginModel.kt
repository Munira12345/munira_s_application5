package com.munirasapplication.app.modules.login.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class LoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLogin: String? = MyApp.getInstance().resources.getString(R.string.lbl_login)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThreeValue: String? = null
)
