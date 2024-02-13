plugins {
    application
    id("java")
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("Main") }

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_20
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}