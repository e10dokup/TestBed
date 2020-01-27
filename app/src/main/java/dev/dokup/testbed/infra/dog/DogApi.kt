package dev.dokup.testbed.infra.dog

import dev.dokup.testbed.domain.dog.Dog
import dev.dokup.testbed.domain.dog.Dogs
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    @GET("breeds/image/random")
    fun getDog(): Single<Dog>

    @GET("breeds/image/random/{limit}")
    fun getDogs(@Path("limit") limit: Int): Single<Dogs>
}
