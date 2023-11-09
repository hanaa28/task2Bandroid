package com.example.task2b.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.task2b.R
import com.example.task2b.database.Products


class ProductAdapter  (var products: List<Products>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val name: TextView = itemView.findViewById(R.id.product_name)
        val quantity: TextView = itemView.findViewById(R.id.quantity_txt)
        val price: TextView = itemView.findViewById(R.id.price_txt)
        val totalPrice: TextView = itemView.findViewById(R.id.total_price_txt)
        val deleteBtn: ImageView = itemView.findViewById(R.id.delete_btn)
        val editBtn: ImageView = itemView.findViewById(R.id.edit_btn)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.productitem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.name.text = product.name
        holder.price.text = product.price.toString()
        holder.quantity.text = product.quantity.toString()
        holder.totalPrice.text = product.totalPrice.toString()
        holder

        if (onDeleteClickListener != null) {
            holder.deleteBtn.setOnClickListener {

                onDeleteClickListener?.OnItemClick(product, position)

            }
        }

        if (onEditClickListener != null) {
            holder.editBtn.setOnClickListener {
                onEditClickListener?.OnItemClick(product, position)
            }
        }

    }

    fun changeData(products: List<Products>) {
        this.products = products


        notifyDataSetChanged()

    }

    var onEditClickListener: OnItemClickListener? = null

    var onDeleteClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun OnItemClick(tasks: Products, position: Int)


    }
}