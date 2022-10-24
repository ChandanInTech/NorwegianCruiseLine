package com.chandan.norwegiancruiseline

import android.app.Application
import com.chandan.norwegiancruiseline.dependency_injection.KoinModules.nclModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class NCLApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NCLApplication)
            modules(nclModules)
        }

    }
}