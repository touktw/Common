package io.teokim.common.network

import okhttp3.Headers
import okhttp3.OkHttpClient

/**
 * Created by tae.kim on 2020/04/04.
 */

abstract class BaseHttpClient {
    abstract fun getHeaders(): Headers?

    val client: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder().let { builder ->
                    getHeaders()?.let {
                        builder.headers(it)
                    }
                    builder
                }.method(original.method(), original.body())
                    .build()

                chain.proceed(request)
            }
        builder.build()
    }

    val newClient: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder().let { builder ->
                        getHeaders()?.let {
                            builder.headers(it)
                        }
                        builder
                    }.method(original.method(), original.body())
                        .build()

                    chain.proceed(request)
                }
            return builder.build()
        }
}