package com.munirasapplication.app.modules.favourites.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.favourites.`data`.model.FavouritesModel
import org.koin.core.component.KoinComponent

class FavouritesVM : ViewModel(), KoinComponent {
  val favouritesModel: MutableLiveData<FavouritesModel> = MutableLiveData(FavouritesModel())

  var navArguments: Bundle? = null
}
