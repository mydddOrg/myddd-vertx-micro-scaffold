plugins {
    java
    kotlin("jvm")
}

group = "org.myddd.vertx.document"
version = rootProject.extra["version"]!!

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))

    api("io.vertx:vertx-core:${rootProject.extra["vertx_version"]}")
    api("io.vertx:vertx-lang-kotlin:${rootProject.extra["vertx_version"]}")
    api("io.vertx:vertx-lang-kotlin-coroutines:${rootProject.extra["vertx_version"]}")

    api("org.myddd.vertx:myddd-vertx-domain:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-ioc-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-base-api:${rootProject.extra["myddd_vertx_version"]}")

    implementation(project(":distributed-id:distributed-id-api"))


    implementation("org.myddd.vertx:myddd-vertx-repository-api:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("org.myddd.vertx:myddd-vertx-ioc-guice:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")
    testImplementation(project(":document:document-infra"))
    testImplementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")

    testImplementation(project(":distributed-id:distributed-id-application"))
    testImplementation("org.myddd.vertx:myddd-vertx-grpc-provider:${rootProject.extra["myddd_vertx_version"]}")


}
