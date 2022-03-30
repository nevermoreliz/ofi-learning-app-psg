package com.lizzars.cursos_psg_oficial

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.lizzars.cursos_psg_oficial.common.SlideWelcomeActivity

class MainActivity : AppCompatActivity() {

    val SPLASH_TIMER: Int = 2500

    //    declrar componentes de la actividad
    var background_logo: ImageView? = null

    //    animaciones
    var splash_screen_anim: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.psg_bg_light_variante)
        }

        /* hooks inicializamos las variables de la actividad */
        background_logo = findViewById(R.id.iv_background_logo)

        /* animaciones */
        splash_screen_anim = AnimationUtils.loadAnimation(this, R.anim.anim_splash_screen)

        /* set animations on elements -> asignar estas animaciones a nuestros elemeentos */
        background_logo?.setAnimation(splash_screen_anim)

        /* rediction to are activiti with delay -> rediccion a una actividad con delay*/
        Handler(Looper.getMainLooper()).postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            val i = Intent(this, SlideWelcomeActivity::class.java)
            startActivity(i)
            finish()
        }, SPLASH_TIMER.toLong())


    }
}