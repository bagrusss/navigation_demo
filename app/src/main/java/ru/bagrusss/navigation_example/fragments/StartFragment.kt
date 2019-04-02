package ru.bagrusss.navigation_example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import ru.bagrusss.navigation_example.MainActivity
import ru.bagrusss.navigation_example.R
import ru.bagrusss.navigation_example.utils.plusAssign
import ru.bagrusss.navigation_example.utils.setupNav
import ru.bagrusss.navigation_example.utils.throttledClicks

/**
 * Created by bagrusss on 02.04.2019
 */
class StartFragment: BaseFragment() {

    override val layout = R.layout.fragment_start

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nextButton = view.findViewById<Button>(R.id.action_start_to_next)

        val args = NextFragmentArgs.Builder("Next title")
                                   .setItemId(100500)
                                   .build()
                                   .toBundle()

        //RxBinding
        disposables += nextButton.throttledClicks()
                                 .subscribe {
                                     Navigation.findNavController(nextButton)
                                               .navigate(R.id.action_start_to_next, args)
                                 }
        // OnClickListener
        nextButton.setupNav(args)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.setTitle(R.string.start)
    }

}
