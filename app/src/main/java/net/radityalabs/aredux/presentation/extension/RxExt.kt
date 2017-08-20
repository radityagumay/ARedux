package net.radityalabs.aredux.presentation.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun delay(time: Long, unit: TimeUnit, action: () -> Unit) {
    Observable.timer(time, unit, Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                action.invoke()
            }
}