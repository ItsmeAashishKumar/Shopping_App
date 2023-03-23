package com.example.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomView=findViewById<BottomNavigationView>(R.id.bottomView)
        replaceWithFragment(Home())

       bottomView.setOnItemSelectedListener {
           when(it.itemId){
                R.id.home->replaceWithFragment(Home())
               R.id.profile->replaceWithFragment(Profile())
               R.id.cart->replaceWithFragment(Cart())
               else->{

               }
           }
           true


       }
    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }

}