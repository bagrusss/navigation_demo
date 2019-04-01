package ru.bagrusss.navigation_example.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by bagrusss on 02.04.2019
 */

operator fun CompositeDisposable.plusAssign(d: Disposable) {
    add(d)
}

operator fun CompositeDisposable.minusAssign(d: Disposable) {
    remove(d)
}