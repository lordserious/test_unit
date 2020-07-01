package com.gerardo.desafiobcp.view.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.utils.ChangeMoney
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var money: ChangeMoney

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeIcon.setOnClickListener { redirectToFlags() }

        btnChangeIconOut.setOnClickListener { redirectToFlags() }

    }


    private fun redirectToFlags() {
        val nextActivity = Intent(this, FlagsActivity::class.java)
        startActivity(nextActivity)
    }

    fun operationChange() {
        money.solesToDolares(100.00)
    }


    companion object {
        private const val SOLES = "Soles"
        private const val DOLARES = "Dolares"

    }
}
