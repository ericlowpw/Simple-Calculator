package com.example.calculatorapp2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private var eTNum1: EditText? = null
    private var eTNum2: EditText? = null
    private lateinit var tvAnswer: TextView
    private lateinit var btnNextAct: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.button_Add)
        btnSub = findViewById(R.id.button_Sub)
        btnMul = findViewById(R.id.button_Mul)
        btnDiv = findViewById(R.id.button_Div)
        eTNum1 = findViewById(R.id.edit_Number1)
        eTNum2 = findViewById(R.id.edit_Number2)
        tvAnswer = findViewById(R.id.textView_Answer)
        btnNextAct = findViewById(R.id.btnNextActivity)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnNextAct.setOnClickListener(this)
    }

    private fun nullCheck(et: EditText?):Int {
        if (et?.text.toString().isBlank()) {
            return 0
        } else {
                return et?.text.toString().toInt()
            }
    }

    override fun onClick(view: View) {
        val num1: Int = nullCheck(eTNum1)
        val num2: Int = nullCheck(eTNum2)

        when (view.id) {
            btnAdd.id -> {
                //showToast("btn Add is clicked. num are $num1 and $num2")
                tvAnswer.text = (num1 + num2).toString()
            }

            btnSub.id -> {
                //showToast("btn Sub is clicked. num are $num1 and $num2")
                tvAnswer.text = (num1 - num2).toString()
            }

            

            btnMul.id -> {
                //showToast("btn Mul is clicked. num are $num1 and $num2")
                tvAnswer.text = (num1 * num2).toString()
            }

            btnNextAct.id -> {
                Intent(this, MainActivity2::class.java).also {
                    startActivity(it)
                }
            }

            else -> {
                //showToast("btn Div is clicked. num are $num1 and $num2")
                if (num2 != 0) {
                    tvAnswer.text = (num1.toFloat() / num2.toFloat()).toString()
                } else {
                    tvAnswer.text = Double.NaN.toString()
            }
            }
        }
    }

        private fun showToast(s: String) {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        }

    }
