package com.example.submissioncomposedicoding.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submissioncomposedicoding.model.Country
import com.example.submissioncomposedicoding.repository.CountryRepository
import com.example.submissioncomposedicoding.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailCountryViewModel(private val repository: CountryRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Country>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Country>>
        get() = _uiState

    fun getCountryById(id: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getDetailCountryById(id))
        }
    }
}