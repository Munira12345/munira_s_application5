package com.munirasapplication.app.modules.register.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class RegisterModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRegister: String? = MyApp.getInstance().resources.getString(R.string.lbl_register)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSixValue: String? = null
)
