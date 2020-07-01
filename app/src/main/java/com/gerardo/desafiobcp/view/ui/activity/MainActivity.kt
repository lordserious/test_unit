package com.gerardo.desafiobcp.view.ui.activity

import android.util.Log
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.base.BaseActivity
import com.gerardo.desafiobcp.view.ui.utils.ChangeMoney
import com.gerardo.desafiobcp.view.ui.utils.Money
import com.gerardo.desafiobcp.view.ui.utils.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var operation: ChangeMoney

    override fun getView(): Int = R.layout.activity_main

    override fun onCreate() {
        super.onCreate()

        Thread.sleep(2000)


        changeMoneyValue()
        calculoDeArriba()
        calculoDeAbajo()
        //setupListener()
        val currencies = Money.getAllMoney()
    }

    override fun onResume() {
        super.onResume()
        setUI()
        //validationFlags()
    }
    private fun setUI() {
        txtCompraYVenta.text = "Compra: $TIPO_CAMBIO_COMPRA_DOLAR | Venta: $TIPO_CAMBIO_VENTA_DOLAR"
    }

    private fun setupListener() {
        validationFlags()
    }

    private fun changeMoneyValue() {
        moneyChange.setOnClickListener {
            if (btnChangeIcon.text == DOLARES && btnChangeIconOut.text == SOLES) {
                Thread.sleep(100)
                btnChangeIcon.text = "Soles"
                btnChangeIconOut.text = "Dolares"
                circuloCambioDeValores()
            } else {
                Thread.sleep(100)
                btnChangeIcon.text = "Dolares"
                btnChangeIconOut.text = "Soles"
                circuloCambioDeValores()
            }
        }
    }

    fun circuloCambioDeValores() {
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

    /*VALIDACION DE BOTON PARA QUE ME ABRA LA TERCERA PANTALLA*/

    fun validationFlags() {
        when {
            btnChangeIcon.text != SOLES -> {
                startActivity(FlagsActivity::class.java)
            }
            btnChangeIconOut.text != SOLES -> {
                startActivity(FlagsActivity::class.java)
            }
            else -> {
                Log.wtf("RetoBcp", "----")
            }
        }
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

    }
}