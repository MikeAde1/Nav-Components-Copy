package com.example.navcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_choose_recipient.view.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        next_btn.setOnClickListener {
            if(!TextUtils.isEmpty(input_recipient.text.toString())) {
                val bundle = bundleOf("recipient" to input_recipient.text.toString())
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment2, bundle)
            } else {
                Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
            }
        }
        cancel_btn.setOnClickListener { activity?.onBackPressed() }
    }

}
