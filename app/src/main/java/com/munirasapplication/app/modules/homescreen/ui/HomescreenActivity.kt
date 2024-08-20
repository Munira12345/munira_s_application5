package com.munirasapplication.app.modules.homescreen.ui
// Activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityHomescreenBinding
import com.munirasapplication.app.modules.homescreen.data.viewmodel.HomescreenVM

class HomescreenActivity : BaseActivity<ActivityHomescreenBinding>(R.layout.activity_homescreen) {
  private val viewModel: HomescreenVM by viewModels<HomescreenVM>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

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

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homescreenVM = viewModel
  }

  override fun setUpClicks() {
    // Set up click listeners if needed
  }

  companion object {
    const val TAG: String = "HOMESCREEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomescreenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }}




