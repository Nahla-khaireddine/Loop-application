package com.example.loop

import android.content.Context
import com.example.loop.content.Content
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

interface IContentService {
    fun fetchContent(context: Context): List<Content>
}

class ContentService() : IContentService {

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    override fun fetchContent(context: Context): List<Content> {
        val gson = Gson()
        val contents = object : TypeToken<List<Content>>() {}.type
        val contentList: List<Content> = gson.fromJson(getJsonDataFromAsset(context, "content.json"), contents)
        return contentList


    }
}