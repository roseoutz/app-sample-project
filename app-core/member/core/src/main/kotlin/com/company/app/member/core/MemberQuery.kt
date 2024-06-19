package com.company.app.member.core

class MemberQuery {

    data class Member(
        val id: Long,
        val name: String,
        val email: String
    )
}