package ru.bagrusss.navigation_example.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import ru.bagrusss.navigation_example.MainActivity
import ru.bagrusss.navigation_example.R

/**
 * Created by bagrusss on 02.04.2019
 */
class NextFragment : BaseFragment() {

    override val layout = R.layout.fragment_next

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            NextFragmentArgs.fromBundle(it).run {
                (requireActivity() as MainActivity).supportActionBar?.title = title
                val textView = view.findViewById<TextView>(R.id.body)
                textView.append(" id = $itemId")
            }
        }
    }

}