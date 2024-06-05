package com.bensdevelops.techtask.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.bensdevelops.techtask.core.ViewData
import com.bensdevelops.techtask.mapper.PropertyViewDataMapper
import com.bensdevelops.techtask.network.repository.RepositoryImpl
import com.bensdevelops.techtask.ui.screens.home.HomeScreenViewModel
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyListViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class HomeScreenViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository: RepositoryImpl = mock()

    private val viewDataMapper: PropertyViewDataMapper = mock()

    private lateinit var viewModel: HomeScreenViewModel

    private val observer: Observer<ViewData<PropertyListViewData>> = mock()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HomeScreenViewModel(repository, viewDataMapper)
        viewModel.viewData.observeForever(observer)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        viewModel.viewData.removeObserver(observer)
    }

    @Test
    fun `on start viewData should be null null`() {
        val expected = ViewData.Data(PropertyListViewData(null, null))
        val actual = viewModel.viewData.value

        assertEquals(expected, actual)
    }

    @Test
    fun `onClick should post loading state initially`() = runTest {
        viewModel.onClick()

        verify(observer).onChanged(ViewData.Loading())
    }

    @Test
    fun `onClick should post data state when repository returns data`() = runTest {
        val data = mock(PropertyListViewData::class.java)
        `when`(repository.get()).thenReturn(Result.success(mock()))

        `when`(viewDataMapper.map(any())).thenReturn(data)

        viewModel.onClick()

        verify(observer).onChanged(ViewData.Data(data))
    }

    @Test
    fun `onClick should post error state when repository returns error`() = runTest {
        val error = Throwable("Error message")
        `when`(repository.get()).thenReturn(Result.failure(error))

        viewModel.onClick()

        verify(observer).onChanged(ViewData.Error(error))
    }
}