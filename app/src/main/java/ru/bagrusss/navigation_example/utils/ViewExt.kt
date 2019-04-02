package ru.bagrusss.navigation_example.utils

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by bagrusss on 02.04.2019
 */

fun View.setupNav(args: Bundle? = null) = setOnClickListener {
    Navigation.findNavController(this)
              .navigate(id, args)
}

fun View.throttledClicks(duration: Long = 300): Observable<Any> {
    return RxView.clicks(this)
                 .throttleFirst(duration, TimeUnit.MILLISECONDS)
}