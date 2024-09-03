package com.munirasapplication.app.modules.favourites.ui

import androidx.activity.viewModels
import com.mindful_quotes.R
import com.mindful_quotes.databinding.ActivityFavouritesBinding
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.modules.favourites.`data`.viewmodel.FavouritesVM
import kotlin.String
import kotlin.Unit

class FavouritesActivity : BaseActivity<ActivityFavouritesBinding>(R.layout.activity_favourites) {
  private val viewModel: FavouritesVM by viewModels<FavouritesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.favouritesVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "FAVOURITES_ACTIVITY"

  }
}
