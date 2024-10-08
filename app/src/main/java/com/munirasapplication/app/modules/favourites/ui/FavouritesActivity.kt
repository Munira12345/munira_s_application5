package com.munirasapplication.app.modules.favourites.ui

import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mindful_quotes.R
import com.mindful_quotes.databinding.ActivityFavouritesBinding
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.modules.favourites.`data`.viewmodel.FavouritesVM
import com.munirasapplication.app.modules.homescreen.data.viewmodel.HomescreenVM
import data.QuoteAdapter
import kotlin.String
import kotlin.Unit

class FavouritesActivity : BaseActivity<ActivityFavouritesBinding>(R.layout.activity_favourites) {
  private val viewModel: FavouritesVM by viewModels<FavouritesVM>()
  private lateinit var viewModel: HomescreenVM.HomescreenVM
  private lateinit var quotesList: RecyclerView

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.favouritesVM = viewModel

    viewModel = ViewModelProvider(this)[HomescreenVM::class.java]
    quotesList = findViewById(R.id.quotesList)

    viewModel.getAllQuotes().observe(this) { quotes ->
      // Create an adapter for the RecyclerView
      val adapter = QuoteAdapter(quotes)  // Replace with your adapter class name
      quotesList.adapter = adapter
      // Update your UI with the list of quotes
    }
  }


  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "FAVOURITES_ACTIVITY"

  }
}
