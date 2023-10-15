package pe.edu.utp.semana06recycleview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_plato_activity.view.*
import pe.edu.utp.semana06recycleview.modelo.Platos
//import kotlinx.android.synthetic.main.item_plato_activity
import pe.edu.utp.semana06recycleview.R
import pe.edu.utp.semana06recycleview.interfaces.ClickListenerInterface


class PlatoAdapter (val context: Context, var lista: MutableList<Platos>, var listener: ClickListenerInterface)
    : RecyclerView.Adapter<PlatoAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plato_activity,
            parent, false)
        val vh : ViewHolder = ViewHolder(view, listener)
        return vh
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plato = this.lista[position]
        holder.foto.setImageResource(plato.foto)
        holder.nombre.text = plato.nombre
        holder.precio.text = plato.precio.toString()
        holder.rating.rating = plato.rating
    }


    class ViewHolder(vista: View, listener: ClickListenerInterface) : RecyclerView.ViewHolder(vista), View.OnClickListener{
        var v = vista
        var listener : ClickListenerInterface? = null

        var foto : ImageView = v.ivFotoPlato
        var nombre : TextView = v.tvNombrePlato
        var precio : TextView = v.tvPrecio
        var rating : RatingBar = v.rbCalificacion


        init {
            this.listener = listener
            this.v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            this.listener?.onClick(v, adapterPosition)
        }


    }

    fun updListFilterPlato(newList: MutableList<Platos>) {
        this.lista = newList
        notifyDataSetChanged()
    }

}