package ru.bagrusss.navigation_example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import ru.bagrusss.navigation_example.R

/**
 * Created by bagrusss on 02.04.2019
 */
class StartFragment: BaseFragment() {

    override val layout = R.layout.fragment_start

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nextButton = view.findViewById<Button>(R.id.action_start_to_next)

        /*disposables += RxView.clicks(nextButton)
                             .subscribe {
                                 Navigation.findNavController(nextButton)
                                           .navigate(R.id.action_start_to_next)
                             }*/

        nextButton.setOnClickListener {
            Navigation.findNavController(nextButton)
                      .navigate(it.id)
        }
    }

}
