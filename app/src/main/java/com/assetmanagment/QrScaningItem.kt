package com.assetmanagment

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class QrScaningItem : AppCompatActivity() {
    private var btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qrscanning)

        tvresult = findViewById(R.id.tvresult) as TextView

        btn = findViewById(R.id.btn) as Button

        btn!!.setOnClickListener {
            val intent = Intent(applicationContext, ScanActivity::class.java)
            startActivity(intent)
        }

    }
    companion object {

        var tvresult: TextView? = null
    }
}