package io.teokim.demo.demo.net

import io.teokim.common.network.BaseResponse
import io.teokim.demo.demo.model.ArtistDto

/**
 * Created by tae.kim on 2020/04/04.
 */

data class ArtistResponse(
    val description: String?,
    val data: List<ArtistDto>
) : BaseResponse