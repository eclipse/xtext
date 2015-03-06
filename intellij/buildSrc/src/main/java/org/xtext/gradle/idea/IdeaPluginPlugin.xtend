package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.plugins.ide.eclipse.model.EclipseModel
import org.xtext.gradle.idea.tasks.IdeaDownloadTask
import org.xtext.gradle.idea.tasks.IdeaExtension

class IdeaPluginPlugin implements Plugin<Project> {

	override apply(Project project) {
		project.pluginManager.apply(JavaPlugin)
		val idea = project.extensions.create("xtextIdea", IdeaExtension)
		val ideaProvided = project.configurations.create("ideaProvided")
		val downloadTask = project.tasks.create("downloadIdea", IdeaDownloadTask)
		project.afterEvaluate [
			downloadTask.ideaHome = idea.ideaHome
			downloadTask.ideaVersion = idea.ideaVersion
			val ideaLibs = project.fileTree(downloadTask.ideaHomeDir + "/lib").builtBy(downloadTask)
			project.dependencies.add(ideaProvided.name, ideaLibs)
			project.convention.getPlugin(JavaPluginConvention).sourceSets.forEach [
				compileClasspath = compileClasspath.plus(ideaProvided)
			]
			project.pluginManager.withPlugin("eclipse") [
				project.extensions.getByType(EclipseModel).classpath.plusConfigurations.add(ideaProvided)
			]
		]
	}
}