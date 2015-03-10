package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.os.OperatingSystem
import org.xtext.gradle.idea.tasks.AssembleSandbox
import org.xtext.gradle.idea.tasks.DownloadIdea
import org.xtext.gradle.idea.tasks.IdeaExtension
import org.xtext.gradle.idea.tasks.IdeaRepository
import org.xtext.gradle.idea.tasks.IdeaZip
import org.xtext.gradle.idea.tasks.RunIdea

import static extension org.xtext.gradle.idea.tasks.GradleExtensions.*

class IdeaRepositoryPlugin implements Plugin<Project> {

	override apply(Project project) {
		project.pluginManager.apply(IdeaDevelopmentPlugin)
		val idea = project.extensions.getByType(IdeaExtension)
		val repositoryTask = project.tasks.create("ideaRepository", IdeaRepository) [
			into(project.buildDir / 'ideaRepository')
		]
		project.subprojects [
			tasks.withType(IdeaZip) [ zip |
				repositoryTask.from(zip)
			]
		]
		val runIdea = project.tasks.create("runIdea", RunIdea)
		val downloadTask = project.tasks.getAt("downloadIdea") as DownloadIdea
		project.afterEvaluate [
			val ideaLibs = project.fileTree(downloadTask.ideaHomeDir + "/lib")
			ideaLibs.builtBy(downloadTask).include("*.jar")
			subprojects.map[tasks.withType(AssembleSandbox)].flatten.forEach[runIdea.dependsOn(it)]
			runIdea.sandboxDir = project.file(idea.sandboxDir)
			runIdea.ideaHome = project.file(idea.ideaHome)
			val tools = project.files('''«System.getenv("JAVA_HOME")»/lib/tools.jar''')
			runIdea.classpath = ideaLibs.classpath.plus(tools)
		]
	}
}