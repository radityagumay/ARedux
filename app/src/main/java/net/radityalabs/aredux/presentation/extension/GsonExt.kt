package net.radityalabs.aredux.presentation.extension

import com.google.gson.Gson
import java.io.InputStreamReader

fun <T> load(clazz: Class<T>, file: String): T = Gson().fromJson(InputStreamReader(clazz.classLoader.getResourceAsStream(file)), clazz)