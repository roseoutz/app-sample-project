plugins {
    kotlin("jvm")
}

group = "com.company.app"
version = "1.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
