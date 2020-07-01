package com.gerardo.desafiobcp.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.utils.ChangeMoney
import com.gerardo.desafiobcp.view.ui.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var operation: ChangeMoney

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeMoneyValue()
        calculoDeArriba()
        calculoDeAbajo()
    }

    private fun changeMoneyValue() {


        //TODO NO FUNCIONA ESTA MIERDA! Y ME DESESPERA !!!
        /*
        txtMoneyOut.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) * 3.29
                Log.wtf("VENTA", "VALOR ANTIGUO$nuevoValor")
                txtMoneyIn.setText(nuevoValor.toString())
            }
        })

        txtMoneyIn.addTextChangedListener(object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) * 3.25
                Log.wtf("COMPRA", "VALOR ANTIGUO$nuevoValor")
                txtMoneyOut.setText(nuevoValor.toString())

            }
        })*/

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

    private fun calculoDeArriba() {
        btnOperationChange.setOnClickListener {
            if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
                val nuevoValor =
                    (txtMoneyOut.text.toString().trim().toDouble()) / TIPO_CAMBIO_COMPRA
                txtMoneyIn.setText(nuevoValor.toString())
            } else {
                val nuevoValor =
                    (txtMoneyOut.text.toString().trim().toDouble()) * TIPO_CAMBIO_VENTA
                txtMoneyIn.setText(nuevoValor.toString())
            }
        }
    }

    private fun calculoDeAbajo() {
        btnOperationChange2.setOnClickListener {
            if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
                val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA
                txtMoneyOut.setText(nuevoValor.toString())
            } else {
                val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA
                txtMoneyOut.setText(nuevoValor.toString())
            }
        }
    }

    private fun redirectToFlags() {
        val nextActivity = Intent(this, FlagsActivity::class.java)
        startActivity(nextActivity)
    }

    fun operationCompraDolares() {
        val nuevoValor = (txtMoneyIn.text.toString().trim().toDouble()) / 3.25
        Log.wtf("COMPRA", "VALOR ANTIGUO$nuevoValor")
        txtMoneyIn.setText(nuevoValor.toString())
    }

    fun operationVentaDolares() {
        val nuevoValorDolares = (txtMoneyIn.text.toString().trim().toDouble()) * 3.29
        Log.wtf("VENTA", "VALOR ANTIGUO$nuevoValorDolares")
        txtMoneyOut.setText(nuevoValorDolares.toString())
    }


    companion object {

        private const val TIPO_CAMBIO_VENTA = 3.29
        private const val TIPO_CAMBIO_COMPRA = 3.25

        private const val SOLES = "Soles"
        private const val DOLARES = "Dolares"
        private const val EURO = "E"
        private const val YEN = "Y"


    }
}