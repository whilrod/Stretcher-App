package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {
    companion object {

        //NOTE: It is recommended to keep the time less than 3000 ms
        // but as this is just going to be demo so I'm using 6000 ms
        // to show the full animation.
        const val ANIMATION_TIME: Long = 5000 //Change time according to your animation.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        android.os.Handler(this.mainLooper).postDelayed({

            //This block will be executed after ANIMATION_TIME milliseconds.

            //After ANIMATION_TIME we will start the MainActivity
            startActivity(Intent(this,MainActivity::class.java))
            //To remove this activity from back stack so that
            // this activity will not show when user closes MainActivity
            finish()

        }, ANIMATION_TIME)

    }
}