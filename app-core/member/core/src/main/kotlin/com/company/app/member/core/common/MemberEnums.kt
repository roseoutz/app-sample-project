package com.company.app.member.core.common

enum class MemberType(val value: String, val code: Int) {
    OWNER("점주", 1),
    STAFF("직원", 2),
    OWNER_ENG("owner", 1),
    STAFF_ENG("staff", 2);
}