package com.example.task2b

import android.content.Context
import android.content.SharedPreferences
    class sharedpreference(context: Context) {
        private val sharedPrefs: SharedPreferences = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        private val editor: SharedPreferences.Editor = sharedPrefs.edit()

        fun saveString(key: String, value: String) {
            editor.putString(key, value)
            editor.apply()
        }


    }