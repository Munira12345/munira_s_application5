package com.munirasapplication.app.modules.homescreen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.homescreen.`data`.model.HomescreenModel
import org.koin.core.KoinComponent

class HomescreenVM : ViewModel(), KoinComponent {
  val homescreenModel: MutableLiveData<HomescreenModel> = MutableLiveData(HomescreenModel())

  var navArguments: Bundle? = null

  //added code for json data
  // Function to fetch random quote from ZenQuotes API
  fun fetchRandomQuote() {
    viewModelScope.launch {
      try {
        val response = withContext(Dispatchers.IO) {
          // Make HTTP request to ZenQuotes API
          val url = "https://zenquotes.io/api/random"
          val jsonString = URL(url).readText()
          JSONArray(jsonString)
        }

        // Parse JSON response to extract quote text and author
        if (response.length() > 0) {
          val quoteObject = response.getJSONObject(0)
          val quote = quoteObject.getString("q")
          val author = quoteObject.getString("a")

          // Update LiveData variables with quote text and author
          _quoteTextLiveData.value = quote
          _authorLiveData.value = author
        }
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }



}}
