package my.artfultom.vecenta.tools

import my.artfultom.vecenta.generate.Configuration
import my.artfultom.vecenta.generate.DefaultCodeGenerateStrategy
import my.artfultom.vecenta.generate.FileGenerator
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
    var serverPackage: String? = null

    @Input
    var clientPackage: String? = null

    @TaskAction
    fun generate() {
        val strategy = DefaultCodeGenerateStrategy()
        val config = Configuration(
                Paths.get(schemaDir.toString()),
                Paths.get(targetDir.toString()),
                serverPackage,
                clientPackage
        )
        FileGenerator(strategy).generateFiles(config)
    }
}