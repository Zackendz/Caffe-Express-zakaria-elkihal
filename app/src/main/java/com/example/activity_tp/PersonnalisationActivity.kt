package com.example.activity_tp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class PersonnalisationActivity : AppCompatActivity() {
    private lateinit var radiogroup: RadioGroup
    private lateinit var petit: RadioButton
    private lateinit var moyen: RadioButton
    private lateinit var grand: RadioButton
    private lateinit var supp: TextView
    private lateinit var chbox1: CheckBox
    private lateinit var chbox2: CheckBox
    private lateinit var chbox3: CheckBox
    private lateinit var switchemporter: Switch
    private lateinit var emporter: TextView
    private lateinit var lait: TextView
    private lateinit var commond: TextView
    private lateinit var prix: TextView
    private lateinit var spinner: Spinner
    private lateinit var calculer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_personnalisation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        radiogroup=findViewById(R.id.radioG)
        petit=findViewById(R.id.petit)
        moyen=findViewById(R.id.moyen)
        grand=findViewById(R.id.grand)
        supp=findViewById(R.id.supp)
        chbox1=findViewById(R.id.chbox1)
        chbox2=findViewById(R.id.chbox2)
        chbox3=findViewById(R.id.chbox3)
        switchemporter=findViewById(R.id.switchemporter)
        spinner=findViewById(R.id.spinner)
        commond=findViewById(R.id.commond)
        prix=findViewById(R.id.prix)
        calculer=findViewById(R.id.calculer)
        val laits=listOf("Lait entier","Lait écrémé","Lait d'amand(+3DH)","Sans lait")
        val prixlait=listOf(0,0,3,0)
        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item,laits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter

        val quantite=intent.getIntExtra("Quantitecofe",0)

        calculer.setOnClickListener {
            var prixtotal:Double=0.0
            val Gradio=radiogroup.checkedRadioButtonId
            val taille = when (Gradio){
                R.id.petit->"Petit"
                R.id.moyen->"Moyen"
                R.id.grand->"Grand"
                else->"Aucun"
            }
            val supp= mutableListOf<String>()
            if (chbox1.isChecked){
                supp.add("Sucre")
            }
            if (chbox2.isChecked){
                supp.add("créme")
            }
            if (chbox3.isChecked){
                supp.add("cannelle")
            }
            val switcher= if (switchemporter.isChecked) "emporter" else ""

            val position=spinner.selectedItemPosition
            val lait=spinner.selectedItem.toString()
            fun calcul(){
                var prixtaille = when (Gradio){
                    R.id.petit->8
                    R.id.moyen->10
                    R.id.grand->12
                    else->0
                }
                prixtotal+=quantite*prixtaille
                if (chbox2.isChecked){prixtotal+=quantite*2}
                if (chbox3.isChecked){prixtotal+=quantite*1}
                if (switchemporter.isChecked){prixtotal+=quantite*2}
                val prixlait=prixlait[position]
                prixtotal+=(quantite*prixlait)
                commond.text="$taille, $supp, $lait, $switcher"
                prix.text="Prix: $prixtotal DH"
            }
            calcul()
        }
    }
}