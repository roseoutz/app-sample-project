package com.company.app.member.core.data

data class MemberPushNotificationConfig(
    var isNotifyBooking: Boolean,
    var isNotifyNaverBooking: Boolean,
    var isNotifySaleNotRegistration: Boolean,
) {

    companion object {
        fun defaultConfig(): MemberPushNotificationConfig {
            return MemberPushNotificationConfig(
                isNotifyBooking = false,
                isNotifyNaverBooking = false,
                isNotifySaleNotRegistration = false
            )
        }
    }
}