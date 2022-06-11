package hr.tvz.android.listamiksik.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import hr.tvz.android.listamiksik.R
import hr.tvz.android.listamiksik.database.daos.GrandPrixDao
import hr.tvz.android.listamiksik.database.entities.GrandPrix
import subscribeOnBackground

@Database(entities = [GrandPrix::class], version = 5)
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

                /*
                * GrandPrix(
            "Catalunya Grand Prix",
            "22nd of May",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.spain,
            R.drawable.spain_layout
        ),
        GrandPrix(
            "Monaco Grand Prix",
            "27th of May",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.monaco,
            R.drawable.monaco_layout
        ),
        GrandPrix(
            "Azerbaijan Grand Prix",
            "12th of June",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.azerbaijan,
            R.drawable.azerbaijan_layout
        ),
        GrandPrix(
            "Canadian Grand Prix",
            "19th of June",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.canada,
            R.drawable.canada_layout
        ),
        GrandPrix(
            "Silverstone Grand Prix",
            "3rd of July",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.uk,
            R.drawable.uk_layout
        ),
        GrandPrix(
            "Austrian Grand Prix",
            "10th of July",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.austria,
            R.drawable.austria_layout
        ),
        GrandPrix(
            "French Grand Prix",
            "24th of July",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.france,
            R.drawable.france_layout
        ),
        GrandPrix(
            "Hungarian Grand Prix",
            "31st of July",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.hungary,
            R.drawable.hungary_layout
        ),
        GrandPrix(
            "Belgian Grand Prix",
            "28th of August",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.belgium,
            R.drawable.belgium_layout
        ),
        GrandPrix(
            "Dutch Grand Prix",
            "4th of September",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.netherlands,
            R.drawable.netherlands_layout
        ),
        GrandPrix(
            "Italian Grand Prix",
            "11th of September",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.italy,
            R.drawable.italy_monza_layout
        ),
        GrandPrix(
            "Singapore Grand Prix",
            "2nd of October",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.singapore,
            R.drawable.singapore_layout
        ),
        GrandPrix(
            "Japanese Grand Prix",
            "9th of October",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.japan,
            R.drawable.japan_layout
        ),
        GrandPrix(
            "US Grand Prix",
            "23rd of October",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.us,
            R.drawable.us_cota_layout
        ),
        GrandPrix(
            "Mexican Grand Prix",
            "30th of October",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.mexico,
            R.drawable.mexico_layout
        ),
        GrandPrix(
            "Brazilian Grand Prix",
            "13th of November",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.brazil,
            R.drawable.brazil_layout
        ),
        GrandPrix(
            "Abu Dhabi Grand Prix",
            "20th of November",
            "FP1, FP2, FP3, Q, R",
            false,
            null,
            R.drawable.uae,
            R.drawable.uae_layout
        ),*/



                noteDao.insert(GrandPrix(
                    1,
                    "Bahrain Grand Prix",
                    "20th of March",
                    "FP1, FP2, FP3, Q, R",
                    "yes",
                    "Leclerc, Sainz, Hamilton",
                    R.drawable.bahrain,
                    R.drawable.bahrain_layout,
                ))
                noteDao.insert(
                    GrandPrix(
                        2,
                        "Saudi Arabian Grand Prix",
                        "27th of March",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Sainz",
                        R.drawable.saudi,
                        R.drawable.saudi_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        3,
                        "Australian Grand Prix",
                        "10th of April",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Leclerc, Perez, Russell",
                        R.drawable.australia,
                        R.drawable.australia_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        4,
                        "Emilia Romagna Grand Prix",
                        "24th of April",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Norris",
                        R.drawable.italy,
                        R.drawable.italy_imola_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        5,
                        "Miami Grand Prix",
                        "8th of May",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Sainz",
                        R.drawable.us,
                        R.drawable.us_miami_layout,
                    )
                )

                noteDao.insert(
                    GrandPrix(
                        6,
                        "Monte Carlo Grand Prix",
                        "15th of May",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Hamilton, Leclerc, Sainz",
                        R.drawable.monaco,
                        R.drawable.monaco_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        7,
                        "Spanish Grand Prix",
                        "22nd of May",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Verstappen, Leclerc, Sainz",
                        R.drawable.spain,
                        R.drawable.spain_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        8,
                        "Monte Carlo Grand Prix",
                        "29th of May",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Hamilton, Leclerc, Sainz",
                        R.drawable.monaco,
                        R.drawable.monaco_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        10,
                        "Austrian Grand Prix",
                        "13th of June",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Hamilton, Leclerc, Sainz",
                        R.drawable.austria,
                        R.drawable.austria_layout,
                    )
                )
                noteDao.insert(
                    GrandPrix(
                        11,
                        "French Grand Prix",
                        "20th of June",
                        "FP1, FP2, FP3, Q, R",
                        "yes",
                        "Hamilton, Leclerc, Sainz",
                        R.drawable.france,
                        R.drawable.france_layout,
                    )
                )




            }
        }
    }
}