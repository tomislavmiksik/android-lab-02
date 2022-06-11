package hr.tvz.android.listamiksik

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import hr.tvz.android.listamiksik.database.entities.GrandPrix


class GrandPrixAdapterV2(
    context: Context,
    @LayoutRes private val layoutResource: Int,
    private val grandPrixs: List<GrandPrix>
) :
    ArrayAdapter<GrandPrix>(context, layoutResource, grandPrixs) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.grandprix_card, parent, false)

        val grandPrix = grandPrixs[position]

        val imageView = itemView.findViewById<ImageView>(R.id.item_image)
        imageView.setImageResource(grandPrix.flag)

        val textView = itemView.findViewById<TextView>(R.id.text1)
        textView.text = grandPrix.name

        val text2View = itemView.findViewById<TextView>(R.id.text2)
        text2View.text = grandPrix.date


        return itemView
    }


}