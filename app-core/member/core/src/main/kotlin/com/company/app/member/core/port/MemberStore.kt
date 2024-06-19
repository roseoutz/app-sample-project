package com.company.app.member.core.port

import com.company.app.member.core.data.MemberInfo

interface MemberStore {

    fun findById(id: Long): MemberInfo
}