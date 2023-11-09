package com.example.task2b.database

import androidx.room.*
import androidx.room.Dao
import  com.example.task2b.database.Products

@Dao
interface Dao {

    @Insert
    fun add(product: Products)

    @Update
    fun update(product: Products)

    @Delete
    fun delete(product: Products)

    @Query("SELECT * FROM Products")
    fun getAll(): List<Products>
}
