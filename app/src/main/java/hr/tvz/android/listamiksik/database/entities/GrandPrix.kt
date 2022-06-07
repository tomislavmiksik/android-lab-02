package hr.tvz.android.listamiksik.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GrandPrix(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "sesions") val location: String,
    @ColumnInfo(name = "completed") val completed: String,
    @ColumnInfo(name = "podium") val podium: String,
    @ColumnInfo(name = "flag") val flag: Int,
    @ColumnInfo(name = "layout") val layout: Int
)