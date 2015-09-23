package org.eclipse.xtext.idea.wizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.service.execution.ProgressExecutionMode
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.externalSystem.util.ExternalSystemUtil
import com.intellij.openapi.module.JavaModuleType
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.StdModuleTypes
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import org.eclipse.xtext.idea.Icons
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil
import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.jetbrains.idea.maven.project.MavenProjectsManager
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings
import org.jetbrains.plugins.gradle.util.GradleConstants
import org.jetbrains.plugins.gradle.settings.DistributionType

class XtextModuleBuilder extends ModuleBuilder {

	extension ProjectLifecycleUtil = new ProjectLifecycleUtil
	static final Logger LOG = Logger.getInstance(XtextWizardStep.name)

	WizardConfiguration wizardConfiguration = new WizardConfiguration

	override getNodeIcon() {
		Icons.DSL_FILE_TYPE
	}

	override String getDescription() {
		return "Xtext Language Project"
	}

	override String getPresentableName() {
		return "Xtext"
	}

	override String getGroupName() {
		return "Xtext"
	}

	override getBuilderId() {
		"xtextModuleBuilder"
	}

	override String getParentGroup() {
		return JavaModuleType.JAVA_GROUP
	}

	override void setupRootModel(ModifiableRootModel rootModel) throws ConfigurationException {
		var String path = FileUtil.toSystemIndependentName(getContentEntryPath())
		new File(path).mkdirs()
		val VirtualFile root = LocalFileSystem.getInstance().refreshAndFindFileByPath(path)
		rootModel.addContentEntry(root)
		if (myJdk !== null) {
			rootModel.setSdk(myJdk)
		} else {
			rootModel.inheritSdk()
		}
	}

	override commitModule(Project project, ModifiableModuleModel model) {
		val modulesCreated = commit(project, model, null)
		return modulesCreated.findFirst[module|name == module.name]
	}

	override commit(Project project, ModifiableModuleModel model, ModulesProvider modulesProvider) {
		val moduleModel = if (model !== null)
				model
			else
				ModuleManager.getInstance(project).getModifiableModel()

		setupWizardConfiguration(wizardConfiguration)

		wizardConfiguration.rootLocation = project.basePath
		wizardConfiguration.baseName = name

		ApplicationManager.getApplication().runWriteAction [
			new IdeaProjectCreator(moduleModel).createProjects(wizardConfiguration)
			moduleModel.commit
		]

		if (wizardConfiguration.needsMavenBuild) {
			project.executeWhenProjectReady [
				var manager = MavenProjectsManager.getInstance(project)
				if (manager !== null) {
					val pomFilePath = wizardConfiguration.parentProject.location + File.separator + 'pom.xml'
					val virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(pomFilePath)
					if (virtualFile !== null) {
						manager.addManagedFilesOrUnignore(#[virtualFile])
					} else {
						LOG.warn('''Can't start maven import. File «pomFilePath» does not exists.''')
					}
				}
			]
		}
		if (wizardConfiguration.needsGradleBuild) {
			val gradleProjectSettings = new GradleProjectSettings
			gradleProjectSettings.setExternalProjectPath(wizardConfiguration.parentProject.location);
			gradleProjectSettings.distributionType = DistributionType.DEFAULT_WRAPPED
			val settings = ExternalSystemApiUtil.getSettings(project, GradleConstants.SYSTEM_ID);
			settings.linkProject(gradleProjectSettings);
			ExternalSystemUtil.refreshProject(project, GradleConstants.SYSTEM_ID,
				wizardConfiguration.parentProject.location, false, ProgressExecutionMode.IN_BACKGROUND_ASYNC);
		}
		return moduleModel.modules
	}

	def setupWizardConfiguration(WizardConfiguration wizardConfiguration) {
		wizardConfiguration.parentProject.nameQualifier = ''
		wizardConfiguration.runtimeProject.nameQualifier = '.core'
	}

	override int getWeight() {
		return 53
	}

	override ModuleType<?> getModuleType() {
		return StdModuleTypes.JAVA
	}

	override boolean isSuitableSdkType(SdkTypeId sdk) {
		return sdk === JavaSdk.getInstance()
	}

	override ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
		return new XtextWizardStep(context)
	}

	def WizardConfiguration getWizardConfiguration() {
		return this.wizardConfiguration
	}

}