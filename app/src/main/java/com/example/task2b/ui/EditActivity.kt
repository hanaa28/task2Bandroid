package com.example.task2b.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.task2b.R
import com.example.task2b.database.Products
import com.example.task2b.database.databaseproduct

class EditActivity : AppCompatActivity() {
    lateinit var nameEdit: EditText
    lateinit var priceEdit: EditText
    lateinit var quantityEdit: EditText
    lateinit var totalPriceEdit: TextView
    lateinit var applyBtn: Button
    lateinit var cancelBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val id = intent.getIntExtra("id", 0)

        nameEdit=findViewById(R.id.productName)
        priceEdit=findViewById(R.id.Price)
        quantityEdit=findViewById(R.id.quantity)
        totalPriceEdit=findViewById(R.id.num_price)
        applyBtn=findViewById(R.id.add)
        cancelBtn=findViewById(R.id.Show_list)

        applyBtn.setOnClickListener {
            val name = nameEdit.text?.toString() ?: "0"
            val price = priceEdit.text?.toString() ?: "0"
            val quantity = quantityEdit.text?.toString() ?: "0"
            totalPriceEdit.text=calculateTotalPrice(price.toInt(),quantity.toInt()).toString()

            val totalPrice = totalPriceEdit.text?.toString() ?: "0"
            val product = Products(
                id=id,
                name = name,
                quantity = quantity.toDouble(),
                price = price.toDouble(),
                totalPrice = totalPrice.toDouble()
            )

            databaseproduct.getInstance(applicationContext)
                .tasksDao()
                .update(product)
            Toast.makeText(this, "product edited", Toast.LENGTH_SHORT).show()
            finish()
        }

        cancelBtn.setOnClickListener {
            finish()
        }

    }

    fun calculateTotalPrice(price:Int,quantity:Int):Int{
        return (price*quantity)

    }
}