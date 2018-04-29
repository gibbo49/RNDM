package com.chrisgibson.rndm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var selectedCategory = FUNNY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val addthoughtIntent = Intent(this, AddThoughtActivity::class.java)
            startActivity(addthoughtIntent)
        }
    }

    fun mainFunnyClicked(view: View){
        if (selectedCategory == FUNNY){
            mainFunnyBtn.isChecked = true
            return
        }
        mainSeriousBtn.isChecked = false
        mainCrazyBtn.isChecked = false
        mainPopularBtn.isChecked = false
        selectedCategory = FUNNY
    }
    fun mainSeriousClicked(view: View){
        if ( selectedCategory == SERIOUS){
            mainSeriousBtn.isChecked = true
            return
        }
        mainFunnyBtn.isChecked = false
        mainCrazyBtn.isChecked = false
        mainPopularBtn.isChecked = false
        selectedCategory = SERIOUS
    }
    fun mainCrazyClicked(view: View) {
        if (selectedCategory == CRAZY) {
            mainCrazyBtn.isChecked = true
            return
        }
        mainSeriousBtn.isChecked = false
        mainFunnyBtn.isChecked = false
        mainPopularBtn.isChecked = false
        selectedCategory = CRAZY
    }
    fun mainPopularClicked(view: View){
        if (selectedCategory == POPULAR){
            mainPopularBtn.isChecked == true
            return
        }
        mainFunnyBtn.isChecked = false
        mainSeriousBtn.isChecked = false
        mainCrazyBtn.isChecked = false
        selectedCategory = POPULAR
    }


}
