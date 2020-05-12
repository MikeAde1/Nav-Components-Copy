package com.example.navcomponents

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.frag_main.view.*


class MainFragment : Fragment() {

    private lateinit var navController: NavController
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.view_transactions_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionsFragment)
        }

        view.send_money_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }

        view.view_balance_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }
}
