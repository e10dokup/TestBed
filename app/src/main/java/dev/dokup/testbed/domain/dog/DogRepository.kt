package dev.dokup.testbed.domain.dog

import io.reactivex.Single

interface DogRepository {

    fun getDogs(limit: Int): Single<Dogs>
}