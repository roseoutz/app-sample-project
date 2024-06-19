package com.company.app.member.infrastructure.persistence.jpa;

import com.nail.crm.v2.domain.common.BaseEntity;
import com.nail.crm.v2.domain.common.ormconverter.DatetimeStringToLocalDateTimeConverter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;

import static com.nail.crm.v2.domain.user.User.UNIQUE_COLUMN_ID;
import static com.nail.crm.v2.domain.user.User.UNIQUE_INDEX_ID;

@DynamicUpdate
@Table(name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = User.UNIQUE_INDEX_HPNO, columnNames = User.UNIQUE_COLUMN_HPNO),
                @UniqueConstraint(name = UNIQUE_INDEX_ID, columnNames = UNIQUE_COLUMN_ID),
        })
@Entity
public class UserJpaEntity extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private Long empNo;

    @Column(length = 50, nullable = false, unique = true)
    private String id;

    @Column(name = "pwd", length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "hpno", length = 20, nullable = false, unique = true)
    private String mobilePhoneNumber;

    @Column(name = "registration_status", nullable = false)
    private UserRegistrationStatus state;

    @Column(length = 50)
    private String email;

    @Column(name = "recommendid", length = 50)
    private String recommendId;

    /**
     * 의견남김기 팝업 표시기한, 사용 안하는 것 같음
     * TODO: 사용 용도 확인
     */
    @Column(length = 8)
    private String popdue;

    @Column(length = 1024)
    private String token;

    @Column(length = 255)
    private String fcm;

    @Column(name = "android_device_id", length = 30)
    private String androidDeviceId;

    @Convert(converter = DatetimeStringToLocalDateTimeConverter.class)
    @Column(name = "lastlogin", length = 14)
    private LocalDateTime lastLoginAt;

    public UserJpaEntity(final String id, final String password, final String name, final String mobilePhoneNumber) {
        Objects.requireNonNull(id, "id is required");
        Objects.requireNonNull(password, "password is required");
        Objects.requireNonNull(name, "name is required");
        Objects.requireNonNull(mobilePhoneNumber, "mobilePhoneNumber is required");
        this.id = id;
        this.password = password;
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.state = UserRegistrationStatus.REGISTERED;
    }

    protected UserJpaEntity() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        final User user = (User) o;
        return Objects.equals(empNo, user.empNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo);
    }

    public void updateToken(final String token) {
        this.token = token;
    }

    public void registerRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public void deleteUser() {
        this.state = UserRegistrationStatus.DELETED; // 상태를 삭제로 변경
        this.id = nameAddOne(); // id 음절마다 +1 추가
        this.mobilePhoneNumber = this.mobilePhoneNumber + "999"; // 연락처에 +999 추가
    }

    private String nameAddOne() {
        String[] strArr = this.id.split(""); // 값을 쪼갠다
        StringBuilder newUserId = new StringBuilder();
        for (String s : strArr) {
            newUserId.append("1").append(s); // 이름의 모든 음절에 1을 붙임
        }
        return newUserId.toString();
    }

    public void updateAndroidDeviceId(String androidDeviceId) {
        this.androidDeviceId = androidDeviceId;
    }

    public void deleteAndroidDeviceId() {
        if (this.androidDeviceId == null) {
            return;
        }

        this.androidDeviceId = null;
    }

    public Long getEmpNo() {
        return this.empNo;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getMobilePhoneNumber() {
        return this.mobilePhoneNumber;
    }

    public UserRegistrationStatus getState() {
        return this.state;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public String getPopdue() {
        return this.popdue;
    }

    public String getToken() {
        return this.token;
    }

    public String getFcm() {
        return this.fcm;
    }

    public String getAndroidDeviceId() {
        return this.androidDeviceId;
    }

    public LocalDateTime getLastLoginAt() {
        return this.lastLoginAt;
    }

    public boolean isInvalidRecommendId() {
        return this.recommendId.isBlank() || this.id.equals(this.recommendId);
    }

    public static class UserBuilder {
        private String id;
        private String password;
        private String name;
        private String mobilePhoneNumber;

        UserBuilder() {
        }

        public UserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder mobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public User build() {
            return new User(this.id, this.password, this.name, this.mobilePhoneNumber);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", password=" + this.password + ", name=" + this.name
                    + ", mobilePhoneNumber=" + this.mobilePhoneNumber + ")";
        }
    }
}
