package com.company.app.member.core.common

import java.util.regex.Pattern

object MemberConstants {
    const val DEFAULT_SHOP_NO: String = "S999999999"
    const val DEFAULT_COLOR: String = "9fa1a4"
    const val NO_CHARGE_EMPLOYEE_NO: Long = 0L
    const val NO_CHARGE_EMPLOYEE_NAME: String = "담당자없음"
    const val EMPLOYMENT_REQUEST_NOTIFICATION_FORMAT: String = "[공비서] %s님이 직원 등록을 요청했습니다."

    const val DEFAULT_ORDER_NUMBER = 1
    const val OWNER_DEFAULT_COLOR = "227eff"
    const val MEMBER_DEFAULT_COLOR = "897bf6"

    const val UNIQUE_INDEX_HPNO: String = "hpno_UNIQUE"
    const val UNIQUE_COLUMN_HPNO: String = "hpno"
    const val UNIQUE_INDEX_ID: String = "id_UNIQUE"
    const val UNIQUE_COLUMN_ID: String = "id"
    const val DELETE_USER_STATE: String = "삭제"

    const val PERMITTED_SPECIAL_CHARACTERS: String = "~ !@#$%^&*()_+/.,₩-=[]{}\\|;'\":<>?※"
    private const val PERMITTED_SPECIAL_CHARACTERS_REGEX = "~ !@#\\$%\\^&*\\(\\)_+/\\.,₩\\-=\\[\\]{}\\\\|;'\":<>?※"

    const val PASSWORD_REGEX: String =
        "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[$PERMITTED_SPECIAL_CHARACTERS_REGEX])[a-zA-Z0-9$PERMITTED_SPECIAL_CHARACTERS_REGEX]{8,20}$"
    val PASSWORD_PATTERN: Pattern = Pattern.compile(PASSWORD_REGEX)
    const val ID_REGEX: String = "^[a-z0-9]{4,20}$"
    val ID_PATTERN: Pattern = Pattern.compile(ID_REGEX)

}