package com.shiokority.shiokoritypay.view.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Payment History Fragment"
    }
    val text: LiveData<String> = _text
}