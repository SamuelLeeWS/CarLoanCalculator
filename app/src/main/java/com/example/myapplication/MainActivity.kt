package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val carPriceString = car_price_input.text.toString()
        val downPaymentString = down_payment_input.text.toString()
        val loanPeriodString = loan_period_input.text.toString()
        val interestRateString = interest_rate_input.text.toString()

        val carPrice:Double = carPriceString.toDouble()
        val downPayment:Double = downPaymentString.toDouble()
        val loanPeriod:Double = loanPeriodString.toDouble()
        val interestRate:Double = interestRateString.toDouble()

        val carLoan = carPrice - downPayment
        val interest = carLoan * interestRate * loanPeriod
        val monthlyPayment = (carLoan + interest) / loanPeriod / 12

        val carLoanString = carLoan.toString()
        val interestString = interest.toString()
        val monthlyPaymentString = monthlyPayment.toString()


        car_loan_display.setText(carLoanString)
        interest_display.setText(interestString)
        monthly_payment_display.setText(monthlyPaymentString)

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
