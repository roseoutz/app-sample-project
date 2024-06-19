plugins {
    kotlin("jvm")
    kotlin("plugin.spring") apply false
    kotlin("plugin.jpa") apply false
    kotlin("plugin.serialization") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
}

val projectGroup: String by project
val applicationVersion: String by project

val springBootVersion: String by project
val springDependencyManagementVersion: String by project
val springCloudDependenciesVersion: String by project

val postgresqlVersion: String by project
val mysqlConnectorVersion: String by project
val mockkVersion: String by project
val sentryVersion: String by project
val ktorVersion: String by project


allprojects {
    group = projectGroup
    version = applicationVersion

    repositories {
        mavenCentral()
        google()
    }

    // encoding
    tasks.withType<Javadoc> {
        options.encoding = "UTF-8"
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    // clean task 실행시 QClass 삭제
    tasks.register("DeleteQClass") {
        dependsOn("clean")
        delete {
            // 인텔리제이 Annotation processor 생성물 생성 위치
            delete("path/to/files/*")
        }
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "jacoco")

    configure<JacocoPluginExtension> {
        toolVersion = "0.8.8"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        finalizedBy("jacocoTestReport")
    }

    tasks.withType<JacocoReport> {
        dependsOn("test")
        reports {
            html.required.set(true)
            xml.required.set(true)
            csv.required.set(true)
            xml.outputLocation.set(file("${layout.buildDirectory}/reports/jacoco.xml"))
            html.outputLocation.set(file("${layout.buildDirectory}/reports/jacoco.html"))
        }
        val excludes = mutableListOf<String>()
        excludes.add("**/*Application*")
        excludes.add("**/*Config*")
        excludes.add("**/*Dto*")
        excludes.add("**/*Request*")
        excludes.add("**/*Response*")
        excludes.add("**/*Interceptor*")
        excludes.add("**/*Exception*")
        ('A'..'Z').mapTo(excludes) { "**/Q$it*" }
        afterEvaluate {
            classDirectories.setFrom(
                files(classDirectories.files.map {
                    fileTree(it) {
                        exclude(excludes)
                    }
                })
            )
        }
    }

    dependencies {
        // JPA, Web 모두 기본으로 주입은 귀찮아서...
        implementation("org.springframework:spring-context") // JPA
        implementation("org.springframework:spring-tx")      // Web

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
        testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

        runtimeOnly("org.springframework.boot:spring-boot-devtools")            // DevTools
        implementation("org.hibernate.validator:hibernate-validator")           // Validator
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

