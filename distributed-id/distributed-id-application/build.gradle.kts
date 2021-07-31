import kotlin.collections.*

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

    implementation("io.vertx:vertx-web-client:${rootProject.extra["vertx_version"]}")

    api(project(":distributed-id:distributed-id-api"))
    implementation(project(":distributed-id:distributed-id-domain"))
    api("org.myddd.vertx:myddd-vertx-querychannel-api:${rootProject.extra["myddd_vertx_version"]}")

    //依赖注入
    implementation("org.myddd.vertx:myddd-vertx-ioc-api:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.myddd.vertx:myddd-vertx-cache-api:${rootProject.extra["myddd_vertx_version"]}")
    //依赖注入实现（仅测试下）
    testImplementation(project(":distributed-id:distributed-id-infra"))
    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")
    testImplementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")

    testImplementation("org.myddd.vertx:myddd-vertx-cache-sharedata:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("org.myddd.vertx:myddd-vertx-ioc-guice:${rootProject.extra["myddd_vertx_version"]}")
    testImplementation("org.myddd.vertx:myddd-vertx-querychannel-hibernate:${rootProject.extra["myddd_vertx_version"]}")
}
