import kotlin.collections.*
import com.google.protobuf.gradle.*

plugins {
    java
    kotlin("jvm")
    id("com.google.protobuf")
}

group = "org.myddd.vertx.document"
version = rootProject.extra["version"]!!

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.vertx:vertx-web-client:${rootProject.extra["vertx_version"]}")

    api(project(":document:document-api"))
    implementation(project(":document:document-domain"))
    api("org.myddd.vertx:myddd-vertx-querychannel-api:${rootProject.extra["myddd_vertx_version"]}")

    implementation("com.google.protobuf:protobuf-java:${rootProject.extra["protobuf-java"]}")
    implementation("io.vertx:vertx-grpc:${rootProject.extra["vertx_version"]}")
    implementation("javax.annotation:javax.annotation-api:${rootProject.extra["annotation-api"]}")
    implementation("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")
    implementation("io.vertx:vertx-service-discovery:${rootProject.extra["vertx_version"]}")

    //依赖注入
    implementation("org.myddd.vertx:myddd-vertx-ioc-api:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.myddd.vertx:myddd-vertx-cache-api:${rootProject.extra["myddd_vertx_version"]}")
    //依赖注入实现（仅测试下）
    testImplementation(project(":document:document-infra"))
    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")
    testImplementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")

    testImplementation("org.myddd.vertx:myddd-vertx-cache-sharedata:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("org.myddd.vertx:myddd-vertx-ioc-guice:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("org.myddd.vertx:myddd-vertx-querychannel-hibernate:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("org.myddd.vertx:myddd-vertx-grpc-provider:${rootProject.extra["myddd_vertx_version"]}")

    testImplementation(project(":distributed-id:distributed-id-api"))
    testImplementation(project(":distributed-id:distributed-id-application"))

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
            artifact = "io.grpc:protoc-gen-grpc-java:${rootProject.extra["protoc-gen-version"]}"
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