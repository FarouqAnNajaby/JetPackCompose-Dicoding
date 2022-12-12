package com.example.submissioncomposedicoding.repository

import com.example.submissioncomposedicoding.data.CountryData
import com.example.submissioncomposedicoding.model.Country

class CountryRepository {
    fun getCountries(): List<Country> {
        return CountryData.countries
    }

    fun searchCountry(query: String): List<Country>{
        return CountryData.countries.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}