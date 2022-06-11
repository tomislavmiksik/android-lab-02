package hr.tvz.android.listamiksik

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import hr.tvz.android.listamiksik.database.entities.GrandPrix
import java.lang.String
import kotlin.Int

class GrandPrixAdapter : RecyclerView.Adapter<GrandPrixAdapter.GrandPrixHolder>() {
    private var GrandPrixs: List<GrandPrix> = ArrayList()

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): GrandPrixHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.grandprix_card, parent, false)
        return GrandPrixHolder(itemView)
    }

    override fun onBindViewHolder(@NonNull holder: GrandPrixHolder, position: Int) {
        val currentGrandPrixHolder: GrandPrix = GrandPrixs[position]
        holder.itemName.text = currentGrandPrixHolder.name
        holder.grandprixDate.text = currentGrandPrixHolder.date
        holder.itemImage.setImageResource(String.valueOf(currentGrandPrixHolder.flag).toInt())
    }

    override fun getItemCount(): Int {
        return GrandPrixs.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setGrandPrixs(GrandPrixs: List<GrandPrix>) {
        this.GrandPrixs = GrandPrixs
        notifyDataSetChanged()
    }

    inner class GrandPrixHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView
        val itemName: TextView
        val grandprixDate: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.text1)
            grandprixDate = itemView.findViewById(R.id.text2)
        }
    }


}