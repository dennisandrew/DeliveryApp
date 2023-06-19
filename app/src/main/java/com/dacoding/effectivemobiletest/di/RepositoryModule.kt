package com.dacoding.effectivemobiletest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImpl: com.dacoding.data.repository.RepositoryImpl
    ): com.dacoding.domain.repository.Repository
}

