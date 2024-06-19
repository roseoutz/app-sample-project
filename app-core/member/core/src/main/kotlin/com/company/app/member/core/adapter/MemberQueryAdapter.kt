package com.company.app.member.core.adapter

import com.company.app.member.core.MemberQueryPort
import com.company.app.member.core.data.MemberInfo
import com.company.app.member.core.port.MemberReader
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Component
open class MemberQueryAdapter(
    private val memberReader: MemberReader
): MemberQueryPort {

    override fun findById(id: Long): MemberInfo {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): MemberInfo {
        TODO("Not yet implemented")
    }

    override fun findByShopId(shopId: String): List<MemberInfo> {
        TODO("Not yet implemented")
    }
}