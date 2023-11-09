package com.example.task2b.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.task2b.R
import com.example.task2b.database.Products
import com.example.task2b.database.databaseproduct

class ProductActivity : AppCompatActivity() {
    lateinit var adapter: ProductAdapter
    lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        recycler=findViewById(R.id.recycler_view)

        adapter = ProductAdapter(listOf())
        recycler.adapter = adapter

        val products = (databaseproduct.getInstance(applicationContext).tasksDao().getAll())
        adapter.changeData(products)

        adapter.onDeleteClickListener=object :ProductAdapter.OnItemClickListener{

            override fun OnItemClick(product: Products, position: Int) {

                databaseproduct.getInstance(applicationContext).tasksDao().delete(product)
                val products = (databaseproduct.getInstance(applicationContext).tasksDao().getAll())

                adapter.changeData(products)

            }

        }


        adapter.onEditClickListener=object :ProductAdapter.OnItemClickListener{

            override fun OnItemClick(product: Products, position: Int) {
                val intent = Intent(this@ProductActivity, EditActivity::class.java)
                intent.putExtra("id", product.id)
                startActivity(intent)

            }
        }
    }

    override fun onStart() {
        super.onStart()
        val products = (databaseproduct.getInstance(applicationContext).tasksDao().getAll())
        adapter.changeData(products)
    }
    }