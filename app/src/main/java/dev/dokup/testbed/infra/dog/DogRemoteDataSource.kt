package dev.dokup.testbed.infra.dog

import dev.dokup.testbed.domain.dog.Dogs
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogRemoteDataSource @Inject constructor(
    private val dogApi: DogApi
) {

    fun getDogs(limit: Int): Single<Dogs> {
        return dogApi.getDogs(limit)
    }
}
