package com.chandan.norwegiancruiseline.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chandan.norwegiancruiseline.R
import com.chandan.norwegiancruiseline.model.*
import com.chandan.norwegiancruiseline.utils.toCruiseData
import kotlinx.coroutines.launch

class DetailsViewModel(private val cruiseDetailsRepository: CruiseDetailsRepository) : ViewModel() {

    private lateinit var cruiseType: CruiseType

    private val _cruiseData = MutableLiveData<CruiseData>()
    val cruiseData = _cruiseData as LiveData<CruiseData>

    private val _isLoading = MutableLiveData(true)
    val isLoading = _isLoading as LiveData<Boolean>

    private val _errorData = MutableLiveData<Pair<Int, Int>>()
    val errorData = _errorData as LiveData<Pair<Int, Int>>

    fun setCruiseType(type: String) {
        _isLoading.value = true
        val cruiseType = CruiseType.getType(type)
        if (cruiseType == null) {
            _errorData.value = Pair(R.string.error_title, R.string.error_message)
            return
        }
        this.cruiseType = cruiseType

        viewModelScope.launch {
            val response = cruiseDetailsRepository.getCruiseDetails(cruiseType)

            response.also { result ->
                when (result) {
                    is NetworkResult.Loading -> {
                        _isLoading.value = true
                    }
                    is NetworkResult.Success -> {
                        _cruiseData.value = response.data?.toCruiseData()
                        _isLoading.value = false
                    }
                    is NetworkResult.Error -> {
                        _errorData.value = Pair(R.string.error_title, R.string.error_message)
                        _isLoading.value = false
                    }
                }

            }

            _isLoading.value = false
        }
    }
}
