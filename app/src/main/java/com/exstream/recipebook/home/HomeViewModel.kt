package com.exstream.recipebook.home

import androidx.lifecycle.ViewModel
import com.exstream.recipebook.api.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: CountryRepository
): ViewModel() {

    fun getCountry(): Flow<String> {
        return repository.getCountry().map { it?.firstOrNull() ?: "" }
    }
}