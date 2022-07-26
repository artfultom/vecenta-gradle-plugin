plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
}

group = "io.github.artfultom.vecenta.tools"
version = "0.0.5" + if (project.hasProperty("snapshot")) "-SNAPSHOT" else ""

tasks.withType<Wrapper> {
    gradleVersion = "7.1"
}

gradlePlugin {
    val plugin by plugins.creating {
        id = "vecenta-plugin"
        implementationClass = "io.github.artfultom.vecenta.tools.VecentaPlugin"
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/artfultom/vecenta/")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    api("io.github.artfultom:vecenta:0.0.5")
}

publishing {
    publications {
        create<MavenPublication>("vecenta-plugin") {
            from(components["kotlin"])
        }
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/artfultom/vecenta-gradle-plugin/")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}