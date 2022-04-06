package com.example.viewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import java.lang.Exception
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(){

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewpager:ViewPager = findViewById(R.id.viewpager)
        viewpager.adapter = PhotoAdapter()
    }*/
    private var isRunning:Boolean = false
    private val picturelist = ArrayList<Photo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initpicture()//初始化数据
        val viewpager:ViewPager = findViewById(R.id.viewpager)
        viewpager.adapter = pictureAdapter(picturelist)
        viewpager.setCurrentItem(1000*picturelist.size)
        Thread(){//设置自动轮播
            isRunning = true
            while (isRunning){
                try {
                    Thread.sleep(3500)
                }catch (e:Exception){
                    e.printStackTrace()
                }
                    runOnUiThread(Runnable {
                        viewpager.setCurrentItem(viewpager.currentItem + 1)
                    })
            }
        }.start()
    }

    private fun initpicture(){
        picturelist.add(Photo(R.drawable.img4))
        picturelist.add(Photo(R.drawable.img))
        picturelist.add(Photo(R.drawable.img1))
        picturelist.add(Photo(R.drawable.img4))
        picturelist.add(Photo(R.drawable.img))
    }
}


