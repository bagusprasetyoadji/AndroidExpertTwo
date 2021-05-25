package com.bagusprasetyoadji.androidexpertone

import android.app.Application
import com.bagusprasetyoadji.androidexpertone.core.di.databaseModule
import com.bagusprasetyoadji.androidexpertone.core.di.networkModule
import com.bagusprasetyoadji.androidexpertone.core.di.repositoryModule
import com.bagusprasetyoadji.androidexpertone.di.useCaseModule
import com.bagusprasetyoadji.androidexpertone.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}