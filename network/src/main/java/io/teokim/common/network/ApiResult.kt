package io.teokim.common.network

/**
 * Created by tae.kim on 2020/04/04.
 */

data class ApiResult<R : BaseResponse>(
    val resultCode: Int,
    val response: R?,
    val message: String
) {
    companion object {
        const val SUCCESS = 1000
        const val ERROR_NO_BODY = 9001
    }
}