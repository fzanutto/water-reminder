package di

import org.koin.core.context.startKoin
import presentation.di.presentationModule

fun initKoin(){
    startKoin {
        modules(presentationModule)
    }
}