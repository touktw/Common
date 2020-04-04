package io.teokim.common.network

/**
 * Created by tae.kim on 2020/04/04.
 */


class TestService : BaseService<TestHttpClient, TestApi>(
    "https://www,google.com",
    TestHttpClient(),
    TestApi::class.java
)