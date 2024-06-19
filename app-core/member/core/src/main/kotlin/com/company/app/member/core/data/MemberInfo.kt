package com.company.app.member.core.data

import com.company.app.member.core.common.MemberType

data class MemberInfo (
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val shopId: String,
    val memberType: MemberType,
    val memberPushNotificationConfig: MemberPushNotificationConfig = MemberPushNotificationConfig.defaultConfig(),
    val createdAt: Long,
    val updatedAt: Long
)