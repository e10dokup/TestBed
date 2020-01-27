package dev.dokup.testbed.infra.dog

import dev.dokup.testbed.domain.dog.DogRepository
import dev.dokup.testbed.domain.dog.Dogs
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogRepositoryImpl @Inject constructor(
    private val dogRemoteDataSource: DogRemoteDataSource
) : DogRepository {

    override fun getDogs(limit: Int): Single<Dogs> {
        return dogRemoteDataSource.getDogs(limit)
            .subscribeOn(Schedulers.io())
    }
}
