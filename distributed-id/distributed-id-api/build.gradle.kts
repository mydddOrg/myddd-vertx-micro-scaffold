import com.google.protobuf.gradle.*

plugins {
    java
    kotlin("jvm")
    id("com.google.protobuf")
    id("idea")
}

group = "org.myddd.vertx.distributed"
version = rootProject.extra["version"]!!

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))

    api("io.vertx:vertx-core:${rootProject.extra["vertx_version"]}")
    api("io.vertx:vertx-lang-kotlin:${rootProject.extra["vertx_version"]}")
    api("io.vertx:vertx-lang-kotlin-coroutines:${rootProject.extra["vertx_version"]}")

    api("io.vertx:vertx-grpc:${rootProject.extra["vertx_version"]}")
    api("javax.annotation:javax.annotation-api:${rootProject.extra["annotation-api"]}")
    api("com.google.protobuf:protobuf-java:${rootProject.extra["protobuf-java"]}")

    implementation("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")

    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")
}


sourceSets.main {
    proto.srcDir("src/main/protobuf")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${rootProject.extra["protobuf-java"]}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.39.0"
        }

        id("vertx") {
            artifact = "io.vertx:vertx-grpc-protoc-plugin:${rootProject.extra["vertx_version"]}"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
                id("vertx")
            }
        }
    }
}