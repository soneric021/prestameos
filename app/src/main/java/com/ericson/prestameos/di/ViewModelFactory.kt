package com.ericson.prestameos.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {
    private val usedViewModelMap = HashMap<Class<out ViewModel>, ViewModel>()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (usedViewModelMap.contains(modelClass)) {
            return usedViewModelMap[modelClass] as T
        }
        val viewModelProvider = viewModels[modelClass] ?: throw IllegalArgumentException(" model class $modelClass not found")

        val viewModel = viewModelProvider.get()
        usedViewModelMap[viewModel::class.java] = viewModel

        return viewModel as T
    }

}
@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)