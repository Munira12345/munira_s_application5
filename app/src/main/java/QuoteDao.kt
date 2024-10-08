import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import data.Quote
import retrofit2.http.Query

@Dao
    interface QuoteDao {
        @Insert
        fun insertQuote(quote: Quote)

        @Delete
        fun deleteQuote(quote: Quote)

        @Query("SELECT * FROM quote")
        fun getAllQuotes(): List<Quote>
    }
