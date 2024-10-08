package data

import androidx.room.PrimaryKey

data class Quote(
    @PrimaryKey val id: Int,
    val text: String,
    val author: String
)
