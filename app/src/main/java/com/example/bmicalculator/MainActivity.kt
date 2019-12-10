package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateBMI()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }
    }
    private fun calculateBMI(){
        val weight : Float =  editTextWeight.text.toString().toFloat()
        val height : Float =  editTextHeight.text.toString().toFloat()

        var bmi = String.format( "%.2f", weight/((height/100) * (height/100)))
        if(bmi.toFloat() < 18.5){
            val lowweight : ImageView =findViewById(R.id.imageViewProfile)
            lowweight.setImageResource(R.drawable.under)
            textViewBMI.text = "BMI " + bmi.toString()
        }
        else if(bmi.toFloat() >= 18.5 && bmi.toFloat() <= 24.9){
            val normalWeight : ImageView =findViewById(R.id.imageViewProfile)
            normalWeight.setImageResource(R.drawable.normal)
            textViewBMI.text = "BMI " + bmi.toString()

        }
        else{
            val highWeight : ImageView =findViewById(R.id.imageViewProfile)
            highWeight.setImageResource(R.drawable.over)
            textViewBMI.text = "BMI " + bmi.toString()

        }

        //val bmiresult : Float =  textViewBMI.text.toString().toFloat()



    }

    private fun reset(){
        editTextHeight.text = null
        editTextWeight.text = null
    }
}
