package com.example.untitled5

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Find the Lottie AnimationView
        val lottieView = findViewById<LottieAnimationView>(R.id.lottie_view)

        // Start the animation
        lottieView.playAnimation()

        // Add a listener to detect when the animation is complete
        lottieView.addAnimatorUpdateListener { animator ->
            if (animator.animatedFraction == 1.0f) {
                // Animation finished, delay transition to MainActivity for 1 second
                Handler().postDelayed({
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()  // Close SplashActivity
                }, 1000)  // 1-second delay
            }
        }
    }
}
