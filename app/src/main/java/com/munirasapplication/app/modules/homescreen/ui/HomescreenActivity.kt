package com.munirasapplication.app.modules.homescreen.ui
// Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mindful_quotes.R
import com.mindful_quotes.databinding.ActivityHomescreenBinding
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.modules.favourites.ui.FavouritesActivity
import com.munirasapplication.app.modules.homescreen.data.model.homescreenModel
import com.munirasapplication.app.modules.homescreen.data.viewmodel.HomescreenVM



class HomescreenActivity : BaseActivity<ActivityHomescreenBinding>(R.layout.activity_homescreen) {
  private val viewModel: HomescreenVM by viewModels<HomescreenVM>()
  private lateinit var viewModel: homescreenModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


    val bookmarkImage: ImageView = findViewById<ImageView>(R.id.imageBookmark)
    bookmarkImage.setOnClickListener {
      val currentQuote = // Get the current quote from your data source
        viewModel.saveQuote(currentQuote)
    }

   //this is for the general favorites button at the bottom navigation
    val imageBookmarkOne: ImageView = findViewById(R.id.imageBookmarkOne)
    imageBookmarkOne.setOnClickListener {
      val intent = Intent(this, FavouritesActivity::class.java)
      startActivity(intent)
    }

    // Fetch random quote from ZenQuotes API
    viewModel.fetchRandomQuote()

    // Observe LiveData variables to update UI when quote changes
    viewModel.quoteTextLiveData.observe(this, Observer { quoteText ->
      binding.txtTheBeginningi.text = quoteText
    })
    viewModel.authorLiveData.observe(this, Observer { author ->
       //Update TextView with author name
          binding.txtauthor.text = author
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




