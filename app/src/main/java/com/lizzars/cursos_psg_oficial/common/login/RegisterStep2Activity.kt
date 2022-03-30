package com.lizzars.cursos_psg_oficial.common.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.lizzars.cursos_psg_oficial.R
import android.util.Pair as UtilPair

class RegisterStep2Activity : AppCompatActivity() {

    var btnNext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_step2)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.teal_200)
        }

        /* hooks */
        btnNext = findViewById(R.id.btn_next_register)
    }

    fun callNextRegisterScreen(view: View) {
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
            this,
            UtilPair.create(btnNext, "tsr_next_btn"),
        )

        Intent(this, RegisterStep3Activity::class.java).also {
            startActivity(it, options.toBundle())
        }
    }
}