package com.munirasapplication.firebaseDependencies

import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
// still having an issue with firebase analytics might have to remove then try the api first


/*run app with module changes
* */
fun firebaseModule(): Module {
    // Define the Koin module
    return module {
        // Initialize FirebaseApp using androidContext from Koin
        single<FirebaseApp> { FirebaseApp.initializeApp(androidContext())!! } // Use androidContext() from Koin

        // Inject specific Firebase services
        single { FirebaseAuth.getInstance() }
        single { FirebaseFirestore.getInstance() }
        single { FirebaseAnalytics.getInstance(get()) }
    }
}
// compile 'com.facebook.android:facebook-share:latest.release' add in build.gradle dependencies