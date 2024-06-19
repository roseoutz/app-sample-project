plugins {
    kotlin("jvm")
}

group = "com.company.app"
version = "1.0.0"

dependencies {
    implementation(project(":app-common:common"))
    implementation(project(":app-core:payment:core"))
    implementation(project(":app-supports:logging"))

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
