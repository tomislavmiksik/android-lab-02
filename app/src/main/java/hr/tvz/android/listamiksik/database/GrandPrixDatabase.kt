package hr.tvz.android.listamiksik.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import hr.tvz.android.listamiksik.database.daos.GrandPrixDao
import hr.tvz.android.listamiksik.database.entities.GrandPrix
import subscribeOnBackground

@Database(entities = [GrandPrix::class], version = 1)
abstract class GrandPrixDatabase : RoomDatabase() {
    abstract fun grandPrixDao(): GrandPrixDao

    companion object {
        private var instance: GrandPrixDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): GrandPrixDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, GrandPrixDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: GrandPrixDatabase) {
            val noteDao = db.grandPrixDao()
            subscribeOnBackground {
                noteDao.insert(GrandPrix(
                    1,
                    "Bahrain Grand Prix",
                    "20th of March",
                    "FP1, FP2, FP3, Q, R",
                    "yes",
                    "Leclerc, Sainz, Hamilton"
                ))
                noteDao.insert(
                    GrandPrix(
                        2,
                        "Saudi Arabian Grand Prix",
                        "27th of March",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Sainz"
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        3,
                        "Australian Grand Prix",
                        "10th of April",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Leclerc, Perez, Russell"
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        4,
                        "Emilia Romagna Grand Prix",
                        "24th of April",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Norris"
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        5,
                        "Miami Grand Prix",
                        "8th of May",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Sainz"
                    )
                )


            }
        }
    }
}