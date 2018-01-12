/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.projectWizard

import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import javax.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef

/**
 * Add a new project wizard with a template selection page.
 *
 * Example usage:
 * <pre> 
 * component = XtextGenerator {
 *     language = StandardLanguage {
 *         fragment = ui.projectWizard.TemplateProjectWizardFragment {
 *             generate = true
 *         }
 *     }
 * }
 * </pre>
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
class TemplateProjectWizardFragment extends AbstractXtextGeneratorFragment {

	@Inject
	extension XtextGeneratorNaming

	@Inject
	FileAccessFactory fileAccessFactory

	@Accessors
	private boolean generate = false;
	@Accessors
	private boolean pluginProject = true;

	override generate() {
		if (!generate)
			return;

		if (projectConfig.eclipsePlugin?.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += #[
				"org.eclipse.ui",
				"org.eclipse.core.runtime",
				"org.eclipse.core.resources",
				"org.eclipse.ui.ide",
				"org.eclipse.ui.forms"
			]
			projectConfig.eclipsePlugin.manifest.exportedPackages += #[
				grammar.getEclipsePluginBasePackage + ".wizard"
			]
		}

		new GuiceModuleAccess.BindingFactory().addTypeToType(
			new TypeReference("org.eclipse.xtext.ui.wizard.IProjectCreator"),
			new TypeReference(projectCreatorClassName)
		).contributeTo(language.eclipsePluginGenModule);

		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<extension
					point="org.eclipse.ui.newWizards">
					<category id="«grammar.eclipsePluginBasePackage».category" name="«grammar.simpleName»">
					</category>
					<wizard
						category="«grammar.eclipsePluginBasePackage».category"
						class="«grammar.eclipsePluginExecutableExtensionFactory»:«projectWizardClassName»"
						id="«projectWizardClassName»"
						name="«grammar.simpleName» Project"
						icon="icons/new_«grammar.simpleName»_proj.gif"
						project="true">
					</wizard>
				</extension>
			'''
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				 <extension
				       point="org.eclipse.xtext.ui.projectTemplate">
				    <projectTemplateProvider
				          class="«getProjectTemplateProviderClassName»"
				          grammarName="«grammar.name»">
				    </projectTemplateProvider>
				 </extension>
			'''
		}
		
		generateProjectInfo
		generateWizardNewProjectCreationPage
		generateProjectTemplateProvider
		generateNewProjectWizard
		generateProjectCreator
		generateDefaultIcons
	}

	def generateProjectInfo() {
		val projectInfoClass = projectInfoClassName.typeRef

		val file = fileAccessFactory.createGeneratedJavaFile(projectInfoClass)
		file.content = '''
		import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;

		public class «projectInfoClass.simpleName» extends «"org.eclipse.xtext.ui.wizard.template.TemplateProjectInfo".typeRef» {
			public «projectInfoClass.simpleName»(AbstractProjectTemplate projectTemplate) {
				super(projectTemplate);
			}
		}
		'''
		file.writeTo(projectConfig.eclipsePlugin.srcGen)
	}

	def generateWizardNewProjectCreationPage() {
		val mainPageClass = projectWizardCreationPageClassName.typeRef

		val file = fileAccessFactory.createGeneratedJavaFile(mainPageClass)
		
		file.content = '''
		public class «mainPageClass.simpleName» extends «"org.eclipse.ui.dialogs.WizardNewProjectCreationPage".typeRef» {

			public «mainPageClass.simpleName»(String pageName) {
				super(pageName);
			}

		}
		'''
		file.writeTo(projectConfig.eclipsePlugin.srcGen)
	}

	def generateProjectTemplateProvider() {
		val initialContentsClass = getProjectTemplateProviderClassName.typeRef
		val quotes = "'''"
		val openVar = "«"
		val closeVar = "»"

		val file = fileAccessFactory.createXtendFile(initialContentsClass)
		
		file.content = '''
		import org.eclipse.core.runtime.Status
		import org.eclipse.xtext.ui.util.ProjectFactory
		import org.eclipse.xtext.ui.wizard.IProjectInfo
		import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
		import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
		import org.eclipse.xtext.ui.wizard.template.ProjectTemplate
		
		import static org.eclipse.core.runtime.IStatus.*

		/**
		 * Provide all available project templates to be available in the NewProjectWizard. Each template is described through one class annotated with @Template.
		 * With @Template the label, icon and description of the template, displayed to the user in the wizard, are defined.
		 * 
		 * In addition it is possible to define fields that are displayed as text field, checkbox or combobox. There exist three methods #text, #check and #combo
		 * to create such fields. These fields are presented to the user on a second page and can be used to configure the generated content by the end user.
		 * 
		 * The variables can be enabled/disabled by overriding #updateVariables. Each variable has a #isEnabled and a #setEnabled. It is also allowed to change
		 * the variable values in this method (e.g. to change a string in response to a change of a checkbox).
		 * 
		 * The variables can be validated by overriding the method #validate. Errors generated here are displayed in the wizard. The validation takes place after
		 * #updateVariables has been executed.
		 * 
		 * In the end code is to be generated. The method #generateFiles is executed. The given IrojectFileGenerator can be used to generate files inside the
		 * newly generated project. Values from variables might be used here to configure the generated files.
		 * 
		 * <pre>
		 * 	def helloFile() {
		 * 		new ProjectFile(«openVar»quotes«closeVar»src/«openVar»path«closeVar»/Model.pas«quotes», «quotes»
		 * 			Hello «openVar»name«closeVar»!
		 * 		«openVar»quotes«closeVar»);
		 * 	}
		 * </pre>
		 */
		class «initialContentsClass.simpleName» implements IProjectTemplateProvider {
			override getProjectTemplates() {
				#[new HelloWorldProject]
			}
		}
		
		@ProjectTemplate(label="Hello World", icon="project_template.png", description="<p><b>Hello World</b></p>
		<p>This is a parameterized hello world for «grammar.name». You can set a parameter to modify the content in the generated file
		and a parameter to set the package the file is created in.</p>")
		final class HelloWorldProject {
			var advanced = check("Advanced", false, "Check to enabled advanced configuration")
			var name = combo("Name", #["Xtext", "World", "Foo", "Bar"], "The name to say 'Hello' to")
			var path = text("Package", "«language.fileExtensions.get(0)»", "The package path to place the files in")
		
			override protected updateVariables() {
				name.enabled = advanced.value
				path.enabled = advanced.value
				if (!advanced.value) {
					name.value = "Xtext"
					path.value = "«language.fileExtensions.get(0)»"
				}
			}
		
			override protected validate() {
				if (path.value.matches('[a-z][a-z0-9_]*(/[a-z][a-z0-9_]*)*'))
					null
				else
					new Status(ERROR, "Wizard", "'" + path + "' is not a valid package name")
			}
		
			override generateProjects(IProjectGenerator generator) {
				generator.generate(new ProjectFactory().addFile(«quotes»src/«openVar»path«closeVar»/Model.«language.fileExtensions.get(0)»«quotes»,
					«quotes»
						/*
						 * This is an example model
						 */
						Hello «openVar»name«closeVar»!
					«quotes»))
			}
		}
		'''
		file.writeTo(projectConfig.eclipsePlugin.src)
	}
	
	def generateProjectCreator() {
		val genClass = getProjectCreatorClassName.typeRef
		val projectInfoClass = projectInfoClassName.typeRef
		val baseClass = {
			if (pluginProject)
				"org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator"
			else
				"org.eclipse.xtext.ui.wizard.AbstractProjectCreator"
		}.typeRef

		val file = fileAccessFactory.createGeneratedJavaFile(genClass)
		
		file.content = '''
		import java.util.HashMap;
		import java.util.List;
		import java.util.Set;

		import org.eclipse.core.resources.IProject;
		import org.eclipse.core.resources.IResource;
		import org.eclipse.core.runtime.CoreException;
		import org.eclipse.core.runtime.IProgressMonitor;
		import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
		import org.eclipse.xtext.generator.IFileSystemAccess;
		import org.eclipse.xtext.generator.IFileSystemAccess2;
		import org.eclipse.xtext.generator.IOutputConfigurationProvider;
		import org.eclipse.xtext.generator.OutputConfiguration;
		«IF pluginProject»
		import org.eclipse.xtext.ui.util.PluginProjectFactory;
		«ELSE»
		import org.eclipse.xtext.ui.util.ProjectFactory;
		«ENDIF»
		import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
		import org.eclipse.xtext.ui.wizard.template.ProjectFileGenerator;
		import com.google.common.collect.ImmutableList;
		«IF pluginProject»
		import com.google.common.collect.Lists;
		«ENDIF»
		import javax.inject.Inject;
		import com.google.inject.Provider;
		
		public class «genClass.simpleName» extends «baseClass» {
			protected static final String DSL_PROJECT_NAME = "«grammar.namespace»";

			@Inject
			private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;

			@Inject
			private IOutputConfigurationProvider outputConfigurationProvider;
			«IF !pluginProject»

			@Inject
			private Provider<ProjectFactory> projectFactoryProvider;
			
			@Override
			protected ProjectFactory createProjectFactory() {
				return projectFactoryProvider.get();
			}
			«ELSE»

			@Override
			protected PluginProjectFactory createProjectFactory() {
				PluginProjectFactory projectFactory = super.createProjectFactory();
				projectFactory.setWithPluginXml(false);
				return projectFactory;
			}
			«ENDIF»

			@Override
			protected «projectInfoClass.simpleName» getProjectInfo() {
				return («projectInfoClass.simpleName») super.getProjectInfo();
			}

			@Override
			protected String getModelFolderName() {
				return "src";
			}

			@Override
			protected List<String> getAllFolders() {
				Set<OutputConfiguration> outputConfigurations = outputConfigurationProvider.getOutputConfigurations();
				String outputFolder = "src-gen";
				for (OutputConfiguration outputConfiguration : outputConfigurations) {
					if (IFileSystemAccess.DEFAULT_OUTPUT.equals(outputConfiguration.getName())) {
						outputFolder = outputConfiguration.getOutputDirectory();
						break;
					}
				}
				return ImmutableList.of(getModelFolderName(), outputFolder);
			}
			«IF pluginProject»

			@Override
			protected List<String> getRequiredBundles() {
				return Lists.newArrayList(DSL_PROJECT_NAME);
			}
			«ENDIF»
		
			@Override
			protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
				IFileSystemAccess2 access = getFileSystemAccess(project, monitor);
				createFromTemplate(access, getProjectInfo());
				project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			}
		
			protected IFileSystemAccess2 getFileSystemAccess(final IProject project, final IProgressMonitor monitor) {
				EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();
				access.setContext(project);
				access.setMonitor(monitor);
				OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
				defaultOutput.setDescription("Output Folder");
				defaultOutput.setOutputDirectory("./");
				defaultOutput.setOverrideExistingResources(true);
				defaultOutput.setCreateOutputDirectory(true);
				defaultOutput.setCleanUpDerivedResources(false);
				defaultOutput.setSetDerivedProperty(false);
				defaultOutput.setKeepLocalHistory(false);
				HashMap<String, OutputConfiguration> outputConfigurations = new HashMap<String, OutputConfiguration>();
				outputConfigurations.put(IFileSystemAccess.DEFAULT_OUTPUT, defaultOutput);
				access.setOutputConfigurations(outputConfigurations);
				return access;
			}

			private void createFromTemplate(IFileSystemAccess2 access, «projectInfoClass.simpleName» projectInfo) {
				AbstractProjectTemplate projectTemplate = projectInfo.getProjectTemplate();
				projectTemplate.generateFiles(new ProjectFileGenerator(access));
			}
		}
		'''
		file.writeTo(projectConfig.eclipsePlugin.srcGen)
	}

	def generateNewProjectWizard() {
		val genClass = getProjectWizardClassName.typeRef
		val projectInfoClass = projectInfoClassName.typeRef
		val creationPageClassName = projectWizardCreationPageClassName.typeRef

		val file = fileAccessFactory.createGeneratedJavaFile(genClass)
		file.content =
		'''
		import java.util.List;
		
		import javax.inject.Inject;
		
		import org.eclipse.jface.wizard.IWizardPage;
		import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
		import org.eclipse.xtext.ui.wizard.IProjectCreator;
		import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;
		import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
		import org.eclipse.xtext.ui.wizard.template.NewProjectWizardTemplateParameterPage;
		import org.eclipse.xtext.ui.wizard.template.NewProjectWizardTemplateSelectionPage;
		import org.eclipse.xtext.ui.wizard.template.ProjectTemplateLabelProvider;
		import org.eclipse.xtext.ui.wizard.template.ProjectVariable;
		
		public class «genClass.simpleName» extends «"org.eclipse.xtext.ui.wizard.XtextNewProjectWizard".typeRef» {
		
			private static final String GRAMMAR_NAME = "«grammar.name»";
		
			private «creationPageClassName» mainPage;
			private NewProjectWizardTemplateSelectionPage templatePage;
			private NewProjectWizardTemplateParameterPage templateParameterPage;
			@Inject
			private ProjectTemplateLabelProvider labelProvider;
		
			@Inject
			public «genClass.simpleName»(IProjectCreator projectCreator) {
				super(projectCreator);
				setWindowTitle("New «grammar.simpleName» Project");
			}
		
			protected «creationPageClassName» getMainPage() {
				return mainPage;
			}
		
			/**
			 * Use this method to add pages to the wizard.
			 * The one-time generated version of this class will add a default new project page to the wizard.
			 */
			@Override
			public void addPages() {
				mainPage = createMainPage("basicNewProjectPage");
				mainPage.setTitle("«grammar.simpleName» Project");
				mainPage.setDescription("Create a new «grammar.simpleName» project.");
				addPage(mainPage);
				templatePage = createTemplatePage("templateNewProjectPage");
				templatePage.setTitle("«grammar.simpleName» Project");
				templatePage.setDescription("Create a new «grammar.simpleName» project.");
				addPage(templatePage);
			}
		
			protected «creationPageClassName» createMainPage(String pageName) {
				return new «creationPageClassName»(pageName);
			}
		
			protected NewProjectWizardTemplateSelectionPage createTemplatePage(String pageName) {
				return new NewProjectWizardTemplateSelectionPage(pageName, GRAMMAR_NAME, labelProvider);
			}
			
			/**
			 * Use this method to read the project settings from the wizard pages and feed them into the project info class.
			 */
			@Override
			protected IExtendedProjectInfo getProjectInfo() {
				«projectInfoClass.simpleName» projectInfo = new «projectInfoClass.simpleName»(templatePage == null ? null : templatePage.getSelectedTemplate());
				projectInfo.setProjectName(mainPage.getProjectName());
				if (!mainPage.useDefaults()) {
					projectInfo.setLocationPath(mainPage.getLocationPath());
				}
				return projectInfo;
			}

			@Override
			public IWizardPage getNextPage(IWizardPage page) {
				if (page instanceof NewProjectWizardTemplateSelectionPage) {
					AbstractProjectTemplate selectedTemplate = templatePage.getSelectedTemplate();
					if (selectedTemplate == null)
						return null;
					List<ProjectVariable> variables = selectedTemplate.getVariables();
					if (variables.isEmpty())
						return null;
					NewProjectWizardTemplateParameterPage parameterPage = new NewProjectWizardTemplateParameterPage(
							selectedTemplate, getProjectInfo());
					parameterPage.setWizard(this);
					templateParameterPage = parameterPage;
					parameterPage.setTitle("«grammar.simpleName» Project");
					parameterPage.setDescription("Create a new «grammar.simpleName» project.");
					return parameterPage;
				}
				return super.getNextPage(page);
			}

			@Override
			public IWizardPage getPreviousPage(IWizardPage page) {
				if (page instanceof NewProjectWizardTemplateParameterPage) {
					templateParameterPage = null;
					return templatePage;
				}
				return super.getPreviousPage(page);
			}

			@Override
			public boolean canFinish() {
				return super.canFinish() && (templateParameterPage == null ? true : templateParameterPage.isPageComplete());
			}
		}
		'''
		file.writeTo(projectConfig.eclipsePlugin.srcGen)
	}

	def generateDefaultIcons() {
		val projectTemplate = fileAccessFactory.createBinaryFile("project_template.png")
		projectTemplate.content = readBinaryFileFromPackage("project_template.png")
		projectTemplate.writeTo(projectConfig.eclipsePlugin.icons)
		
		val newProject = fileAccessFactory.createBinaryFile("new_" + grammar.simpleName + "_proj.gif")
		newProject.content = readBinaryFileFromPackage("new_xproj.gif")
		newProject.writeTo(projectConfig.eclipsePlugin.icons)
	}
	
	private def byte[] readBinaryFileFromPackage(String fileName) {
		// TODO use "readAllBytes" as soon as we switch to Java 9
		//return TemplateProjectWizardFragment.getResourceAsStream(fileName).readAllBytes();
		val bis = new BufferedInputStream(TemplateProjectWizardFragment.getResourceAsStream(fileName));
		val buf = new ByteArrayOutputStream();
		var next = bis.read();
		while(next != -1) {
		    buf.write(next as byte);
		    next = bis.read();
		}
		return buf.toByteArray
	}

	protected def String getProjectTemplateProviderClassName() {
		getProjectWizardPackage() + grammar.simpleName + "ProjectTemplateProvider"
	}

	protected def String getProjectWizardInitialContentsClassName() {
		getProjectWizardClassName + "InitialContents"
	}

	protected def String getProjectWizardClassName() {
		getProjectWizardPackage() + grammar.simpleName + "NewProjectWizard"
	}

	protected def String getProjectWizardCreationPageClassName() {
		getProjectWizardPackage() + grammar.simpleName + "WizardNewProjectCreationPage"
	}

	protected def String projectWizardTemplateSelectionPageClassName() {
		getProjectWizardPackage() + grammar.simpleName + "WizardNewProjectWizardTemplateSelectionPage"
	}

	protected def String getProjectCreatorClassName() {
		getProjectWizardPackage() + grammar.simpleName + "ProjectCreator"
	}

	protected def String getProjectInfoClassName() {
		getProjectWizardPackage() + grammar.simpleName + "ProjectInfo"
	}

	protected def String getProjectWizardPackage() {
		grammar.getEclipsePluginBasePackage + ".wizard."
	}
}