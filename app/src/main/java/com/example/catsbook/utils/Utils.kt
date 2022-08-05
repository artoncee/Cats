package com.example.catsbook.utils

import android.content.Context
import com.example.catsbook.data.Cat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Utils(private val context: Context) {

    fun getJSON(): List<Cat> {
        var result = ""
        val inputStream = context.assets.open("cat.json")
        try {
            result = inputStream.bufferedReader().use { it.readText() }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            inputStream.close()
        }

        val listCat = object: TypeToken<List<Cat>>() {}.type
        return Gson().fromJson(result, listCat)
    }

}