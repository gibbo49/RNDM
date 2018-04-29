package com.chrisgibson.rndm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_thought.*

class AddThoughtActivity : AppCompatActivity() {

    var selectedCategory = FUNNY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_thought)
    }

    fun addFunnyClicked(view: View){
        if (selectedCategory == FUNNY){
            add_funny_Button.isChecked = true
            return
        }
        add_serious_clicked.isChecked = false
        add_crazy_button.isChecked = false
        selectedCategory = FUNNY
    }
    fun addSeriousClicked(view:View){
        if (selectedCategory == SERIOUS){
           add_serious_clicked.isChecked = true
            return
        }
        add_funny_Button.isChecked = false
        add_crazy_button.isChecked = false
        selectedCategory = SERIOUS
    }
    fun addCrazyClicked(view: View) {
        if (selectedCategory == CRAZY) {
            add_crazy_button.isChecked = true
            return
        }
        add_serious_clicked.isChecked = false
        add_funny_Button.isChecked = false
        selectedCategory = CRAZY
    }

    fun addPostClicked(view: View){
        val data = HashMap<String, Any>()
        data.put("category", selectedCategory)
        data.put("numComments", 0)
        data.put("numLikes", 0)
        data.put("thoughtsTxt", add_thought_text.text.toString())
        data.put("timeStamp", FieldValue.serverTimestamp())
        data.put("username", addUsernameText.text.toString())

        FirebaseFirestore.getInstance().collection(THOUGHTS_REF)
                .add(data)
                .addOnSuccessListener {
                    finish()
                }
                .addOnFailureListener {exception ->
                    Log.e("EXC", "Could not add post: $exception")
                }
    }
}
