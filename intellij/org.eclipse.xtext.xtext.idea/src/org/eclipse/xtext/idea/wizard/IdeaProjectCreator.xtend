package org.eclipse.xtext.idea.wizard

import com.google.inject.Inject
import com.intellij.ide.highlighter.ModuleFileType
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.StdModuleTypes
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import org.eclipse.xtext.idea.config.XtextProjectConfigurator
import org.eclipse.xtext.idea.lang.XtextLanguage
import org.eclipse.xtext.xtext.wizard.Outlet
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor
import org.eclipse.xtext.xtext.wizard.ProjectsCreator
import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.jetbrains.jps.model.java.JavaSourceRootType
import org.jetbrains.jps.model.java.JpsJavaExtensionService
import org.eclipse.xtext.xtext.wizard.TextFile
import org.eclipse.xtext.xtext.wizard.BinaryFile
import com.google.common.io.Resources

class IdeaProjectCreator implements ProjectsCreator {

	static class Factory {
		def IdeaProjectCreator create(ModifiableModuleModel model) {
			val pc = new IdeaProjectCreator(model)
			XtextLanguage.INSTANCE.injectMembers(pc)
			return pc
		}
	}

	@Inject XtextProjectConfigurator projectConfigrator
	ModifiableModuleModel model

	new(ModifiableModuleModel model) {
		this.model = model
	}

	override createProjects(WizardConfiguration config) {
		config.enabledProjects.forEach [
			createProject
		]
	}

	def Module createProject(ProjectDescriptor project) {
		val projectRoot = VfsUtil.createDirectories(project.location)
		val fileSystem = LocalFileSystem.getInstance()

		project.files.forEach [
			val projectRelativePath = project.config.sourceLayout.getPathFor(outlet) + "/" + relativePath
			val ioFile = new File(new File(projectRoot.path), projectRelativePath)
			ioFile.parentFile.mkdirs
			ioFile.createNewFile
			if(executable) {
				ioFile.executable = true
			}
			val virtualFile = fileSystem.refreshAndFindFileByIoFile(ioFile)
			switch(it) {
				TextFile:
					VfsUtil.saveText(virtualFile, content)
				BinaryFile:
					virtualFile.binaryContent = Resources.toByteArray(content)
			}
		]

		val module = model.newModule(project.moduleFilePath, StdModuleTypes.JAVA.id)
		val rootModel = ModuleRootManager.getInstance(module).modifiableModel
		rootModel.inheritSdk
		val modelContentRootDir = fileSystem.refreshAndFindFileByPath(project.location)
		val contentEntry = rootModel.addContentEntry(modelContentRootDir)
		val genFolders = Outlet.generateOutlets.map [
			project.sourceFolder(it)
		]
		project.sourceFolders.forEach [
			val VirtualFile sourceRoot = VfsUtil.createDirectoryIfMissing(modelContentRootDir, it)
			var rootType = JavaSourceRootType.SOURCE
			// val testFolders = Outlet.testOutlets.map [
			// project.sourceFolder(it)
			// ]
			// if (project instanceof TestedProjectDescriptor) {
			// if (testFolders.contains(it))
			// rootType = JavaSourceRootType.TEST_SOURCE
			// }
			val isGen = genFolders.contains(it)
			val properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", isGen)
			contentEntry.addSourceFolder(sourceRoot, rootType, properties)
		]
		// TODO re-enable when xtext.xtext is ready to use
		// if (project instanceof RuntimeProjectDescriptor) {
		// val conf = projectConfigrator.createOrGetFacetConf(module, XtextLanguage.INSTANCE.ID)
		// conf.state.outputDirectory = project.absoluteSourceFolder(Outlet.MAIN_SRC_GEN)
		// conf.state.testOutputDirectory = project.absoluteSourceFolder(Outlet.TEST_SRC_GEN)
		// }
		if (!(project instanceof ParentProjectDescriptor)) {
			val conf = projectConfigrator.createOrGetFacetConf(module, "org.eclipse.xtend.core.Xtend")
			if (conf !== null) {
				conf.state.outputDirectory = project.absoluteSourceFolder(Outlet.MAIN_XTEND_GEN)
				conf.state.testOutputDirectory = project.absoluteSourceFolder(Outlet.TEST_XTEND_GEN)
			}
		}
		rootModel.commit()
		return module
	}

	def String absoluteSourceFolder(ProjectDescriptor project, Outlet outlet) {
		project.location + '/' + project.sourceFolder(outlet)
	}

	def moduleFilePath(ProjectDescriptor project) {
		return project.location + File.separator + project.name + ModuleFileType.DOT_DEFAULT_EXTENSION;
	}
}