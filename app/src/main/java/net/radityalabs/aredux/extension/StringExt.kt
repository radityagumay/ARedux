package net.radityalabs.aredux.extension

fun empty() = ""

fun <T> String.loadFileJson(clazz: Class<T>, file: String): T {
    return load(clazz, file)
}