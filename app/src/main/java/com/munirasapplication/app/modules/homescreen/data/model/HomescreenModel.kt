package com.munirasapplication.app.modules.homescreen.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class homescreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDailybeautiful: String? =
      MyApp.getInstance().resources.getString(R.string.msg_daily_beautiful)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTheBeginningi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_the_beginning_i)
,
  /**
   * Author of the quote
   */
  var txtauthor: String? = null
)

