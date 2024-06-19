package com.company.app.member.core

import com.company.app.member.core.common.MemberType
import com.company.app.member.core.data.MemberPushNotificationConfig

class MemberCommand {

    data class Create(
        val name: String,
        val email: String,
        val password: String,
        val memberType: MemberType,
        val memberPushNotificationConfig: MemberPushNotificationConfig
    )

    data class UpdatePushNotificationConfig(
        val memberId: Long,
        val isNotifyBooking: Boolean,
        val isNotifyNaverBooking: Boolean,
        val isNotifySaleNotRegistration: Boolean,
    )
}