package com.omelchenkoaleks.rememberenglishwords

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.omelchenkoaleks.rememberenglishwords.databinding.WordItemBinding
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewWordsAdapter(private var words: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var wordsFilterList = ArrayList<String>()

    init {
        wordsFilterList = words
    }

    class WordsHolder(var viewBinding: WordItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = WordItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordsHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val wordsHolder = holder as WordsHolder
        wordsHolder.viewBinding.word.text = wordsFilterList[position]
    }

    override fun getItemCount(): Int {
        return wordsFilterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    wordsFilterList = words
                } else {
                    val resultList = ArrayList<String>()
                    for (row in words) {
                        if (row.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    wordsFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = wordsFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                wordsFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }

}