plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "1.0.0"
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
}

group = "io.github.artfultom.vecenta.tools"
version = "0.0.7"

tasks.withType<Wrapper> {
    gradleVersion = "7.1"
}

gradlePlugin {
    val plugin by plugins.creating {
        id = "io.github.artfultom.vecenta.tools.vecenta-gradle-plugin"
        implementationClass = "io.github.artfultom.vecenta.tools.VecentaPlugin"
        displayName = "Vecenta"
        description = "RPC Framework"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api("io.github.artfultom:vecenta:0.0.7")
}

pluginBundle {
    website = "https://github.com/artfultom/vecenta"
    vcsUrl = "https://github.com/artfultom/vecenta.git"
    tags = listOf("java", "rpc", "vecenta", "plugins")
}