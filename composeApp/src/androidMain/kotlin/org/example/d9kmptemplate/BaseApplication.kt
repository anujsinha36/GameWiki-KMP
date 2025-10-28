package org.example.d9kmptemplate

import android.app.Application
import org.example.d9kmptemplate.di.initKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}