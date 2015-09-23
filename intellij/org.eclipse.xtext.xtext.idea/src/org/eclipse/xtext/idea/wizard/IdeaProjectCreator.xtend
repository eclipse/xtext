package org.eclipse.xtext.idea.wizard

import com.intellij.ide.highlighter.ModuleFileType
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.StdModuleTypes
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor
import org.eclipse.xtext.xtext.wizard.ProjectsCreator
import org.eclipse.xtext.xtext.wizard.WizardConfiguration

class IdeaProjectCreator implements ProjectsCreator {
	ModifiableModuleModel model

	new(ModifiableModuleModel model) {
		this.model = model
	}

	override createProjects(WizardConfiguration config) {
		config.enabledProjects.forEach [
			createProject
		]
	}

	def createProject(ProjectDescriptor project) {
		val projectRoot = VfsUtil.createDirectories(project.location)
		val fileSystem = LocalFileSystem.getInstance()

		project.files.forEach [
			val projectRelativePath = project.config.sourceLayout.getPathFor(outlet) + "/" + relativePath
			val ioFile = new File(new File(projectRoot.path), projectRelativePath)
			ioFile.parentFile.mkdirs
			ioFile.createNewFile
			VfsUtil.saveText(fileSystem.refreshAndFindFileByIoFile(ioFile), content)
		]

		val module = model.newModule(project.moduleFilePath, StdModuleTypes.JAVA.id)
		val rootModel = ModuleRootManager.getInstance(module).modifiableModel
		rootModel.inheritSdk
		val modelContentRootDir = fileSystem.refreshAndFindFileByPath(project.location)
		val contentEntry = rootModel.addContentEntry(modelContentRootDir)

		project.sourceFolders.forEach [
			val VirtualFile sourceRoot = VfsUtil.createDirectoryIfMissing(modelContentRootDir, it)
			contentEntry.addSourceFolder(sourceRoot, false)
		]
		rootModel.commit()
	}

	def moduleFilePath(ProjectDescriptor project) {
		return project.location + File.separator + project.name + ModuleFileType.DOT_DEFAULT_EXTENSION;
	}
}