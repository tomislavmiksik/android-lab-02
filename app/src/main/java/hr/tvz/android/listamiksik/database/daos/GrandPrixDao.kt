package hr.tvz.android.listamiksik.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.tvz.android.listamiksik.database.entities.GrandPrix

@Dao
interface GrandPrixDao {
    @Query("SELECT * FROM GrandPrix")
    fun getAll(): LiveData<List<GrandPrix>>

    @Query("SELECT * FROM GrandPrix WHERE id = :id")
    fun getById(id: Int): GrandPrix

    @Query("SELECT * FROM GrandPrix WHERE name = :name")
    fun getByName(name: String): GrandPrix

    @Insert
    fun insert(grandPrix: GrandPrix)

    @Insert
    fun insertAll(grandPrix: List<GrandPrix>)

    @Delete
    fun delete(grandPrix: GrandPrix)

    @Update
    fun update(grandPrix: GrandPrix)


}