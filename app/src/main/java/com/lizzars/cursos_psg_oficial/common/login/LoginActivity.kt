package com.lizzars.cursos_psg_oficial.common.login

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lizzars.cursos_psg_oficial.R
import android.util.Pair as UtilPair

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun callToRegisterView(view: View) {
         val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
            this,
            UtilPair.create(findViewById(R.id.btn_register), "tsr_register"),
        )

        Intent(this, RegisterStep1Activity::class.java).also {
            startActivity(it, options.toBundle())
        }
    }
}