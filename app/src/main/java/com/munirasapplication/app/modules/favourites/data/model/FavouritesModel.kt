package com.munirasapplication.app.modules.favourites.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class FavouritesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTheBeginningi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_the_beginning_i)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_the_quotes_will)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_all_saved_quote)

)
