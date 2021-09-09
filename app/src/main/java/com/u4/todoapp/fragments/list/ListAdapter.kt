package com.u4.todoapp.fragments.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.u4.todoapp.R
import com.u4.todoapp.data.models.Priority
import com.u4.todoapp.data.models.ToDoData
import kotlinx.android.synthetic.main.row_layout.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        val itemView = holder.itemView
        itemView.title_txt.text = data.title
        itemView.description_txt.text = data.description
        when (data.priority) {
            Priority.HIGH -> itemView.priority_indicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.red
                )
            )
            Priority.MEDIUM -> itemView.priority_indicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.yellow
                )
            )
            Priority.LOW -> itemView.priority_indicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.green
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(toDoData: List<ToDoData>) {
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}