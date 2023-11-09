package com.example.task2b.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Products(
    @ColumnInfo @PrimaryKey (autoGenerate = true)   var id:Int?=null,
    @ColumnInfo    var name:String?=null,
    @ColumnInfo    var quantity:Double?=null,
    @ColumnInfo val price: Double,
    @ColumnInfo val totalPrice:Double
)

