package com.omelchenkoaleks.rememberenglishwords.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.omelchenkoaleks.rememberenglishwords.R
import com.omelchenkoaleks.rememberenglishwords.RecyclerViewWordsAdapter
import com.omelchenkoaleks.rememberenglishwords.counties
import com.omelchenkoaleks.rememberenglishwords.databinding.FragmentWordsBinding

class WordsFragment : Fragment() {

    private var _binding: FragmentWordsBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: RecyclerViewWordsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        binding.wordsSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    private fun initRecyclerView() {
        binding.wordsRecyclerView.layoutManager = LinearLayoutManager(binding.wordsRecyclerView.context)
        binding.wordsRecyclerView.setHasFixedSize(true)

        adapter = RecyclerViewWordsAdapter(counties)
        binding.wordsRecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}