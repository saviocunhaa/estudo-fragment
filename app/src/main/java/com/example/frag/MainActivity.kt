package com.example.frag

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.frag.fragments.ChamadasFragment
import com.example.frag.fragments.ConversaFragment

class MainActivity : AppCompatActivity() {
    private lateinit var btnConversa : Button
    private lateinit var btnChamadas : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnConversa = findViewById(R.id.btnConversa)
        btnChamadas = findViewById(R.id.btnChamadas)

        btnConversa.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentConteudo, ConversaFragment())
                .commit()

        }

        btnChamadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentConteudo, ChamadasFragment())
                .commit()
        }


    }
}