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

    implementation("org.myddd.vertx:myddd-vertx-base-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-ioc-guice:${rootProject.extra["myddd_vertx_version"]}")

    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")
    implementation("io.vertx:vertx-hazelcast:${rootProject.extra["vertx_version"]}")
    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")

}
