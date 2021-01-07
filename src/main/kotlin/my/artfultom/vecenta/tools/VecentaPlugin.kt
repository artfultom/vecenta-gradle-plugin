package my.artfultom.vecenta.tools

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

class VecentaPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("generate", Generate::class.java)
    }
}

open class Generate : DefaultTask() {

    @TaskAction
    fun generate() {
        TODO("Not yet implemented")
    }
}