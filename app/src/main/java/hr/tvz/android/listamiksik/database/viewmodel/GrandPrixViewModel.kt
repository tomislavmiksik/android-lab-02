package hr.tvz.android.listamiksik.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.tvz.android.listamiksik.database.GrandPrixDatabase
import hr.tvz.android.listamiksik.database.entities.GrandPrix
import hr.tvz.android.listamiksik.database.repos.GrandPrixRepository
import kotlinx.coroutines.launch

class GrandPrixViewModel (application: Application) : AndroidViewModel(application) {
    private val repository = GrandPrixRepository(application)
    private val allGrandPrix = repository.getAll()

    fun insert(grandPrix: GrandPrix) = viewModelScope.launch {
        repository.insert(grandPrix)
    }

    fun delete(grandPrix: GrandPrix) = viewModelScope.launch {
        repository.delete(grandPrix)
    }

    fun update(grandPrix: GrandPrix) = viewModelScope.launch {
        repository.update(grandPrix)
    }

    @JvmName("getAllGrandPrix1")
    fun getAllGrandPrix(): LiveData<List<GrandPrix>> {
        return allGrandPrix
    }
}