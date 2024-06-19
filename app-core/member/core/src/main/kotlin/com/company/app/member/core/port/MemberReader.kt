package com.company.app.member.core.port

import com.company.app.member.core.MemberCommand

interface MemberReader {

    fun save(create: MemberCommand.Create)
}