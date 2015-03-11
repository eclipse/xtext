package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.xtext.gradle.idea.tasks.AssembleSandbox
import org.xtext.gradle.idea.tasks.IdeaExtension
import org.xtext.gradle.idea.tasks.IdeaZip

import static extension org.xtext.gradle.idea.tasks.GradleExtensions.*
import org.gradle.api.Action
import org.xtext.gradle.idea.tasks.IdeaPluginSpec

class IdeaPluginPlugin implements Plugin<Project> {
	override apply(Project project) {
		project.pluginManager.apply(IdeaComponentPlugin)
		val idea = project.extensions.getByType(IdeaExtension)
		val mainSourceSet = project.convention.getPlugin(JavaPluginConvention).sourceSets.getByName("main")
		val providedDependencies = project.configurations.getAt("ideaProvided")
		val runtimeDependencies = project.configurations.getAt("runtime")
		
		val Action<? super IdeaPluginSpec> archiveConfig = [
			classes.from(mainSourceSet.output)
			libraries.from(runtimeDependencies.minus(providedDependencies))
			metaInf.from("META-INF")
		]

		project.tasks.create("ideaZip", IdeaZip, archiveConfig)

		val assembleSandboxTask = project.tasks.create("assembleSandbox", AssembleSandbox, archiveConfig)

		project.afterEvaluate [
			assembleSandboxTask.destinationDir = project.file(idea.sandboxDir) / project.name
		]
	}
}