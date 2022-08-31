package com.jcompanny.unitconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jcompanny.unitconverter.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository):
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T=ConvertViewModel(repository) as T

}