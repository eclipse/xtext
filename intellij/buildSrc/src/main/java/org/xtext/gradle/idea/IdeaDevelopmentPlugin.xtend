package org.xtext.gradle.idea

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.xtext.gradle.idea.tasks.DownloadIdea
import org.xtext.gradle.idea.tasks.IdeaExtension

import static extension org.xtext.gradle.idea.tasks.GradleExtensions.*

class IdeaDevelopmentPlugin implements Plugin<Project> {

	override apply(Project project) {
		val idea = project.extensions.create("ideaDevelopment", IdeaExtension) => [
			ideaHome = project.rootDir / "ideaHome"
			ideaVersion = "140.2683.2"
			sandboxDir = project.rootProject.buildDir / "ideaSandbox"
		]
		val downloadTask = project.tasks.create("downloadIdea", DownloadIdea)
		project.afterEvaluate [
			downloadTask.ideaHome = idea.ideaHome
			downloadTask.ideaVersion = idea.ideaVersion
		]
	}
}