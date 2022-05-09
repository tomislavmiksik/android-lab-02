package hr.tvz.android.listamiksik

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.IntentFilter
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listamiksik.databinding.GrandprixDetailBinding
import hr.tvz.android.listamiksik.parcelable.GrandPrix

class GrandPrixDetailActivity : AppCompatActivity() {

    private lateinit var binding: GrandprixDetailBinding

    var grandprix: GrandPrix? = null


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GrandprixDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        print(grandprix)
        initReceivers()

        binding.apply {
            grandprix = intent.extras!!.getParcelable("grandprix")

            openWebsite.setOnClickListener {
                val url = "https://www.formula1.com/en/racing/2022.html"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                try {
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                }
            }

            trackLayout.setOnClickListener{
                val intent = Intent(applicationContext, ImageActivity::class.java)
                intent.putExtra("grandprixLayout", grandprix!!.layout)
                startActivity(intent)
            }

            shareButton.setOnClickListener { startShare(); }

            if (grandprix != null) {
                trackLayout.setImageResource(grandprix!!.layout)
                name.text = grandprix!!.name
                sessions.text = "Sessions: " + grandprix!!.sessions
                flag.setImageResource(grandprix!!.flag)
                if (grandprix!!.completed) {
                    podium.text = "Podium: " + grandprix!!.podium
                }
            }
        }
    }

    private fun startShare() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.share)
        builder.setMessage(getString(R.string.share_dialog))
            .setPositiveButton("Okay") { _, _ -> sendShare();}
            .setNegativeButton("Decline") { dialog, _ -> dialog.cancel()}
            .create()
            .show()

    }

    private fun sendShare() {
        val broadcastShare = Intent()
        broadcastShare.action = "hr.android.tvz.listamiksik.SHARE"
        sendBroadcast(broadcastShare)
        Toast.makeText(this, "Broadcast sent!", Toast.LENGTH_SHORT).show()
    }

    private fun initReceivers() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(
            Intent.ACTION_AIRPLANE_MODE_CHANGED
        )
        val receiver = AirPlaneModeStateReceiver()

        registerReceiver(receiver, intentFilter)
    }

}