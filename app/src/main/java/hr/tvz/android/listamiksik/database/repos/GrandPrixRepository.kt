package hr.tvz.android.listamiksik.database.repos

import android.app.Application
import androidx.lifecycle.LiveData
import hr.tvz.android.listamiksik.database.GrandPrixDatabase
import hr.tvz.android.listamiksik.database.daos.GrandPrixDao
import hr.tvz.android.listamiksik.database.entities.GrandPrix
import subscribeOnBackground

class GrandPrixRepository (application: Application){

    private var grandPrixDao: GrandPrixDao
    private var allGrandPrixs: LiveData<List<GrandPrix>>


    private val database = GrandPrixDatabase.getInstance(application)

    init {
        grandPrixDao = database.grandPrixDao()
        allGrandPrixs = grandPrixDao.getAll()
    }
    fun insert(grandPrix: GrandPrix) {
        subscribeOnBackground {
            grandPrixDao.insert(grandPrix)
        }
    }

    fun update(grandPrix: GrandPrix ) {
        subscribeOnBackground {
            grandPrixDao.update(grandPrix)
        }
    }

    fun delete(grandPrix: GrandPrix) {
        subscribeOnBackground {
            grandPrixDao.delete(grandPrix)
        }
    }


    fun getAll(): LiveData<List<GrandPrix>> {
        return allGrandPrixs
    }

    fun getById(id: Int): GrandPrix {
        return grandPrixDao.getById(id)
    }

}