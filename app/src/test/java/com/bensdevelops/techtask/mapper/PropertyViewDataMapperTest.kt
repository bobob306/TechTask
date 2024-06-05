package com.bensdevelops.techtask.mapper

import com.bensdevelops.techtask.testData.PropertyDtoTestData
import com.bensdevelops.techtask.testData.PropertyViewDataTestData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PropertyViewDataMapperTest {

    private lateinit var propertyViewDataMapper: PropertyViewDataMapper

    @Before
    fun setUp() {
        propertyViewDataMapper = PropertyViewDataMapper()
    }

    @Test
    fun `when dto is present then return viewData`() {
        val dto = PropertyDtoTestData.propertyListDto
        val expected = PropertyViewDataTestData.propertyListViewData
        val actual = propertyViewDataMapper.map(dto)

        assertEquals(expected, actual)
    }

    // testing the property type mapper works with unknown types
    @Test
    fun `when dto is present and property type is not known then return unknown property type`() {
        val dto = PropertyDtoTestData.unknownPropertyListDto
        val expected = PropertyViewDataTestData.unknownPropertyListViewData
        val actual = propertyViewDataMapper.map(dto)

        assertEquals(expected, actual)
    }

    // this test is actually covered in the tests above, however since this is the focus of the
    // task nice to have its own test just for it
    @Test
    fun `when dto is present calculate correct average price`() {
        val dto = PropertyDtoTestData.propertyListDto
        val expected = PropertyViewDataTestData.propertyListViewData.averagePrice
        val actual = propertyViewDataMapper.map(dto).averagePrice

        assertEquals(expected, actual)
    }
}