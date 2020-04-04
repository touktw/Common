package io.teokim.common.network

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by tae.kim on 2020/04/04.
 */

abstract class BaseService<C : BaseHttpClient, A : BaseApi>(
    private val baseUrl: String,
    private val client: C,
    private val clazz: Class<A>
) {

    open fun getConverterFactories(): List<Converter.Factory> {
        return listOf(GsonConverterFactory.create())
    }

    val api: A = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client.client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(clazz)

    val newApi: A
        get() {
            val builder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client.client)
            for (factory in getConverterFactories()) {
                builder.addConverterFactory(factory)
            }
            return builder.build().create(clazz)
        }
}