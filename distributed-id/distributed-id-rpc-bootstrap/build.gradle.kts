plugins {
    java
    application
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "org.myddd.vertx.distributed"
version = rootProject.extra["version"]!!

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

val mainVerticleName = "org.myddd.vertx.distributed.bootstrap.MyBootstrapVerticle"
val launcherClassName = "io.vertx.core.Launcher"

application {
    mainClassName = launcherClassName
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("fat")
    manifest {
        attributes(mapOf("Main-Verticle" to mainVerticleName))
    }
    mergeServiceFiles()
}


dependencies {
    implementation(kotlin("stdlib"))

    api("io.vertx:vertx-core:${rootProject.extra["vertx_version"]}")
    api("io.vertx:vertx-lang-kotlin-coroutines:${rootProject.extra["vertx_version"]}")
    implementation("io.vertx:vertx-web-client:${rootProject.extra["vertx_version"]}")
    implementation("io.vertx:vertx-hazelcast:${rootProject.extra["vertx_version"]}")

    implementation("org.myddd.vertx:myddd-vertx-web:${rootProject.extra["myddd_vertx_version"]}")
    implementation("io.vertx:vertx-hazelcast:${rootProject.extra["vertx_version"]}")

    implementation(project(":distributed-id:distributed-id-domain"))
    implementation(project(":distributed-id:distributed-id-api"))
    implementation(project(":distributed-id:distributed-id-application"))
    implementation(project(":distributed-id:distributed-id-infra"))
 
    api("org.myddd.vertx:myddd-vertx-base-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-ioc-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-i18n-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-cache-api:${rootProject.extra["myddd_vertx_version"]}")
    api("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")

    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("io.vertx:vertx-mysql-client:${rootProject.extra["vertx_version"]}")

    implementation("org.myddd.vertx:myddd-vertx-i18n-provider:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.myddd.vertx:myddd-vertx-base-provider:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.myddd.vertx:myddd-vertx-cache-sharedata:${rootProject.extra["myddd_vertx_version"]}")
    implementation("org.myddd.vertx:myddd-vertx-grpc-provider:${rootProject.extra["myddd_vertx_version"]}")

    implementation("io.vertx:vertx-grpc:${rootProject.extra["vertx_version"]}")
    implementation("javax.annotation:javax.annotation-api:${rootProject.extra["annotation-api"]}")
    implementation("com.google.protobuf:protobuf-java:${rootProject.extra["protobuf-java"]}")
    implementation("org.myddd.vertx:myddd-vertx-grpc-api:${rootProject.extra["myddd_vertx_version"]}")


    implementation("io.vertx:vertx-json-schema:${rootProject.extra["vertx_version"]}")
    implementation("org.apache.logging.log4j:log4j-core:${rootProject.extra["log4j_version"]}")

    testImplementation("io.vertx:vertx-junit5:${rootProject.extra["vertx_version"]}")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:${rootProject.extra["jackson_version"]}")
}
