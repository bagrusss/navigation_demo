package ru.bagrusss.navigation_example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by bagrusss on 02.04.2019
 */
abstract class BaseFragment: Fragment() {

    protected val disposables = CompositeDisposable()

    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

}