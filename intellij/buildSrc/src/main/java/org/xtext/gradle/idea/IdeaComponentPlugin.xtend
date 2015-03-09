package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.plugins.ide.eclipse.model.Classpath
import org.gradle.plugins.ide.eclipse.model.EclipseModel
import org.gradle.plugins.ide.eclipse.model.Library
import org.gradle.plugins.ide.eclipse.model.internal.FileReferenceFactory
import org.xtext.gradle.idea.tasks.DownloadIdea

import static extension org.xtext.gradle.idea.tasks.GradleExtensions.*

class IdeaComponentPlugin implements Plugin<Project> {

	override apply(Project project) {
		project.pluginManager.apply(IdeaDevelopmentPlugin)
		project.pluginManager.apply(JavaPlugin)
		
		val compile = project.configurations.getAt("compile")
		compile.exclude(#{"module" -> "guava"})
		compile.exclude(#{"module" -> "log4j"})

		val ideaProvided = project.configurations.create("ideaProvided")
		
		project.afterEvaluate [
			val downloadTask = project.tasks.getByName("downloadIdea") as DownloadIdea
			val ideaHomeDir = downloadTask.ideaHomeDir

			val ideaLibs = project.fileTree(ideaHomeDir + "/lib").builtBy(downloadTask).include("*.jar")
			project.dependencies.add(ideaProvided.name, ideaLibs)
			project.convention.getPlugin(JavaPluginConvention).sourceSets.forEach [
				compileClasspath = compileClasspath.plus(ideaProvided)
			]
			
			project.pluginManager.withPlugin("eclipse") [
				project.extensions.getByType(EclipseModel).classpath => [
					plusConfigurations.add(ideaProvided)
					
					val fileReferenceFactory = new FileReferenceFactory
					file.whenMerged.add [ Classpath it |
						val sourceZip = ideaHomeDir / "sources.zip"
						entries.filter(Library).filter[library.file.parentFile == ideaHomeDir / 'lib'].forEach [
							sourcePath = fileReferenceFactory.fromFile(sourceZip)
						]
					]
				]
			]
		]
	}

}