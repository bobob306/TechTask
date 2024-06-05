package com.bensdevelops.techtask.network.repository

import com.bensdevelops.techtask.network.model.PropertyListDto
import javax.inject.Inject

interface Repository {
    suspend fun get(): Result<PropertyListDto>
}

class RepositoryImpl @Inject constructor(
    private val api: Api,
) : Repository {

    override suspend fun get(): Result<PropertyListDto> {
        return api.get().onSuccess {
            it
        }
        // on failure method not needed here because it is handled in the call adapter
    }
}