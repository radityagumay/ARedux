package net.radityalabs.aredux.extension

import com.google.gson.Gson
import java.io.InputStreamReader

fun <T> load(clazz: Class<T>, file: String): T {
    return Gson().fromJson(InputStreamReader(clazz.classLoader.getResourceAsStream(file)), clazz)
}