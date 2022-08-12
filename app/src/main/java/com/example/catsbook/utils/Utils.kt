package com.example.catsbook.utils

import android.content.Context
import com.example.catsbook.data.Cat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.util.*
import kotlin.Comparator

class Utils(private val context: Context) {

    private val path = "${context.cacheDir}/cat.json"

    fun getList(): MutableList<Cat> {
        var result = ""
        val isFileExists = File(path).exists()
        val inputStream = if (isFileExists) {
            File(path).inputStream()
        } else {
            context.assets.open("cat.json")
        }
        try {
            result = inputStream.bufferedReader().use { it.readText() }
            if (!isFileExists) writeDataToCacheFile(result)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStream.close()
        }
        val typeOfList = object: TypeToken<List<Cat>>() {}.type
        return Gson().fromJson(result, typeOfList)
    }

    fun saveList(list: List<Cat>) {
        val result = Gson().toJson(list)
        writeDataToCacheFile(result)
    }

    fun deleteCat(cat: Cat) {
        val List = getList()
        List.remove(cat)
        saveList(List)
    }


    private fun writeDataToCacheFile(result: String) {
        if (!File(path).exists()) {
            File(path).createNewFile()
        }
        val outputStream = File(path).outputStream()
        try {
            outputStream.bufferedWriter().use { it.write(result) }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            outputStream.close()
        }
    }

}