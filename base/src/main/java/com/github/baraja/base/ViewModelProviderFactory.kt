package com.github.baraja.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.baraja.base.scope.CoreScope
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory(private val viewModel: ViewModel) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}