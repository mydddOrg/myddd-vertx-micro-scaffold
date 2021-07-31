plugins {
    java
    application
    kotlin("jvm")
}

group = "org.myddd.vertx.micro"
version = rootProject.extra["version"]!!

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))

    api("io.vertx:vertx-core:${rootProject.extra["vertx_version"]}")
    api("io.vertx:vertx-lang-kotlin-coroutines:${rootProject.extra["vertx_version"]}")

    implementation("io.vertx:vertx-web-client:${rootProject.extra["vertx_version"]}")

    implementation(project(":micro-rest:rest-build-strategy-api"))
    implementation(project(":distributed-id:distributed-id-api"))
    implementation(project(":document:document-api"))

    api("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-grpc-provider:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.myddd.vertx:myddd-vertx-base-provider:${rootProject.extra["myddd_vertx_version"]}")

    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")

    implementation("io.vertx:vertx-grpc:${rootProject.extra["vertx_version"]}")
    implementation("javax.annotation:javax.annotation-api:${rootProject.extra["annotation-api"]}")
    implementation("com.google.protobuf:protobuf-java:${rootProject.extra["protobuf-java"]}")
    implementation("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")


    implementation("io.vertx:vertx-json-schema:${rootProject.extra["vertx_version"]}")
    implementation("org.apache.logging.log4j:log4j-core:${rootProject.extra["log4j_version"]}")
    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")
}
