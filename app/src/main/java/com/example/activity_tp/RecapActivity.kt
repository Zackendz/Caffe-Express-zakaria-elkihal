package com.example.activity_tp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecapActivity : AppCompatActivity() {
    private lateinit var ClientName: TextView
    private lateinit var Cofe: TextView
    private lateinit var The: TextView
    private lateinit var Croissant: TextView
    private lateinit var Total2: TextView
    private lateinit var Modifier: Button
    private lateinit var Confirmer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recap)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ClientName = findViewById(R.id.clientn)
        Cofe= findViewById(R.id.cofe)
        The=findViewById(R.id.The)
        Croissant=findViewById(R.id.croissant)
        Total2=findViewById(R.id.total2)
        Modifier=findViewById(R.id.btnmodifier)
        Confirmer=findViewById(R.id.btnconfi)

    }
}