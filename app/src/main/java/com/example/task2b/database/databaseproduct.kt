package com.example.task2b.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities = [Products::class], version = 1, exportSchema = false)
    abstract class databaseproduct : RoomDatabase() {
        abstract fun tasksDao(): Dao


        companion object {
            private var database: databaseproduct? = null
            private val DATABASE_NAME="Products-table"
            fun getInstance(context: Context): databaseproduct {
                if (database == null) {
                    database= Room.databaseBuilder(context,databaseproduct::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                }
                return database!!
            }
        }
    }
