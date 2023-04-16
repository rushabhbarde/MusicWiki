package com.hrushabhb.musicwiki

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrushabhb.musicwiki.Repository.Repository
import com.hrushabhb.musicwiki.ViewModel.ViewModelMain

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelMain(repository) as T
    }
}