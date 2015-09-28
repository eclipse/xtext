package org.eclipse.xtext.idea.wizard

import com.google.inject.Inject
import com.google.inject.Provider
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
import org.eclipse.xtext.idea.XtextXtextIcons
import org.eclipse.xtext.idea.lang.XtextLanguage
import org.eclipse.xtext.idea.util.ProjectLifecycleUtil
import org.eclipse.xtext.idea.wizard.IdeaProjectCreator.Factory
import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.jetbrains.idea.maven.project.MavenProjectsManager
import org.jetbrains.plugins.gradle.settings.DistributionType
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings
import org.jetbrains.plugins.gradle.util.GradleConstants

class XtextModuleBuilder extends ModuleBuilder {

	static final Logger LOG = Logger.getInstance(XtextWizardStep.name)

	@Inject extension ProjectLifecycleUtil
	@Inject Provider<WizardConfiguration> wizardConfigProvider
	@Inject WizardConfiguration wizardConfiguration
	@Inject Factory projectCreatorfactory

	new() {
		XtextLanguage.INSTANCE.injectMembers(this)
		wizardConfiguration = wizardConfigProvider.get
	}

	override getNodeIcon() {
		XtextXtextIcons.GRAMMAR_FILE_TYPE
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
		if (wizardConfiguration.parentProject.enabled) {
			return modulesCreated.findFirst[module|module.name == wizardConfiguration.parentProject.name]
		}
		return modulesCreated.findFirst[module|name == module.name]
	}

	override commit(Project project, ModifiableModuleModel model, ModulesProvider modulesProvider) {
		val moduleModel = if (model !== null)
				model
			else
				ModuleManager.getInstance(project).getModifiableModel()

		setupWizardConfiguration(wizardConfiguration)

		wizardConfiguration.rootLocation = project.baseDir.path
		wizardConfiguration.baseName = name

		ApplicationManager.getApplication().runWriteAction [
			projectCreatorfactory.create(moduleModel).createProjects(wizardConfiguration)
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
						LOG.error('''Can't start maven import. File «pomFilePath» does not exists.''')
					}
				}
			]
		}
		if (wizardConfiguration.needsGradleBuild) {
			val gradleProjectSettings = new GradleProjectSettings
			gradleProjectSettings.setExternalProjectPath(wizardConfiguration.parentProject.location);
			gradleProjectSettings.distributionType = DistributionType.DEFAULT_WRAPPED
			val settings = ExternalSystemApiUtil.getSettings(project, GradleConstants.SYSTEM_ID);
			settings.linkProject(gradleProjectSettings)
			ExternalSystemUtil.refreshProject(project, GradleConstants.SYSTEM_ID,
				wizardConfiguration.parentProject.location, false, ProgressExecutionMode.IN_BACKGROUND_ASYNC);
		}
		return moduleModel.modules
	}

	def setupWizardConfiguration(WizardConfiguration wizardConfiguration) {
		// TODO root module will became a '.parent' ending SettingsPage will not validate this
		// See com.intellij.ide.projectWizard.ProjectSettingsStep.getModuleNameField()
		// wizardConfiguration.parentProject.nameQualifier = ''
		// wizardConfiguration.runtimeProject.nameQualifier = '.core'
	}

	def WizardConfiguration getWizardConfiguration() {
		return this.wizardConfiguration
	}

}