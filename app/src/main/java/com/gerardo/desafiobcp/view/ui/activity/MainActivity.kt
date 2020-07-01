package com.gerardo.desafiobcp.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.utils.ChangeMoney
import com.gerardo.desafiobcp.view.ui.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var operation: ChangeMoney

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeMoneyValue()
        juegoDeComprayVenta()
    }

    private fun changeMoneyValue() {

        moneyChange.setOnClickListener {

            if (btnChangeIcon.text == DOLARES) {
                Thread.sleep(100)
                btnChangeIcon.text = "Soles"
                btnChangeIconOut.text = "Dolares"

            } else {
                Thread.sleep(100)
                btnChangeIcon.text = "Dolares"
                btnChangeIconOut.text = "Soles"

            }
        }

    }

    fun juegoDeComprayVenta() {

        if (btnChangeIcon.text == DOLARES) {
            txtMoneyOut.addTextChangedListener(object : SimpleTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    operationCompraDolares()
                }
            })
        } else {
            txtMoneyIn.addTextChangedListener(object : SimpleTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    operationVentaDolares()
                }
            })
        }
    }

    private fun finalOperation() {
        btnOperationChange.setOnClickListener {

        }
    }

    private fun redirectToFlags() {
        val nextActivity = Intent(this, FlagsActivity::class.java)
        startActivity(nextActivity)
    }


    fun operationCompraDolares() {
        val nuevoValor = operation.solesToDolares(
            (txtMoneyOut.text.toString().trim().toDouble())
        )
        txtMoneyOut.setText(nuevoValor.toString())
    }

    fun operationVentaDolares() {
        val nuevoValor = operation.dolaresToSoles(
            (txtMoneyIn.text.toString().trim().toDouble())
        )
        txtMoneyIn.setText(nuevoValor.toString())
    }


    companion object {
        private const val SOLES = "Soles"
        private const val DOLARES = "Dolares"
        private const val EURO = "E"
        private const val YEN = "Y"

    }
}