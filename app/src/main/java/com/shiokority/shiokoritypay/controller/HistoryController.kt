package com.shiokority.shiokoritypay.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiokority.shiokoritypay.model.HistoryItem
import kotlinx.coroutines.launch

class HistoryController : ViewModel() {
    private val _historyItems = MutableLiveData<List<HistoryItem>>()
    val historyItems: LiveData<List<HistoryItem>> = _historyItems

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadHistory() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                // TODO: Replace with actual API call
                val items = fetchHistoryItems()
                _historyItems.value = items
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun fetchHistoryItems(): List<HistoryItem> {
        // TODO: Implement actual API call
        return emptyList()
    }
}