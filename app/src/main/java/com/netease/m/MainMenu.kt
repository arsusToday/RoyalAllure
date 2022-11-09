package com.netease.m

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.netease.m.AppClass.Companion.USER_SAVED
import com.netease.m.databinding.ActivityMainMenuBinding
import com.orhanobut.hawk.Hawk

class MainMenu : AppCompatActivity() {
    lateinit var bind3: ActivityMainMenuBinding
    lateinit var bindText2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind3 = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(bind3.root)
        bindText2 = bind3.headText2
        val nameOfUser = Hawk.get(USER_SAVED, "user")
        bindText2.text = "Hello $nameOfUser! You were brought here to play a game that was known for generations. Guess the right card combination!"


    }

    fun goOn2(view: View) {
        Intent(this, GamePlay::class.java)
            .also { startActivity(it) }
        finish()
    }

}