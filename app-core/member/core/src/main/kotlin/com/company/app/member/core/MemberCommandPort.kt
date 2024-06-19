package com.company.app.member.core

interface MemberCommandPort {

    fun create(create: MemberCommand.Create)

    fun updatePushNotificationConfig(update: MemberCommand.UpdatePushNotificationConfig)
}