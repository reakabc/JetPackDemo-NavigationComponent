package com.reakabc.jetpackdemo_navigationcomponent

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var recipient: String
    lateinit var money: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
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

        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)

        val message = "Sending money to $recipient"
        view.findViewById<TextView>(R.id.recipient).text = message

        money = view.findViewById(R.id.input_amount);

    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.send_btn -> if (!TextUtils.isEmpty(money.text.toString())){

                val amount = Money(BigDecimal(money.text.toString()))
                val bundle = bundleOf("recipient" to recipient, "amount" to amount)

                navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)

            }else{
                Toast.makeText(requireContext(), "Enter amount name!", Toast.LENGTH_SHORT).show()
            }
            R.id.cancel_btn -> requireActivity().onBackPressed()
        }

    }


}