package com.munirasapplication.app.modules.homescreen.`data`.viewmodel
// ViewModel
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.munirasapplication.app.modules.homescreen.data.model.homescreenModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.URL

class HomescreenVM : ViewModel() {

  // Private MutableLiveData to hold the homescreenModel data
  private val _homescreenModel = MutableLiveData<homescreenModel>()
  val homescreenModel: LiveData<homescreenModel>
    get() = _homescreenModel

  var navArguments: Bundle? = null

  val quoteTextLiveData: MutableLiveData<String> = MutableLiveData()
  val authorLiveData: MutableLiveData<String> = MutableLiveData()

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
          quoteTextLiveData.value = quote
          authorLiveData.value = author
        }
      } catch (e: Exception) {
        e.printStackTrace()
        // Handle error
      }
    }
  }
}
