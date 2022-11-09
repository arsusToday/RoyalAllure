package com.netease.m

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.netease.m.databinding.ActivityAuthBinding
import com.netease.m.databinding.ActivityGamePlayBinding

class GamePlay : AppCompatActivity() {
    var tapCheckerThing = 0
    lateinit var binder: ActivityGamePlayBinding
    lateinit var ca1: ImageView
    lateinit var ca2: ImageView
    lateinit var ca3: ImageView
    lateinit var ca4: ImageView
    lateinit var ca5: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityGamePlayBinding.inflate(layoutInflater)
        setContentView(binder.root)
        ca1= binder.c1
        ca2= binder.c2
        ca3= binder.c3
        ca4= binder.c4
        ca5= binder.c5

        val list = listOf<View>(ca1, ca2, ca3, ca4, ca5)
        for(i in list){
            i.setOnClickListener {
                i.rotation = i.rotation + 90
                tapCheckerThing++
                if (tapCheckerThing > 125){
                    i.isVisible = false
                    Snackbar.make(
                        binder.root, "You lost, try again!",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }

        }




    }

    fun toRules(view: View) {
        Intent(this, RulesActivity::class.java)
            .also { startActivity(it) }
    }
}