package com.munirasapplication.app

import android.widget.TextView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.mindful_quotes.R
import com.munirasapplication.app.modules.favourites.ui.FavouritesActivity
import org.junit.Test
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.munirasapplication.app.FavouritesActivity
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.runner.RunWith
import org.robolectric.Robolectric

@RunWith(RobolectricTestRunner::class)
class FavouritesActivityTest {
    @RunWith(AndroidJUnit4::class)
    class FavouritesActivityTest {

        @Test
        fun testTextViewsAreDisplayed() {
            val activityScenario = ActivityScenario.launch(FavouritesActivity::class.java)
            activityScenario.use { scenario ->
                val txtTheBeginningi = scenario.onActivity { activity ->
                    activity.findViewById<TextView>(R.id.txtTheBeginningi)
                }
                val txtLanguage = scenario.onActivity { activity ->
                    activity.findViewById<TextView>(R.id.txtLanguage)
                }
                val txtLanguageOne = scenario.onActivity { activity ->
                    activity.findViewById<TextView>(R.id.txtLanguageOne)
                }

                assertThat(txtTheBeginningi, notNullValue())
                assertThat(txtLanguage, notNullValue())
                assertThat(txtLanguageOne, notNullValue())

                assertThat(txtTheBeginningi).isDisplayed()
                assertThat(txtLanguage).isDisplayed()
                assertThat(txtLanguageOne).isDisplayed()
            }
        }
    }