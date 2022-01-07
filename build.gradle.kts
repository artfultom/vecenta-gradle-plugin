plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
}

group = "my.artfultom.vecenta.tools"
version = "0.0.1-test4"

tasks.withType<Wrapper> {
    gradleVersion = "6.7.1"
}

gradlePlugin {
    val plugin by plugins.creating {
        id = "vecenta-plugin"
        implementationClass = "my.artfultom.vecenta.tools.VecentaPlugin"
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("com.github.artfultom:vecenta:0.0.1")
}

publishing {
    publications {
        create<MavenPublication>("vecenta-plugin") {
            from(components["kotlin"])
        }
    }
    repositories {
        mavenLocal()
    }
}