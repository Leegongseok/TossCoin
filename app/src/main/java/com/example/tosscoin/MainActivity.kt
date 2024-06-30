package com.example.tosscoin

import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    var state:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var Castbutton=findViewById<Button>(R.id.Cast_button) as Button
        var coinImage=findViewById<ImageView>(R.id.coin_image) as ImageView

        Castbutton.setOnClickListener {

            var animation: Animation=AnimationUtils.loadAnimation(this,R.anim.coin_effect)
            coinImage.startAnimation(animation)

            var mediaPlayer:MediaPlayer? =MediaPlayer.create(this,R.raw.coin_effect)
            mediaPlayer?.start()

            Timer().schedule(2200){
                state=(0..1).random()
                if(state==0){
                    coinImage.setImageResource(R.drawable.coin_back)

                }else{
                    coinImage.setImageResource(R.drawable.coin_front)
                }
            }
        }
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

    }
}