package com.example.navcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import com.example.navcomponents.data.Money
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 * Use the [SpecifyAmountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecifyAmountFragment : Fragment() {
    private lateinit var navController: NavController
    private var recipient: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val message = "Sending money to $recipient"
        recipient_txt.text = message

        send_btn.setOnClickListener {
            if(!TextUtils.isEmpty(input_amount.text.toString())){
                val amount = Money(BigDecimal(input_amount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount
                )
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
            } else {
                Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
            }
        }

        cancel_btn.setOnClickListener { activity?.onBackPressed() }
    }
}
