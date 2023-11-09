package com.example.task2b.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.task2b.R
import com.example.task2b.database.Products
import com.example.task2b.database.databaseproduct

class PutproductActivity : AppCompatActivity() {
    lateinit var nameEdit: EditText
    lateinit var priceEdit: EditText
    lateinit var quantityEdit: EditText
    lateinit var totalPriceEdit: TextView
    lateinit var addBtn: Button
    lateinit var viewProductsBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_putproduct)


        nameEdit=findViewById(R.id.productName)
        priceEdit=findViewById(R.id.Price)
        quantityEdit=findViewById(R.id.quantity)
        totalPriceEdit=findViewById(R.id.num_price)
        addBtn=findViewById(R.id.add)
        viewProductsBtn=findViewById(R.id.Show_list)
        addBtn.setOnClickListener {
            val name = nameEdit.text?.toString() ?: "0"
            val price = priceEdit.text?.toString() ?: "0"
            val quantity = quantityEdit.text?.toString() ?: "0"
            totalPriceEdit.text=TotalPrice(price.toInt(),quantity.toInt()).toString()
            val totalPrice = totalPriceEdit.text?.toString() ?: "0"
            val product = Products(
                name = name,
                quantity = quantity.toDouble(),
                price = price.toDouble(),
                totalPrice = totalPrice.toDouble()
            )

            databaseproduct.getInstance(applicationContext)
                .tasksDao()
                .add(product)
            Toast.makeText(this, "product added", Toast.LENGTH_SHORT).show()
        }

        viewProductsBtn.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }

    }

    fun TotalPrice(price:Int,quantity:Int):Int{
        return (price*quantity)

    }
}