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
    //base
    implementation(kotlin("stdlib"))
    //other layer
    implementation(project(":document:document-domain"))

    implementation(project(":distributed-id:distributed-id-api"))

    //api
    api("org.myddd.vertx:myddd-vertx-ioc-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-repository-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-repository-hibernate:${rootProject.extra["myddd_vertx_version"]}")

    api("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")

    //api implementation
    api("org.hibernate.reactive:hibernate-reactive-core:${rootProject.extra["hibernate_reactive_version"]}")
    api("org.myddd.vertx:myddd-vertx-base-provider:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.apache.logging.log4j:log4j-core:${rootProject.extra["log4j_version"]}")

    implementation("com.fasterxml.jackson.core:jackson-databind:${rootProject.extra["jackson_version"]}")
    implementation("com.fasterxml.jackson.core:jackson-annotations:${rootProject.extra["jackson_version"]}")

    //test
    testImplementation("org.myddd.vertx:myddd-vertx-ioc-guice:${rootProject.extra["myddd_vertx_version"]}")

    testImplementation("org.myddd.vertx:myddd-vertx-grpc-provider:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation(project(":distributed-id:distributed-id-application"))

}
