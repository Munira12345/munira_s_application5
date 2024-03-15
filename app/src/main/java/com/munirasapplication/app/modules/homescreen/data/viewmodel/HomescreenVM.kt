package com.munirasapplication.app.modules.homescreen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.homescreen.`data`.model.HomescreenModel
import org.koin.core.KoinComponent

class HomescreenVM : ViewModel(), KoinComponent {
  val homescreenModel: MutableLiveData<HomescreenModel> = MutableLiveData(HomescreenModel())

  var navArguments: Bundle? = null
}
