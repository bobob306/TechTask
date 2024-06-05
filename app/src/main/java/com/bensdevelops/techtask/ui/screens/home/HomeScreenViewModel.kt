package com.bensdevelops.techtask.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bensdevelops.techtask.core.ViewData
import com.bensdevelops.techtask.mapper.PropertyViewDataMapper
import com.bensdevelops.techtask.network.repository.RepositoryImpl
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyListViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RepositoryImpl,
    private val viewDataMapper: PropertyViewDataMapper,
) : ViewModel() {

    // initialising this as a null, null ViewData
    private var _viewData = MutableLiveData<ViewData<PropertyListViewData>>(
        ViewData.Data(
            PropertyListViewData(null, null)
        )
    )
    val viewData: LiveData<ViewData<PropertyListViewData>> get() = _viewData

    fun onClick() {
        _viewData.postValue(ViewData.Loading())
        // this will show a spinner which blocks the user from clicking again until load is complete
        viewModelScope.launch {
            repository.get().onSuccess {
                val vd = viewDataMapper.map(it)
                // obviously mapping more than required here
                // we might want to do something more during an interview together
                // also I feel just one line would look a bit naff in the viewDataMapper
                _viewData.postValue(ViewData.Data(vd))
            }
                .onFailure {
                    _viewData.postValue(ViewData.Error(it))
                    // the call adapter will tell us what the error is, error displayed here
                }
        }
    }

}