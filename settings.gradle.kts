rootProject.name = "app-sample-project"

pluginManagement {
    // gradle.properties 에서 가져온다
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val liquibaseVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.serialization" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.liquibase.gradle" -> useVersion(liquibaseVersion)
            }
        }
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
include(":app:admin-api")
include(":app:b2b-api")
include(":app:b2c-api")
include(":app:instagram-crawler-batch")
include(":app:notification-batch")
include(":app:notification-worker")

include(":app-common:common")

include(":app-core:booking:core")
include(":app-core:booking:infrastructure")

include(":app-core:member:core")
include(":app-core:member:infrastructure")

include(":app-core:shop:core")
include(":app-core:shop:infrastructure")

include(":app-core:payment:core")
include(":app-core:payment:infrastructure")

include(":app-core:notification:core")
include(":app-core:notification:infrastructure")

include(":app-supports:logging")
include(":app-supports:metric")