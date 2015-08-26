package org.eclipse.xtext.xtext.wizard.cli

import com.google.common.io.Files
import java.io.File
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor
import org.eclipse.xtext.xtext.wizard.ProjectsCreator
import org.eclipse.xtext.xtext.wizard.WizardConfiguration

class CliProjectsCreator implements ProjectsCreator {

	override createProjects(WizardConfiguration config) {
		config.enabledProjects.forEach [
			createProject
		]
	}

	def createProject(ProjectDescriptor project) {
		val projectRoot = new File(project.location)
		projectRoot.mkdirs
		project.files.forEach [
			val projectRelativePath = project.config.sourceLayout.getPathFor(outlet) + "/" + relativePath
			val file = new File(projectRoot, projectRelativePath)
			file.parentFile.mkdirs
			Files.write(bytes, file)
		]
		project.sourceFolders.forEach [
			new File(projectRoot, it).mkdirs
		]
	}

}