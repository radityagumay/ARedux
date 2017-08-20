package net.radityalabs.aredux.presentation.extension

fun empty() = ""

fun <T> String.loadFileJson(clazz: Class<T>, file: String): T {
    return load(clazz, file)
}