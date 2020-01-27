package dev.dokup.testbed.infra.dog

import dagger.Binds
import dagger.Module
import dev.dokup.testbed.domain.dog.DogRepository

@Module
interface DogRepositoryModule {

    @Binds
    fun bindRepository(repository: DogRepositoryImpl): DogRepository
}
