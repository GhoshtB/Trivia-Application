package com.example.triviaapplication

import androidx.fragment.app.Fragment

fun MainActivity.launchFragment(fragment: Fragment, id:Int){

    if (supportFragmentManager.backStackEntryCount==0) {
        supportFragmentManager.beginTransaction()
            .add(id, fragment)
            .addToBackStack(null)
            .commit()
    }else{
        supportFragmentManager.beginTransaction()
            .replace(id, fragment)
            .addToBackStack(null)
            .commit()
    }
}
