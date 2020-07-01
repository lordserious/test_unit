package com.gerardo.desafiobcp.view.ui.activity

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.adapter.CountriesAdapter
import com.gerardo.desafiobcp.view.ui.base.BaseActivity
import com.gerardo.desafiobcp.view.ui.utils.Money
import kotlinx.android.synthetic.main.activity_flags.*

class FlagsActivity : BaseActivity() {
    private lateinit var adapter: CountriesAdapter
    private val currencies = Money.getAllMoney()

    override fun getView(): Int = R.layout.activity_flags

    override fun onCreate() {
        super.onCreate()
        adapter = CountriesAdapter {i, moneyEntity ->

        }
        recycler.layoutManager = GridLayoutManager(this, 1) as RecyclerView.LayoutManager?
        adapter.data = currencies
        recycler.adapter = adapter
    }
}
