package com.shiokority.shiokoritypay.view.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shiokority.shiokoritypay.databinding.FragmentHistoryBinding
import com.shiokority.shiokoritypay.controller.HistoryController

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var historyController: HistoryController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupController()
        observeData()
    }

    private fun setupRecyclerView() {
        historyAdapter = HistoryAdapter()
        binding.rvTransactions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter
        }
    }

    private fun setupController() {
        historyController = ViewModelProvider(this)[HistoryController::class.java]
        historyController.loadHistory()
    }

    private fun observeData() {
        historyController.historyItems.observe(viewLifecycleOwner) { items ->
            historyAdapter.updateItems(items)
            updateEmptyState(items.isEmpty())
        }
    }

    private fun updateEmptyState(isEmpty: Boolean) {
        binding.layoutEmpty.visibility = if (isEmpty) View.VISIBLE else View.GONE
        binding.rvTransactions.visibility = if (isEmpty) View.GONE else View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}