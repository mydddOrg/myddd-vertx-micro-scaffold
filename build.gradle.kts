import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
buildscript {

    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.17")
    }
}

plugins {
    java
    kotlin("jvm") version "1.5.21"
}

group = "com.foreverht.codebee.model"
version = "1.0.0-SNAPSHOT"
extra["myddd_vertx_version"] = "1.2.0-SNAPSHOT"

extra["vertx_version"] = "4.1.1"
extra["version"] = version

extra["log4j_version"] = "2.14.0"
extra["jackson_version"] = "2.12.1"
extra["javax_persistence_version"] = "2.2.1"
extra["mockito_version"] = "3.7.7"
extra["junit5_version"] = "5.7.1"

extra["hibernate_reactive_version"] = "1.0.0.CR8"

extra["protobuf-java"] = "3.17.3"
extra["annotation-api"] = "1.3.2"


allprojects {

    // don't cache changing modules at all
    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }

    repositories {
        maven {
            setUrl("https://maven.myddd.org/releases/")
        }
        maven {
            setUrl("https://maven.myddd.org/snapshots/")
        }

        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/spring/")
        }

        mavenCentral()

    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

repositories {
    maven {
        setUrl("https://maven.myddd.org/releases/")
    }
    maven {
        setUrl("https://maven.myddd.org/snapshots/")
    }

    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/spring/")
    }

    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}