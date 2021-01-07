plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
}

group = "my.artfultom.vecenta.tools"
version = "0.0.1"

tasks.withType<Wrapper> {
    gradleVersion = "6.7.1"
}

gradlePlugin {
    val plugin by plugins.creating {
        id = "vecenta-plugin"
        implementationClass = "my.artfultom.vecenta.tools.VecentaPlugin"
    }
}