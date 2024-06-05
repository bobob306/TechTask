package com.bensdevelops.techtask.testData

import com.bensdevelops.techtask.network.model.PropertyDto
import com.bensdevelops.techtask.network.model.PropertyListDto
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyListViewData
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyTypeViewData
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyViewData

object PropertyDtoTestData {
    private val propertyDto = PropertyDto(
        id = 7584,
        address = "London Road",
        bathrooms = 1,
        bedrooms = 2,
        number = "1",
        postcode = "ll11ll",
        price = 1000,
        propertyType = "SEMI_DETACHED",
        region = "LONDON"
    )

    private val unknownTypePropertyDto = propertyDto.copy(
        propertyType = "MANSION"
    )

    val propertyListDto = PropertyListDto(
        properties = listOf(
            propertyDto,
            propertyDto.copy(price = 2000),
            propertyDto.copy(price = 3000),
            propertyDto.copy(price = 4000),
            )
    )
    val unknownPropertyListDto = PropertyListDto(
        properties = listOf(unknownTypePropertyDto)
    )

}

object PropertyViewDataTestData {
    private val propertyViewData = PropertyViewData(
        id = 7584,
        address = "London Road",
        bathrooms = 1,
        bedrooms = 2,
        postcode = "ll11ll",
        price = 1000,
        propertyType = PropertyTypeViewData.SEMI_DETACHED,
        region = "LONDON"
    )

    val propertyListViewData = PropertyListViewData(
        properties = listOf(
            propertyViewData,
            propertyViewData.copy(price = 2000),
            propertyViewData.copy(price = 3000),
            propertyViewData.copy(price = 4000),
        ),
        averagePrice = 2500,
    )

    val unknownPropertyListViewData = PropertyListViewData(
        properties = listOf(propertyViewData.copy(propertyType = PropertyTypeViewData.UNKNOWN)),
        averagePrice = 1000
    )
}