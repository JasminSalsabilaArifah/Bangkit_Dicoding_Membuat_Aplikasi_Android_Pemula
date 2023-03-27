package com.example.submisionakhiraplikasi_mbti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMbti: RecyclerView
    private val list = ArrayList<MBTI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMbti = findViewById(R.id.rv_mbti)
        rvMbti.setHasFixedSize(true)

        list.addAll(getListMbti())
        showRecyclerList()

    }

    private fun getListMbti(): ArrayList<MBTI> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataType = resources.getStringArray(R.array.data_type)
        val listMbti = ArrayList<MBTI>()
        for (i in dataName.indices) {
            val hero = MBTI(dataName[i], dataDescription[i], dataPhoto[i], dataType[i])
            listMbti.add(hero)
        }
        return listMbti
    }

    private fun showRecyclerList() {
        rvMbti.layoutManager = LinearLayoutManager(this)
        val listMbtiAdapter = ListMbtiAdapter(list)
        rvMbti.adapter = listMbtiAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}