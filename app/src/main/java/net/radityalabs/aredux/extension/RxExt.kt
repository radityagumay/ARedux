package net.radityalabs.aredux.extension

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun delay(time: Long, unit: TimeUnit, action: () -> Unit) {
    Observable.timer(time, unit, Schedulers.io()).subscribe {
        action.invoke()
    }
}