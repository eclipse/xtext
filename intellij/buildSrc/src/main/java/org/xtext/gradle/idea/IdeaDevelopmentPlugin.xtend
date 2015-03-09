package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.plugins.ide.eclipse.model.Classpath
import org.gradle.plugins.ide.eclipse.model.EclipseModel
import org.gradle.plugins.ide.eclipse.model.Library
import org.gradle.plugins.ide.eclipse.model.internal.FileReferenceFactory
import org.xtext.gradle.idea.tasks.IdeaDownloadTask
import org.xtext.gradle.idea.tasks.IdeaExtension

import static extension org.xtext.gradle.idea.tasks.GradleExtensions.*

class IdeaDevelopmentPlugin implements Plugin<Project> {

	override apply(Project project) {
		project.pluginManager.apply(JavaPlugin)
		val idea = project.extensions.create("ideaDevelopment", IdeaExtension) => [
			ideaHome = project.rootDir / "ideaHome"
			ideaVersion = "140.2683.2"
			sandboxDir = project.rootProject.buildDir / "ideaSandbox"
		]
		val ideaProvided = project.configurations.create("ideaProvided")
		val downloadTask = project.tasks.create("downloadIdea", IdeaDownloadTask)
		project.afterEvaluate [
			downloadTask.ideaHome = idea.ideaHome
			downloadTask.ideaVersion = idea.ideaVersion
			val ideaHomeDir = downloadTask.ideaHomeDir
			val ideaLibs = project.fileTree(ideaHomeDir + "/lib").builtBy(downloadTask).include("*.jar")
			project.dependencies.add(ideaProvided.name, ideaLibs)
			project.convention.getPlugin(JavaPluginConvention).sourceSets.forEach [
				compileClasspath = compileClasspath.plus(ideaProvided)
			]
			project.pluginManager.withPlugin("eclipse") [
				project.extensions.getByType(EclipseModel).classpath => [
					val fileReferenceFactory = new FileReferenceFactory
					plusConfigurations.add(ideaProvided)
					file.whenMerged.add[Classpath it|
						val sourceZip = ideaHomeDir / "sources.zip"
						entries.filter(Library)
							.filter[library.file.parentFile == ideaHomeDir / 'lib']
							.forEach[sourcePath = fileReferenceFactory.fromFile(sourceZip)]
					]
				]
			]
		]
	}
}