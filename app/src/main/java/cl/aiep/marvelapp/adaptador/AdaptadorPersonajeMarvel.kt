package cl.aiep.marvelapp.adaptador

import Results
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.aiep.marvelapp.R
import com.bumptech.glide.Glide

class AdaptadorPersonajeMarvel(val data: List<Results>) :
    RecyclerView.Adapter<AdaptadorPersonajeMarvel.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPersonaje: ImageView
        val txtNombreVista: TextView
        val txtDescripcion: TextView

        init {
            // Define click listener for the ViewHolder's View.
            imgPersonaje = view.findViewById(R.id.imgPersonaje)
            txtNombreVista = view.findViewById(R.id.txtNombre)
            txtDescripcion = view.findViewById(R.id.txtDescripcion)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fila_lista, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //Nombre
        holder.txtNombreVista.text = data.get(position).name
        //Descripcion
        holder.txtDescripcion.text = data.get(position).description
        //Imagen
        val url = data.get(position).thumbnail.path + "." + data.get(position).thumbnail.extension
        Glide.with(holder.imgPersonaje.context).load(url).into(holder.imgPersonaje)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return data.size
    }
}