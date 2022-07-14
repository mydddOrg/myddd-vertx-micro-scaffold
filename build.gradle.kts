import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
buildscript {

    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.19")
    }
}

plugins {
    java
    kotlin("jvm") version "1.6.0"
}

group = "com.foreverht.codebee.model"
version = "1.0.0-SNAPSHOT"
extra["myddd_vertx_version"] = "0.3.5-SNAPSHOT"

extra["vertx_version"] = "4.3.1"
extra["version"] = version

extra["kotlin_version"] = "1.6.0"
extra["log4j_version"] = "2.14.0"
extra["jackson_version"] = "2.12.5"
extra["javax_persistence_version"] = "2.2.1"
extra["mockito_version"] = "3.7.7"
extra["junit5_version"] = "5.8.2s"

extra["hibernate_reactive_version"] = "1.1.7.Final"

extra["protobuf-java"] = "3.17.3"
extra["annotation-api"] = "1.3.2"
extra["protoc-gen-version"] = "1.47.0"


allprojects {

    // don't cache changing modules at all
    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }

    repositories {

        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/spring/")
        }

        mavenCentral()

        maven {
            setUrl("https://maven.myddd.org/releases/")
        }
        maven {
            setUrl("https://maven.myddd.org/snapshots/")
        }


        maven {
            setUrl("https://jitpack.io")
        }


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

subprojects {

    apply(plugin = "java")

    dependencies{
        implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
        implementation("io.vertx:vertx-core:${rootProject.extra["vertx_version"]}")
        implementation("io.vertx:vertx-lang-kotlin:${rootProject.extra["vertx_version"]}")
        implementation("io.vertx:vertx-lang-kotlin-coroutines:${rootProject.extra["vertx_version"]}")
        implementation("org.myddd.vertx:myddd-vertx-ioc-api:${rootProject.extra["myddd_vertx_version"]}")

        testImplementation("org.myddd.vertx:myddd-vertx-ioc-guice:${rootProject.extra["myddd_vertx_version"]}")
        testImplementation("org.myddd.vertx:myddd-vertx-base-provider:${rootProject.extra["myddd_vertx_version"]}")
        testImplementation("org.myddd.vertx:myddd-vertx-junit:${rootProject.extra["myddd_vertx_version"]}")
        testImplementation("org.apache.logging.log4j:log4j-core:${rootProject.extra["log4j_version"]}")

        testImplementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")

    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}