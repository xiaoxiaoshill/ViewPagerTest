package com.example.viewpagertest

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


/*class PhotoAdapter: PagerAdapter() {

    override fun getCount() = 3//显示3个页面

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val textview = TextView(container.context)
        textview.setGravity(Gravity.CENTER)
        textview.setTextSize(20F)
        textview.setText("第${position}页")
        container.addView(textview)
        return textview
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}*/

class pictureAdapter(val picturelist: List<Photo>): PagerAdapter(){
    override fun getCount() = Int.MAX_VALUE

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        /*val imageview = ImageView(container.context)
        imageview.setImageResource(picturelist[position%picturelist.size].imgid)//设置图片
        container.addView(imageview)
        return imageview*/
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.slideshow_item,container,false)
        val imageview:ImageView = view.findViewById(R.id.imageview)
        imageview.setImageResource(picturelist[position%picturelist.size].imgid)//设置图片
        container.addView(view)//添加布局
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}

