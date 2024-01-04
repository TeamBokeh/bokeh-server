package com.waterfogsw.glucose.user.infrastructure.client.adapter.strategy

import com.waterfogsw.glucose.user.domain.vo.Email
import com.waterfogsw.glucose.user.domain.vo.URL

interface OidcStrategy {

    fun getToken(authorizationCode: String): String

    fun getTokenInfo(idToken: String): IdTokenInfo

    data class IdTokenInfo(
        val sub: String,
        val name: String,
        val email: Email,
        val picture: URL,
    )
}
