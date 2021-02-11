package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.MessagesFragment
import com.example.myapplication.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView1 = findViewById<TextView>(R.id.textView)
        var textView2 = findViewById<TextView>(R.id.textView_2)
        var button1: Button = findViewById<Button>(R.id.button_1)
        var button2: Button = findViewById<Button>(R.id.button_2)
        var button3: Button = findViewById<Button>(R.id.Bekir)
        var editText: EditText = findViewById<EditText>(R.id.editTextText_1)
        var editText2: EditText = findViewById<EditText>(R.id.editText_2)

        button1.setOnClickListener() {
            val result: String = "${editText.text}  ${editText2.text}"
            textView1.text = result
        }

        button2.setOnClickListener() {
            val adds = editText.text.toString() + editText2.text.toString()
            textView2.text = adds
        }
        button3.setOnClickListener {
            var intent = Intent(this, BekirActivity::class.java)
            startActivity(intent)
        }

    }
}