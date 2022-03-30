package com.lizzars.cursos_psg_oficial.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.lizzars.cursos_psg_oficial.MainActivity
import com.lizzars.cursos_psg_oficial.R
import com.lizzars.cursos_psg_oficial.activities.estudent.user_common.UserComonHomeActivity
import com.lizzars.cursos_psg_oficial.common.adapter_common.IntroSlideAdapter
import com.lizzars.cursos_psg_oficial.common.login.LoginActivity
import me.relex.circleindicator.CircleIndicator3

class SlideWelcomeActivity : AppCompatActivity() {

    private var imageList = mutableListOf<Int>()
    private var titleList = mutableListOf<Int>()
    private var descriptionList = mutableListOf<Int>()


    private var imageLightList = mutableListOf<Int>()
    private var titleLightList = mutableListOf<Int>()
    private var descriptionLightList = mutableListOf<Int>()

    var slider: ViewPager2? = null
    var indicador: CircleIndicator3? = null

    var btnToLogin: Button? = null
    var btnToNavigate: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_welcome)

        /* añadir a la matriz objetos para el slider */
        addToList(
            R.drawable.mision,
            R.string.title_mision,
            R.string.desc_mision
        )

        addToList(
            R.drawable.vision,
            R.string.title_vision,
            R.string.desc_vision
        )

        addToList(
            R.drawable.objetivo,
            R.string.title_objetivo,
            R.string.desc_objetivo
        )

        addToListLight(
            R.drawable.mision_light,
            R.string.title_mision,
            R.string.desc_mision
        )

        addToListLight(
            R.drawable.vision_light,
            R.string.title_vision,
            R.string.desc_vision
        )

        addToListLight(
            R.drawable.objetivo_light,
            R.string.title_objetivo,
            R.string.desc_objetivo
        )

        /*  val currentNightMode =  Configuration.UI_MODE_NIGHT_MASK */
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {


            Configuration.UI_MODE_NIGHT_NO -> {
                Toast.makeText(this, "esto es no ${currentNightMode}", Toast.LENGTH_LONG)
                    .show()

                slider = findViewById(R.id.vp2_slider_intro)
                slider?.adapter = IntroSlideAdapter(imageList, titleList, descriptionList)
                slider?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                slider?.removeOverScroll()
            }

            Configuration.UI_MODE_NIGHT_YES -> {
                Toast.makeText(this, "esto es si ${currentNightMode}", Toast.LENGTH_LONG)
                    .show()

                slider = findViewById(R.id.vp2_slider_intro)
                slider?.adapter =
                    IntroSlideAdapter(imageLightList, titleLightList, descriptionLightList)
                slider?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                slider?.removeOverScroll()
            }

        }

        indicador = findViewById(R.id.ci3_indicador)
        indicador?.setViewPager(slider)


//        imageViewGoToRegister?.setOnClickListener { goToRegister() }

        btnToLogin = findViewById(R.id.btn_ir_login)
        btnToLogin?.setOnClickListener { goToLogin() }


        btnToNavigate = findViewById(R.id.btn_ir_navegar)
        btnToNavigate?.setOnClickListener { goToNavegarUserCommonHome() }


    }

    /* metodos para ir a una vista o actividad */
    private fun goToLogin() {
        val i = Intent(this, LoginActivity::class.java)
        /* eliminar historial de pantallas */
        // i.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    private fun goToNavegarUserCommonHome() {
        val i = Intent(this, UserComonHomeActivity::class.java)
        /* eliminar historial de pantallas */
        // i.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }


    private fun addToList(image: Int, title: Int, description: Int) {
        imageList.add(image)
        titleList.add(title)
        descriptionList.add(description)
    }

    private fun addToListLight(image: Int, title: Int, description: Int) {
        imageLightList.add(image)
        titleLightList.add(title)
        descriptionLightList.add(description)
    }

    private fun ViewPager2.removeOverScroll() {
        (getChildAt(0) as? RecyclerView)?.overScrollMode = View.OVER_SCROLL_NEVER
    }
}