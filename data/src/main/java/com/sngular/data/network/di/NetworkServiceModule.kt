package com.sngular.data.network.di

import com.sngular.data.network.services.GenericService
import com.sngular.data.network.services.TokenService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServiceModule {
    @Singleton
    @Provides
    fun provideToken(@Named("API_TOKEN") retrofit: Retrofit): TokenService {
        return retrofit.create(TokenService::class.java)
    }

    @Singleton
    @Provides
    fun provideGenericService(@Named("API_BASE") retrofit: Retrofit): GenericService {
        return retrofit.create(GenericService::class.java)
    }
}