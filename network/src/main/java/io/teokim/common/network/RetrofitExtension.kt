package io.teokim.common.network

import retrofit2.Response

/**
 * Created by tae.kim on 2020/04/04.
 */


fun <R : BaseResponse> Response<R>.getResult(): ApiResult<R> {
    var response: R? = null
    var code: Int
    when {
        isSuccessful -> {
            response = body()
            code =
                if (response != null) ApiResult.SUCCESS
                else ApiResult.ERROR_NO_BODY
        }
        else -> {
            code = code()
        }
    }

    return ApiResult(code, response, message())
}