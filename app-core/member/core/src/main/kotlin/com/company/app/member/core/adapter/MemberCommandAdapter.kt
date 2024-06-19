package com.company.app.member.core.adapter

import com.company.app.member.core.MemberCommandPort
import com.company.app.member.core.MemberCommand
import com.company.app.member.core.port.MemberStore
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
open class MemberCommandAdapter(
    private val memberStore: MemberStore
): MemberCommandPort {
    override fun create(create: MemberCommand.Create) {
        TODO("Not yet implemented")
    }

    override fun updatePushNotificationConfig(update: MemberCommand.UpdatePushNotificationConfig) {
        TODO("Not yet implemented")
    }
}