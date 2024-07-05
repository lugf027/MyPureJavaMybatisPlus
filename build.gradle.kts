plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "com.demo.me"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.9.0")  // json
    implementation("com.baomidou:mybatis-plus:3.5.6")
    implementation("org.projectlombok:lombok:1.18.22")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("com.googlecode.log4jdbc:log4jdbc:1.2")
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}