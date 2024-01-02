package com.waterfogsw.glucose.user.application.port.stub

import com.waterfogsw.glucose.user.application.port.UserSocialLoginInfoRepository
import com.waterfogsw.glucose.user.domain.entity.Provider
import com.waterfogsw.glucose.user.domain.entity.UserSocialLoginInfo
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class UserSocialLoginInfoRepositorySpy : UserSocialLoginInfoRepository {

    private val userSocialLoginInfoMap: MutableMap<UUID, UserSocialLoginInfo> =
        ConcurrentHashMap<UUID, UserSocialLoginInfo>()

    override fun save(userSocialLoginInfo: UserSocialLoginInfo) {
        userSocialLoginInfoMap[userSocialLoginInfo.id] = userSocialLoginInfo
    }

    override fun findBySubAndProvider(sub: String, provider: Provider): UserSocialLoginInfo? {
        return userSocialLoginInfoMap.values.find { it.sub == sub && it.provider == provider }
    }

    fun existsByUserId(userId: UUID): Boolean {
        return userSocialLoginInfoMap.values.any { it.userId == userId }
    }
}
