package hr.tvz.android.listamiksik

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class AirPlaneModeStateReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, R.string.airplanemode, Toast.LENGTH_SHORT).show()
    }
}