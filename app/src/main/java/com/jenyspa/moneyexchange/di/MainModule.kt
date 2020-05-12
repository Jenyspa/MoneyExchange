package com.jenyspa.moneyexchange.di

import com.jenyspa.moneyexchange.data.datasource.LocalDataSource
import com.jenyspa.moneyexchange.data.repository.ExchangeMoneyRepository
import com.jenyspa.moneyexchange.ui.MainViewModel
import org.koin.dsl.module

val main = module {
    single { LocalDataSource() }
    factory { ExchangeMoneyRepository(get()) }
    factory { MainViewModel(get()) }
}
