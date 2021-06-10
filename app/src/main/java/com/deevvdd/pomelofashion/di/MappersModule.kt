package com.deevvdd.pomelofashion.di

import com.deevvdd.data.mapper.LocationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
@Module
@InstallIn(SingletonComponent::class)
object MappersModule {
    @Provides
    fun provideAuthMapper() = LocationMapper()
}
