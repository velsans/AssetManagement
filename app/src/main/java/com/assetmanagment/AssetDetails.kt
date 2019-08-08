package com.assetmanagment

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AssetDetails : AppCompatActivity() {

    val language = arrayOf<String>(
        "Vel",
        "Murugan",
        "Jijo",
        "Jegan",
        "Sentil",
        "Karthik",
        "Vysakh",
        "Moorthi",
        "Kumar",
        "Mansoor",
        "Bharath",
        "Yazhini",
        "Pranav"
    )
    val description = arrayOf<String>(
        "C programming is considered as the base for other programming languages",
        "C++ is an object-oriented programming language.",
        "Java is a programming language and a platform.",
        ".NET is a framework which is used to develop software applications.",
        "Kotlin is a open-source programming language, used to develop Android apps and much more.",
        "Ruby is an open-source and fully object-oriented programming language.",
        "Ruby on Rails is a server-side web application development framework written in Ruby language.",
        "Python is interpreted scripting  and object-oriented programming language.",
        "JavaScript is an object-based scripting language.",
        "PHP is an interpreted language, i.e., there is no need for compilation.",
        "AJAX allows you to send and receive data asynchronously without reloading the web page.",
        "Perl is a cross-platform environment used to create network and server-side applications.",
        "Hadoop is an open source framework from Apache written in Java."
    )
    val imageId = arrayOf<Int>(
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo,
        R.mipmap.asset_logo
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.asset_details)
        val productID = findViewById(R.id.productID) as TextView
        val listView = findViewById(R.id.assetitemLV) as ListView
        productID.setText(Common.ProductName)
        val myListAdapter = AssetItemsAdapter(this, language, description, imageId)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
    }

    class AssetItemsAdapter(
        private val context: Activity,
        private val title: Array<String>,
        private val description: Array<String>,
        private val imgid: Array<Int>
    ) : ArrayAdapter<String>(context, R.layout.assetdetails_infliator, title) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val rowView = inflater.inflate(R.layout.assetdetails_infliator, null, true)

            val titleText = rowView.findViewById(R.id.assetName) as TextView
            val imageView = rowView.findViewById(R.id.icon) as ImageView

            titleText.text = title[position]
            imageView.setImageResource(imgid[position])

            return rowView
        }
    }
}