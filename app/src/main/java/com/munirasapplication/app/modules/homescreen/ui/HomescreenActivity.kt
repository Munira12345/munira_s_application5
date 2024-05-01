package com.munirasapplication.app.modules.homescreen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityHomescreenBinding
import com.munirasapplication.app.modules.homescreen.`data`.viewmodel.HomescreenVM
import kotlin.String
import kotlin.Unit

class HomescreenActivity : BaseActivity<ActivityHomescreenBinding>(R.layout.activity_homescreen) {
  private val viewModel: HomescreenVM by viewModels<HomescreenVM>()


  //added code
  override fun onCreate(savedInstanceState: Bundle?) {
    super.oncreate(savedInstanceState)

// Fetch random quote from ZenQuotes API
    viewModel.fetchRandomQuote()

    // Observe LiveData variables to update UI when quote changes
    viewModel.quoteTextLiveData.observe(this, Observer { quoteText ->
      binding.txtDailybeautiful.text = quoteText
    })
    viewModel.authorLiveData.observe(this, Observer { author ->
      // Update TextView with author name
    })
  }


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homescreenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "HOMESCREEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomescreenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
