package com.example.exercise3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener { calculate() }
        buttonReset.setOnClickListener { resetAll() }
    }

    private fun calculate() {
        //alertBox
        val alertBox = AlertDialog.Builder(this@MainActivity)

        alertBox.setTitle("Error")
        alertBox.setMessage("Please select your gender")
        alertBox.setIcon(R.mipmap.ic_launcher)

        alertBox.setNegativeButton("Close"){dialog, which ->
            dialog.dismiss()
        }
        //spinner
        var selectedSpinner = spinnerAge.selectedItem.toString()
        //checkbox (true / false)
        var smoker = checkBoxSmoker.isChecked.toString()
        //variable
        var premium = 0;
        var maleExtra = 0;
        var smokerExtra = 0;
        if (radioGroupGender.checkedRadioButtonId == -1) {
            alertBox.show()
        } else {
            //radio button
            var gender = radioGroupGender.checkedRadioButtonId
            var selectedGender = findViewById<RadioButton>(gender).text.toString()

            when (selectedSpinner) {
                "Less than 17" -> {
                    premium = 60;maleExtra = 0;smokerExtra = 0;
                }
                "17 to 25" -> {
                    premium = 70;if (selectedGender == "Male") {
                        maleExtra = 50
                    };if (smoker == "true") {
                        smokerExtra = 100;
                    }
                }
                "26 to 30" -> {
                    premium = 90;if (selectedGender == "Male") {
                        maleExtra = 100
                    };if (smoker == "true") {
                        smokerExtra = 150;
                    }
                }
                "31 to 40" -> {
                    premium = 120;if (selectedGender == "Male") {
                        maleExtra = 150
                    };if (smoker == "true") {
                        smokerExtra = 200;
                    }
                }
                "41 to 55" -> {
                    premium = 150;if (selectedGender == "Male") {
                        maleExtra = 200
                    };if (smoker == "true") {
                        smokerExtra = 250;
                    }
                }
                else -> {
                    premium = 150;if (selectedGender == "Male") {
                        maleExtra = 200
                    };if (smoker == "true") {
                        smokerExtra = 300;
                    }
                }
            }


            textViewPremium.setText(
                getString(R.string.insurance_premium) + "\nPremium = RM " + premium.toString() + "\nExtra payment for male = RM " + maleExtra.toString() + "\nExtra payment for smoker = RM " + smokerExtra.toString()
                        + "\nTotal = RM " + (premium + maleExtra + smokerExtra).toString()
            )
            //textViewPremium.setText(selectedSpinner + selectedGender + smoker)

        }
    }


    private fun resetAll(){

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);


    }

}
