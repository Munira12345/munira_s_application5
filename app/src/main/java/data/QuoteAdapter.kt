package data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(private val quotes: List<Quote>) :
    RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = quotes[position]
        holder.textQuote.text = quote.text
        holder.textAuthor.text = quote.author
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textQuote: TextView = itemView.findViewById(R.id.textQuote)
        val textAuthor: TextView = itemView