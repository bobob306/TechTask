package com.bensdevelops.techtask.repository

import com.bensdevelops.techtask.network.repository.Api
import com.bensdevelops.techtask.network.repository.Repository
import com.bensdevelops.techtask.network.repository.RepositoryImpl
import com.bensdevelops.techtask.testData.PropertyDtoTestData
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class RepositoryTest {
    private lateinit var repository: Repository
    private val api: Api = mock()

    @Before
    fun setUp() {
        repository = RepositoryImpl(api)
    }

    // check the success path for the repository
    // runTest for coroutine
    @Test
    fun `when get request on success then verify result`() = runTest {
        val dto = PropertyDtoTestData.propertyListDto
        `when`(api.get()).thenReturn(Result.success(dto))

        val result = repository.get()
        assert(result.isSuccess)
        assertEquals(dto, result.getOrThrow())
    }

    // check the failure path for the repository
    @Test
    fun `when get request on failure then vertify result`()= runTest {
        val exception = Exception("error")
        `when`(api.get()).thenReturn(Result.failure(exception))

        val result = repository.get()
        assert(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}