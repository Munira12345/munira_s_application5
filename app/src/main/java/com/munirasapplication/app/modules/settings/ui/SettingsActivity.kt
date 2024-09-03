package com.munirasapplication.app.modules.settings.ui

import androidx.activity.viewModels
import com.mindful_quotes.R
import com.mindful_quotes.databinding.ActivitySettingsBinding
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.modules.login.ui.LoginActivity
import com.munirasapplication.app.modules.settings.`data`.viewmodel.SettingsVM
import kotlin.String
import kotlin.Unit

class SettingsActivity : BaseActivity<ActivitySettingsBinding>(R.layout.activity_settings) {
  private val viewModel: SettingsVM by viewModels<SettingsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtLanguageTwo.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SETTINGS_ACTIVITY"

  }
}
