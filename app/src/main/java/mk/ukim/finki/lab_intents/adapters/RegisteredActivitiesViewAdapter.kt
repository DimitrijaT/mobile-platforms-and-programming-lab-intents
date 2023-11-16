package mk.ukim.finki.lab_intents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.lab_intents.R

class RegisteredActivitiesViewAdapter(private val data: MutableList<String>) :
    RecyclerView.Adapter<RegisteredActivitiesViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView: TextView
        private var currentString: String? = null

        init {
            textView = view.findViewById(R.id.registeredActivityItemTextView)
        }

        fun bind(currentString: String) {
            this.currentString = currentString
            this.textView.text = currentString
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.registered_activity_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}