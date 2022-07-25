package io.github.artfultom.vecenta.tools

import io.github.artfultom.vecenta.generation.FileGenerator
import io.github.artfultom.vecenta.generation.config.GenerateConfiguration
import io.github.artfultom.vecenta.generation.config.GenerateMode
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.nio.file.Paths

class VecentaPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("generate", Generate::class.java)
    }
}

open class Generate : DefaultTask() {

    @Input
    var schemaDir: String? = null

    @Input
    var targetDir: String? = null

    @Input
    var modelPackage: String? = null

    @Input
    var exceptionPackage: String? = null

    @Input
    var serverPackage: String? = null

    @Input
    var clientPackage: String? = null

    @TaskAction
    fun generate() {
        var mode = GenerateMode.ALL
        if (serverPackage == null) {
            mode = GenerateMode.CLIENT
        }
        if (clientPackage == null) {
            mode = GenerateMode.SERVER
        }

        val config = GenerateConfiguration(
                Paths.get(schemaDir.toString()),
                Paths.get(targetDir.toString()),
                modelPackage,
                exceptionPackage,
                serverPackage,
                clientPackage,
                mode
        )

        FileGenerator(config).generateFiles()
    }
}