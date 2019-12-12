package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculator(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clear(it)
        }
    }

    private fun calculator(view:View){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)

        when{
            weight.text.isBlank() -> weight.setText("Enter Your Weight")
            height.text.isBlank() -> height.setText("Enter Your Height")

            else ->{
                val total = calBMI(weight.text.toString().toDouble(), height.text.toString().toDouble())
                when{
                    total <18.5 ->{
                        imageViewProfile.setImageResource(R.drawable.under)
                        textViewBMI.setText(textViewBMI.text.toString().plus(total.toString()))
                    }
                    total >=18.5 && total <=24.9 ->{
                        imageViewProfile.setImageResource(R.drawable.normal)
                        textViewBMI.setText((textViewBMI.text.toString().plus(total.toString())))
                    }
                    total >24.9 ->{
                        imageViewProfile.setImageResource(R.drawable.over)
                        textViewBMI.setText(textViewBMI.text.toString().plus(total.toString()))
                    }
                }
            }
        }
    }

    private fun clear(view:View){
        editTextWeight.setText("")
        editTextHeight.setText("")
        imageViewProfile.setImageResource((R.drawable.empty))
        textViewBMI.setText("BMI :")
    }

    private fun calBMI(a:Double, b:Double) :Double{
        return a / ((b / 100) * (b / 100))
    }
}
