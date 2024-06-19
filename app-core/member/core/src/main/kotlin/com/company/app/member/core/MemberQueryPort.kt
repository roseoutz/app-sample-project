package com.company.app.member.core

import com.company.app.member.core.data.MemberInfo

interface MemberQueryPort {

    fun findById(id: Long): MemberInfo

    fun findByEmail(email: String): MemberInfo

    fun findByShopId(shopId: String): List<MemberInfo>

}