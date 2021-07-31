plugins {
    java
    kotlin("jvm")
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