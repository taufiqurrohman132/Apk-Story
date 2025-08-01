package com.example.instogramapplication.ui.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instogramapplication.data.repository.UserRepository
import com.yariksoffice.lingver.Lingver
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: UserRepository
) : ViewModel() {
    suspend fun getCurrentLang(): String {
        return repository.getCurrentLanguage()
    }

    suspend fun getName(): String {
        return repository.getUserName()
    }

    fun setLanguage(context: Context, langCode: String, onComplite: () -> Unit) {
        Lingver.getInstance().setLocale(context, langCode)
        // save
        viewModelScope.launch {
            repository.setLanguage(langCode)
            onComplite()
        }
    }

    fun logOut() {
        viewModelScope.launch {
            repository.userLogout()
        }
    }
}