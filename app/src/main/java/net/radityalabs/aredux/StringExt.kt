package net.radityalabs.aredux

import com.google.gson.Gson


fun empty() = ""

fun <T> String.loadFileJson(clazz: Class<T>, file: String): T {
    return Gson().load(clazz, file)
}