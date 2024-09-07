package com.munirasapplication.firebaseDependencies

import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import org.koin.dsl.module
import com.munirasapplication.app.appcomponents.di.MyApp

/*
fun firebaseModule(): Module {
    val firebaseModule = module {
        single<Firebase> { Firebase.initialize(this@MyApp) }
    }
    return firebaseModule
}*/
fun firebaseModule(): Module {
    val firebaseModule = module {
        single<Firebase> { Firebase.initialize(applicationContext) } // Use applicationContext
    }
    return firebaseModule
}