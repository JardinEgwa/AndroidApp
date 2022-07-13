package com.example.quinter_calculatorintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var ButtonAdd:Button
    lateinit var ButtonSubtract:Button
    lateinit var ButtonMultiply:Button
    lateinit var ButtonDivide:Button
    lateinit var Edt_fnum:EditText
    lateinit var Edt_snum:EditText
    lateinit var Txt_Answer:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        ButtonAdd=findViewById(R.id.Btn_Add)
        ButtonSubtract=findViewById(R.id.Btn_Subtract)
        ButtonDivide=findViewById(R.id.Btn_Divide)
        ButtonMultiply=findViewById(R.id.Btn_Multiply)
        Edt_fnum=findViewById(R.id.Edit_Fnum)
        Edt_snum=findViewById(R.id.Edit_Snum)
        Txt_Answer=findViewById(R.id.Txt_Answer)

        ButtonAdd.setOnClickListener {
            var firstnumber=Edt_fnum.text.toString()
            var secondnumber=Edt_snum.text.toString()

            if (firstnumber.isEmpty() && secondnumber.isEmpty()){
                Txt_Answer.text="Please fill all fields"
            }else{
                var answer=firstnumber.toDouble() + secondnumber.toDouble()
                Txt_Answer.text=answer.toString()
            }
        }

        ButtonMultiply.setOnClickListener {
            var firstnumber=Edt_fnum.text.toString()
            var secondnumber=Edt_snum.text.toString()

        if (firstnumber.isEmpty() && secondnumber.isEmpty()){
            Txt_Answer.text="Please fill all fields"
        }else{
            var answer=firstnumber.toDouble() * secondnumber.toDouble()
            Txt_Answer.text=answer.toString()
        }

    }
        ButtonDivide.setOnClickListener {
            var firstnumber=Edt_fnum.text.toString()
            var secondnumber=Edt_snum.text.toString()

         if (firstnumber.isEmpty() && secondnumber.isEmpty()) {
             Txt_Answer.text="Please fill all fields"
         }else{
             var answer=firstnumber.toDouble() / secondnumber.toDouble()
             Txt_Answer.text=answer.toString()
         }
        }

        ButtonSubtract.setOnClickListener {
            var firstnumber=Edt_fnum.text.toString()
            var secondnumber=Edt_snum.text.toString()

         if (firstnumber.isEmpty() && secondnumber.isBlank()){
             Txt_Answer.text="Please fill all fields"
         }else{
             var answer=firstnumber.toDouble() - secondnumber.toDouble()
             Txt_Answer.text=answer.toString()
         }
        }
}}