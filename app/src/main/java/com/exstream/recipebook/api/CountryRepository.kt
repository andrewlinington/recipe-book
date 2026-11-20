package com.exstream.recipebook.api

import com.apollographql.apollo.ApolloClient
import com.exstream.`recipe-book`.GetCountriesQuery
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CountryRepository @Inject constructor(
    private val client: ApolloClient
) {

    fun getCountry(): Flow<List<String>?> =
        client.query(GetCountriesQuery())
            .toFlow().map {
            it.data?.countries?.map { country ->  country.name }
        }
}