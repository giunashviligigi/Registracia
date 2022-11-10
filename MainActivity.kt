package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var Name: EditText
    private lateinit var Surname: EditText
    private lateinit var Email: EditText
    private lateinit var Password: EditText
    private lateinit var Checkbox: CheckBox
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Name=findViewById(R.id.editText)
        Surname=findViewById(R.id.editText2)
        Email=findViewById(R.id.editTextEmail)
        Password=findViewById(R.id.editTextPassword)
        Checkbox=findViewById(R.id.checkBox)
        button=findViewById(R.id.button2)

        button.setOnClickListener {
            when{
                TextUtils.isEmpty(Name.text.toString().trim())->{
                    Name.error = "გთხოვთ  შეიყვანოთ სახელი "
                }
                TextUtils.isEmpty(Surname.text.toString().trim())->{
                    Surname.error = "გთხოვთ  შეიყვანოთ გვარი "
                }
                TextUtils.isEmpty(Email.text.toString().trim())->{
                    Email.error = "გთხოვთ  შეიყვანოთ ემაილი "
                }
                TextUtils.isEmpty(Password.text.toString().trim())->{
                    Password.error = "გთხოვთ  შეიყვანოთ პაროლი "
                }
                ////CheckBox
                Name.text.toString().isNotEmpty() and Surname.text.toString().isNotEmpty() and
                        Email.text.toString().isNotEmpty() and
                        Password.text.toString().isNotEmpty()->
                    if (Name.text.toString().length>=3){
                        if(Surname.text.toString().length>=5){
                            if(Email.text.toString().matches(Regex("^[?=.*a-zA-Z0-9]+@[a-zA-Z0-9]+\\.+[a-zA-Z0-9]{2,4}\$"))){
                                if(Password.text.toString().matches(Regex("^[?=.*a-zA-Z0-9].{8,}\$"))){
                                    if(Checkbox.isChecked){
                                        Toast.makeText(baseContext,"თქვენ წარმატებით დარეგისტრირდით",
                                            Toast.LENGTH_LONG).show()

                                    }else{
                                        Checkbox.error="გთხოვთ წაიკითხოთ და დაეთანხმოთ წესებს"
                                    }
                                }else{
                                    Password.error = "გთხოვთ შეიყვანოთ სწორი ფორმატით მიღებული პაროლი"
                                }
                            }else{
                                Email.error = "გთხოვთ შეიყვანოთ სწორი ფორმატით შედგენილი Email მისამართი"
                            }


                        }else{
                            Surname.error = "გთხოვთ შეიყვანოთ მინიმუმ 5 სიმბოლოსგან შემდგარი გვარი"
                        }

                    }else{
                        Name.error = "გთხოვთ შეიყვანოთ მინიმუმ 3 სიმბოლოსგან შემდგარი სახელი"
                    }


            }


        }
    }
}