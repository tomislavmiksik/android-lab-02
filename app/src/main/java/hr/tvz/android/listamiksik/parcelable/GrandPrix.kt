package hr.tvz.android.listamiksik.parcelable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class GrandPrix(
    var name : String,
    var date : String,
    var sessions: List<String>,
    var completed: Boolean,
    var podium: List<String>?,
    var flag: Int,
    var layout: Int,
) : Parcelable {}