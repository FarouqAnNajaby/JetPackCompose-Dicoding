package com.example.submissioncomposedicoding.di

import com.example.submissioncomposedicoding.repository.CountryRepository

object Injection {
    fun provideRepository(): CountryRepository {
        return CountryRepository.getInstance()
    }
}