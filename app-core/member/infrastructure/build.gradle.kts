plugins {
    kotlin("jvm")
}

group = "com.company.app"
version = "1.0.0"

dependencies {
    implementation(project(":app-common:common"))
    implementation(project(":app-common:jpa-common"))
    implementation(project(":app-core:member:core"))
    implementation(project(":app-supports:logging"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
