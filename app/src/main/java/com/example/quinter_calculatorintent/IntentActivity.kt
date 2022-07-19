package com.example.quinter_calculatorintent

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


lateinit var Buttonsms:Button
lateinit var Buttoncall:Button
lateinit var Buttoncamera:Button
lateinit var Buttonemail:Button
lateinit var ButtonMpesa:Button
lateinit var Buttonshare:Button
lateinit var Buttondial:Button

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        Buttonsms=findViewById(R.id.Btn_Sms)
        Buttoncall=findViewById(R.id.Btn_Call)
        Buttoncamera=findViewById(R.id.Btn_Camera)
        Buttonemail=findViewById(R.id.Btn_Email)
        ButtonMpesa=findViewById(R.id.Btn_STK)
        Buttonshare=findViewById(R.id.Btn_Share)
        Buttondial=findViewById(R.id.Btn_Dial)

        Buttonsms.setOnClickListener {
            val uri = Uri.parse("smsto:0794838266")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "How are you today")
            startActivity(intent)

        }
        Buttoncamera.setOnClickListener {
            val takePicture= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePicture, 1)

        }
        Buttonemail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        ButtonMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        Buttonshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }
        Buttoncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0794838266"))
            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        Buttondial.setOnClickListener {
            val phone = "0794838266"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }
        
    }
}