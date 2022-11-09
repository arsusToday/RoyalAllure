package com.netease.m

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.netease.m.AppClass.Companion.LOG_DATA
import com.netease.m.AppClass.Companion.USER_SAVED
import com.netease.m.databinding.ActivityAuthBinding
import com.netease.m.databinding.ActivityMainBinding
import com.orhanobut.hawk.Hawk

class AuthAct : AppCompatActivity() {
    lateinit var bindAuth: ActivityAuthBinding
    lateinit var editLog: EditText
    lateinit var editUser: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAuth = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(bindAuth.root)
        editLog = bindAuth.logET
        editUser = bindAuth.userET

    }

    fun goOn(view: View) {
        if(editLog.text.toString().isEmpty()){
            Snackbar.make(
                bindAuth.root, "Enter your Log",
                Snackbar.LENGTH_LONG
            ).show()
        }
        else if(editUser.text.isNullOrEmpty()){
            Snackbar.make(
                bindAuth.root, "Enter your UserName",
                Snackbar.LENGTH_LONG
            ).show()
        }
        val logData: String = editLog.text.toString()
        val userData: String = editUser.text.toString()
        Hawk.put(LOG_DATA, logData)
        Hawk.put(USER_SAVED, userData)

        Intent(this, MainMenu::class.java)
            .also { startActivity(it) }
        finish()
    }
}