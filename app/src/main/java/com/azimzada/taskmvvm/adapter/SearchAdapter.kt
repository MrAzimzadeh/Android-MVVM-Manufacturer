package com.azimzada.taskmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimzada.taskmvvm.R
import com.azimzada.taskmvvm.model.Results

class SearchAdapter (var list: List<Results>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var country = itemView.findViewById<TextView>(R.id.countryId)
//        var mfr_CommonName = itemView.findViewById<TextView>(R.id.Mfr_CommonNameId)
//        var mfr_ID = itemView.findViewById<TextView>(R.id.Mfr_ID)
        var Mfr_Name = itemView.findViewById<TextView>(R.id.Mfr_Name)
        var detailBtn = itemView.findViewById<Button>(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Mfr_Name.setText(list.get(position).Mfr_CommonName)
        holder.detailBtn.setOnClickListener()
        {
            listener.OnItemClick(list[position])
        }
    }
}
