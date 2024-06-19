package com.company.app.member.infrastructure.persistence.jpa

import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDate
import javax.persistence.*

@DynamicUpdate
@Table(name = "emplshop")
@Entity
class MemberJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var seq: Long? = null,

    @Column(name = "shopno", nullable = false, length = 10)
    private val shopNo: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empno", nullable = false)
    private val user: User? = null,

    private val kind: EmployeeKind? = null,

    @Convert(converter = DateStringToLocalDateConverter::class)
    @Column(length = 8)
    private val hireDate: LocalDate? = null,

    @Convert(converter = DateStringToLocalDateConverter::class)
    @Column(length = 8)
    private val retireDate: LocalDate? = null,

    @Column(length = 20)
    private val grade: String? = null,
    
    // 정렬을 위한 필드
    private const val rank: Int = 0,

    @Column(length = 10)
    private val color: String? = null,

    @Column(name = "incenminsale")
    private val minimumSaleForIncentive: Int = 0,

    @ColumnDefault("''")
    @Column(length = 50)
    private val naverItemId: String = "",

    @Convert(converter = YesNoStringBooleanConverter::class)
    @Column(name = "navermappingyn")
    private val isNaverMapping: Boolean? = null,

    private val fcm: String? = null,

    @Convert(converter = EmployeeShopPushConfigConverter::class)
    @Column(name = "pushset", length = 6)
    private val pushConfig: EmployeeShopPushConfig? = null,

    @Column(length = 10)
    private val state: EmployeeState? = null,

    @Convert(converter = YesNoStringBooleanConverter::class)
    @Column(name = "b2cMappingYn")
    private val isB2cMapping: Boolean? = null,

    private val b2cEmployeeId: Long? = null,

    @Column(length = 1024)
    private val b2cChatToken: String? = null
) {
}