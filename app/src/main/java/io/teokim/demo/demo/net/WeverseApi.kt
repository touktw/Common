package io.teokim.demo.demo.net

import io.teokim.common.network.BaseApi
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by tae.kim on 2020/04/04.
 */


interface WeverseApi : BaseApi {
    @GET("artists")
    suspend fun getArtists(): Response<ArtistResponse>
}