package com.jenyspa.moneyexchange

import android.app.Application
import com.jenyspa.moneyexchange.di.main
import org.koin.core.context.startKoin

class MoneyExchangeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(main)
        }
    }

}