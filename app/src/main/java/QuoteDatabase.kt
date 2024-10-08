import androidx.room.Database
import androidx.room.RoomDatabase
import data.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}