package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.xtext.gradle.idea.tasks.AssembleSandboxTask
import org.xtext.gradle.idea.tasks.IdeaExtension

import static extension org.xtext.gradle.idea.tasks.GradleExtensions.*

class IdeaPluginPlugin implements Plugin<Project> {
	override apply(Project project) {
		project.pluginManager.apply(IdeaDevelopmentPlugin)
		val idea = project.extensions.getByType(IdeaExtension)
		val assembleSandboxTask = project.tasks.create("assembleSandbox", AssembleSandboxTask)
		val mainSourceSet = project.convention.getPlugin(JavaPluginConvention).sourceSets.getByName("main")
		assembleSandboxTask.classes.from(mainSourceSet.output)
		val providedDependencies = project.configurations.getAt("ideaProvided")
		val runtimeDependencies = project.configurations.getAt("runtime")
		assembleSandboxTask.libraries.from(runtimeDependencies.minus(providedDependencies))
		assembleSandboxTask.metaInf.from("META-INF")
		project.afterEvaluate [
			assembleSandboxTask.destinationDir = project.file(idea.sandboxDir) / project.name
		]
	}
}