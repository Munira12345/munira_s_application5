package com.munirasapplication.app.appcomponents.di

import QuoteDatabase
import android.app.Application
import androidx.room.Room
import com.munirasapplication.app.appcomponents.utility.PreferenceHelper
import com.munirasapplication.firebaseDependencies.firebaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * The application class which is used to start Koin for dependency injection.
 */
class MyApp : Application() {
    private lateinit var database: QuoteDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this

        // Initialize Room database
        database = Room.databaseBuilder(
            applicationContext,
            QuoteDatabase::class.java,
            "quote_database"
        ).build()

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            loadKoinModules(getKoinModules())
        }
    }

    // Getter for the database
    fun getDatabase(): QuoteDatabase {
        return database
    }

    /**
     * Method which prepares [PreferenceHelper]'s Koin module
     * @return [Module] - the Koin module
     */
    private fun preferenceModule(): Module {
        return module {
            single {
                PreferenceHelper()
            }
        }
    }

    /**
     * Method which returns the list of Koin modules to register
     * @return MutableList<Module> - list of Koin modules
     */
    private fun getKoinModules(): MutableList<Module> {
        return mutableListOf<Module>().apply {
            add(preferenceModule()) // Register preference module
          //  add(firebaseModule())   // Register Firebase module
        }
    }

    companion object {
        // The application instance
        private lateinit var instance: MyApp

        /**
         * Method to get instance of application object
         */
        fun getInstance(): MyApp = instance
    }
}
