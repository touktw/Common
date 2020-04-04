package io.teokim.common.network

import okhttp3.Headers

/**
 * Created by tae.kim on 2020/04/04.
 */

class TestHttpClient : BaseHttpClient() {
    override fun getHeaders(): Headers? {
        return null
    }
}