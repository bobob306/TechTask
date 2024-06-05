package com.bensdevelops.techtask.mapper

import com.bensdevelops.techtask.network.model.PropertyListDto
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyListViewData
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyTypeViewData
import com.bensdevelops.techtask.ui.screens.home.viewdata.PropertyViewData
import javax.inject.Inject

class PropertyViewDataMapper @Inject constructor() {

    fun map(
        propertyListDto: PropertyListDto
    ): PropertyListViewData {
        return PropertyListViewData(
            properties = propertyListDto.properties.map {
                PropertyViewData(
                    address = it.address,
                    bathrooms = it.bathrooms,
                    bedrooms = it.bedrooms,
                    id = it.id,
                    postcode = it.postcode,
                    price = it.price,
                    // my opinion is propertyType is a discreet type of data so better to have as an enum
                    // so that potentially a user can select a type of property to see
                    // unknown handles a categorisation error
                    propertyType = PropertyTypeViewData.fromString(it.propertyType),
                    region = it.region
                    // you will notice number is not mapped
                    // this is at aimed at privacy for a vendor
                )
            },
            averagePrice = propertyListDto.properties.map { it.price }.average().toInt()
        )
    }
}