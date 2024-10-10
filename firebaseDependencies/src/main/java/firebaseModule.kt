package com.munirasapplication.firebaseDependencies

import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import android.app.Application
import org.koin.core.module.Module
import org.koin.dsl.module
// still having an issue with firebase analytics might have to remove then try the api first


/*run app with module changes
* */

fun firebaseModule(): Module {
    val firebaseModule = module {
        single<Firebase> { Firebase.initialize(applicationContext) } // Use applicationContext
    }
    return firebaseModule
}
// compile 'com.facebook.android:facebook-share:latest.release' add in build.gradle dependencies