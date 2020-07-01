package com.gerardo.desafiobcp.view.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.base.BaseActivity
import com.gerardo.desafiobcp.view.ui.entity.MoneyEntity
import com.gerardo.desafiobcp.view.ui.utils.ChangeMoney
import com.gerardo.desafiobcp.view.ui.utils.Money
import com.gerardo.desafiobcp.view.ui.utils.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var operation: ChangeMoney
    lateinit var moneyBase : MoneyEntity
    lateinit var moneyBase2 : MoneyEntity

    override fun getView(): Int = R.layout.activity_main

    @SuppressLint("SetTextI18n")
    override fun onCreate() {
        super.onCreate()
        Thread.sleep(2000)
        moneyBase = Money.getCurrency("PEN")
        moneyBase2 = Money.getCurrency("USD")

        btnChangeIcon.tag = moneyBase
        btnChangeIconOut.tag = moneyBase2

        btnChangeIcon.text = moneyBase.moneyName
        btnChangeIconOut.text = moneyBase2.moneyName
        txtCompraYVenta.text = "Compra: ${moneyBase2.typeChangeBuy} | Venta: ${moneyBase2.typeChangeSale}"

        changeMoneyValue()
        /*calculoDeArriba()
        calculoDeAbajo()*/
    }

    override fun onResume() {
        super.onResume()
        /*setUI()*/
        //validationFlags()
    }
    private fun setUI() {
        btnChangeIcon.text = (btnChangeIcon.tag as MoneyEntity).moneyName
        btnChangeIconOut.text = (btnChangeIconOut.tag as MoneyEntity).moneyName
    }

    private fun changeMoneyValue() {
        moneyChange.setOnClickListener {
            val temporalSave = btnChangeIcon.tag as MoneyEntity
            val temporalSave2 = btnChangeIconOut.tag as MoneyEntity
            btnChangeIcon.tag = temporalSave2
            btnChangeIconOut.tag = temporalSave
            btnChangeIcon.text = temporalSave2.moneyName
            btnChangeIconOut.text = temporalSave.moneyName
            Log.d("click_b", "________________${(btnChangeIcon.tag as MoneyEntity).moneyName}")
            Log.d("click_b", "________________${(btnChangeIconOut.tag as MoneyEntity).moneyName}")
            changedValues()
        }

    }
    private fun changedValues() {
        when {
            btnChangeIcon.tag == moneyBase2 && btnChangeIconOut.tag == moneyBase -> {
                val newValue = if(txtMoneyIn.text.toString().trim().isNotEmpty()) (txtMoneyIn.text.toString().trim().toDouble()) * moneyBase2.typeChangeBuy else ""// TIPO_CAMBIO_COMPRA_DOLAR
                txtMoneyOut.setText(newValue.toString())
            }
            btnChangeIcon.tag == moneyBase && btnChangeIconOut.tag == moneyBase2 -> {
                val newValue = if(txtMoneyIn.text.toString().trim().isNotEmpty()) (txtMoneyIn.text.toString().trim().toDouble()) / moneyBase2.typeChangeSale else ""// TIPO_CAMBIO_VENTA_DOLAR
                txtMoneyOut.setText(newValue.toString())
            }
            else -> {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG)
            }
        }
    }

    fun setClick() {
        btnChangeIcon.setOnClickListener {
            if ((it.tag as MoneyEntity) != moneyBase) openCurrencyFlag(0)
        }

        btnChangeIcon.setOnClickListener {
            if ((it.tag as MoneyEntity) != moneyBase) openCurrencyFlag(1)
        }
    }

    private fun calculoDeArriba() {
        btnOperationChange.setOnClickListener {
            when {
                btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyOut.text.toString().trim().toDouble()) / TIPO_CAMBIO_COMPRA_DOLAR
                    txtMoneyIn.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == DOLARES -> {
                    val nuevoValor =
                        (txtMoneyOut.text.toString().trim().toDouble()) * TIPO_CAMBIO_VENTA_DOLAR
                    txtMoneyIn.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == EUROS && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_COMPRA_EURO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == EUROS -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_VENTA_EURO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == LIBRAS && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_COMPRA_LIBRA
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == LIBRAS -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_VENTA_LIBRA
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == YENES && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_COMPRA_YEN
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == YENES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_VENTA_YEN
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == DOLAR_CANADIENSE && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim()
                            .toDouble()) / TIPO_CAMBIO_COMPRA_DOLAR_CANADIENSE
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == DOLAR_CANADIENSE -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim()
                            .toDouble()) * TIPO_CAMBIO_VENTA_DOLAR_CANADIENSE
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == FRANCO_SUIZO && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim()
                            .toDouble()) / TIPO_CAMBIO_COMPRA_FRANCO_SUIZO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == FRANCO_SUIZO -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim()
                            .toDouble()) * TIPO_CAMBIO_VENTA_FRANCO_SUIZO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
            }
        }
    }

    private fun calculoDeAbajo() {
        btnOperationChange2.setOnClickListener {
            when {
                btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_DOLAR
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == DOLARES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_DOLAR
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == EUROS && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_EURO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == EUROS -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_EURO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == LIBRAS && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_LIBRA
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == LIBRAS -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_LIBRA
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == YENES && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_YEN
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == YENES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_YEN
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == DOLAR_CANADIENSE && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim()
                            .toDouble()) * TIPO_CAMBIO_COMPRA_DOLAR_CANADIENSE
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == DOLAR_CANADIENSE -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim()
                            .toDouble()) / TIPO_CAMBIO_VENTA_DOLAR_CANADIENSE
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == FRANCO_SUIZO && btnChangeIconOut.text == SOLES -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) * TIPO_CAMBIO_COMPRA_FRANCO_SUIZO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
                btnChangeIcon.text == SOLES && btnChangeIconOut.text == FRANCO_SUIZO -> {
                    val nuevoValor =
                        (txtMoneyIn.text.toString().trim().toDouble()) / TIPO_CAMBIO_VENTA_FRANCO_SUIZO
                    txtMoneyOut.setText(nuevoValor.toString())
                }
            }
        }
    }

    fun openCurrencyFlag(typeButton : Int) {
        startActivityForResult(Intent(this, FlagsActivity::class.java).apply {
            putExtra("extra0", typeButton)
        }, REQUEST_MONEY)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Activity.RESULT_OK == resultCode && REQUEST_MONEY == requestCode) {
            val typeButton = data?.getSerializableExtra("extra0") as Int
            val moneyEntity = data?.getSerializableExtra("extra1") as MoneyEntity
            moneyBase2 = moneyEntity
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {

        //Dolar
        private const val TIPO_CAMBIO_VENTA_DOLAR = 3.29
        private const val TIPO_CAMBIO_COMPRA_DOLAR = 3.25
        //Euros
        private const val TIPO_CAMBIO_VENTA_EURO= 4.10
        private const val TIPO_CAMBIO_COMPRA_EURO = 4.20
        //Libras
        private const val TIPO_CAMBIO_VENTA_LIBRA= 5.00
        private const val TIPO_CAMBIO_COMPRA_LIBRA = 5.50
        //Yen
        private const val TIPO_CAMBIO_VENTA_YEN= 5.00
        private const val TIPO_CAMBIO_COMPRA_YEN = 5.50
        //Dolar Canadiense
        private const val TIPO_CAMBIO_VENTA_DOLAR_CANADIENSE= 2.29
        private const val TIPO_CAMBIO_COMPRA_DOLAR_CANADIENSE = 2.50
        //Franco Suizo
        private const val TIPO_CAMBIO_VENTA_FRANCO_SUIZO= 2.29
        private const val TIPO_CAMBIO_COMPRA_FRANCO_SUIZO = 2.50

        private const val SOLES = "Soles"
        private const val DOLARES = "Dolares"
        private const val EUROS = "Euros"
        private const val LIBRAS = "Libras"
        private const val YENES = "Yenes"
        private const val DOLAR_CANADIENSE = "Dolar Canadiense"
        private const val FRANCO_SUIZO = "Franco Suizo"

        private const val REQUEST_MONEY = 2863
    }
}