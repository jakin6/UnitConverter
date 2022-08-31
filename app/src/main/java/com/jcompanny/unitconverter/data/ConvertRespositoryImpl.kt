package com.jcompanny.unitconverter.data

import kotlinx.coroutines.flow.Flow

class ConvertRespositoryImpl(
    private val dao:ConvertDAO
):ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
       dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResult() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
       return  dao.getResults()
    }
}