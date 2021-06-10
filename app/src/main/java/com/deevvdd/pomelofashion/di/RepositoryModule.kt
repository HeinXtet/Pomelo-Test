package com.deevvdd.pomelofashion.di

import com.deevvdd.data.repository.PickupLocationRepositoryImpl
import com.deevvdd.domain.repository.PickupLocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(
        movieRepositoryImpl: PickupLocationRepositoryImpl
    ): PickupLocationRepository
}
