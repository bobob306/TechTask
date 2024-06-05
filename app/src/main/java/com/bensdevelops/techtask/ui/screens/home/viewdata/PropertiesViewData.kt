package com.bensdevelops.techtask.ui.screens.home.viewdata

data class PropertyListViewData(
    val properties: List<PropertyViewData>?,
    val averagePrice: Int?
)

data class PropertyViewData(
    val address: String,
    val bathrooms: Int,
    val bedrooms: Int,
    val id: Int,
    val postcode: String,
    val price: Int,
    val propertyType: PropertyTypeViewData,
    val region: String,
)

enum class PropertyTypeViewData {
    DETACHED,
    TERRACED,
    FLAT,
    STUDIO,
    SEMI_DETACHED,
    UNKNOWN;

    companion object {
        fun fromString(propertyType: String): PropertyTypeViewData {
            return when (propertyType) {
                "DETACHED" -> DETACHED
                "TERRACED" -> TERRACED
                "FLAT" -> FLAT
                "STUDIO" -> STUDIO
                "SEMI_DETACHED" -> SEMI_DETACHED
                else -> UNKNOWN
            }
        }
    }
}