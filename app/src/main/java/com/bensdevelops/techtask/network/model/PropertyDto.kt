package com.bensdevelops.techtask.network.model

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName
import org.intellij.lang.annotations.Identifier

@Serializable
data class PropertyListDto(
    @SerialName("properties")
    val properties: List<PropertyDto>,
)


@Serializable
data class PropertyDto(
    @SerialName("id")
    val id: Int,
    @SerialName("address")
    val address: String,
    @SerialName("bathrooms")
    val bathrooms: Int,
    @SerialName("bedrooms")
    val bedrooms: Int,
    @SerialName("number")
    val number: String,
    @SerialName("postcode")
    val postcode: String,
    @SerialName("price")
    val price: Int,
    @SerialName("propertyType")
    val propertyType: String,
    @SerialName("region")
    val region: String,
)
// as far as i can no nullable fields
