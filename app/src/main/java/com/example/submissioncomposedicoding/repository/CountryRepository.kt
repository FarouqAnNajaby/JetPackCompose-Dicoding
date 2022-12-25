package com.example.submissioncomposedicoding.repository

import com.example.submissioncomposedicoding.data.CountryData
import com.example.submissioncomposedicoding.model.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CountryRepository {

    private val listCountry = mutableListOf<Country>()

    init {
        if (listCountry.isEmpty()) {
            CountryData.countries.forEach {
                listCountry.add(Country(it.id, it.name,it.photoUrl,it.desc))
            }
        }
    }

    fun getAllCountries(): Flow<List<Country>> {
        return flowOf(listCountry)
    }

    fun getDetailCountryById(id: Long): Country {
        return listCountry.first {
            it.id == id
        }
    }
    companion object {
        @Volatile
        private var instance: CountryRepository? = null

        fun getInstance(): CountryRepository =
            instance ?: synchronized(this) {
                CountryRepository().apply {
                    instance = this
                }
            }
    }
}