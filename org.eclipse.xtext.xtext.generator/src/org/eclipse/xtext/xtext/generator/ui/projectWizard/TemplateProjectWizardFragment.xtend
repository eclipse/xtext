/*******************************************************************************
 * Copyright (c) 2017, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.projectWizard

import com.google.common.annotations.Beta
import com.google.common.io.ByteStreams
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef
import com.google.inject.Inject

/**
 * Add a new project wizard with a template selection page.
 * 
 * Example usage:
 * <pre> 
 * component = XtextGenerator {
 *     language = StandardLanguage {
 *         projectWizard = {
 *             generate = true
 *         }
 *     }
 * }
 * </pre>
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
class TemplateProjectWizardFragment extends AbstractXtextGeneratorFragment {

	@Inject
	extension XtextGeneratorNaming

	@Inject
	FileAccessFactory fileAccessFactory

	@Accessors boolean generate = false;
	@Accessors boolean generateToolbarButton = false;
	@Accessors boolean pluginProject = true;

	override generate() {
		if (!generate)
			return;

		if (projectConfig.eclipsePlugin?.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += #[
				"org.eclipse.core.runtime",
				"org.eclipse.core.resources",
				"org.eclipse.ui",
				"org.eclipse.ui.ide",
				"org.eclipse.ui.forms",
				"org.eclipse.xtend.lib"
			]
			if (pluginProject) {
				projectConfig.eclipsePlugin.manifest.requiredBundles += #[
					"org.eclipse.jdt.core",
					"org.eclipse.pde.core"
				]
			}
			projectConfig.eclipsePlugin.manifest.exportedPackages += #[
				grammar.getEclipsePluginBasePackage + ".wizard"
			]
		}

		new GuiceModuleAccess.BindingFactory().addTypeToType(
			new TypeReference("org.eclipse.xtext.ui.wizard.IProjectCreator"),
			new TypeReference("org.eclipse.xtext.ui.wizard.template.DefaultTemplateProjectCreator")
		).contributeTo(language.eclipsePluginGenModule);

		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<extension
					point="org.eclipse.ui.newWizards">
					<category id="«grammar.eclipsePluginBasePackage».category" name="«grammar.simpleName»">
					</category>
					<wizard
						category="«grammar.eclipsePluginBasePackage».category"
						class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard"
						id="«projectWizardClassName»"
						name="«grammar.simpleName» Project"
						icon="icons/new_«grammar.simpleName»_proj.gif"
						project="true">
					</wizard>
				</extension>
				<extension
					point="org.eclipse.xtext.ui.projectTemplate">
					<projectTemplateProvider
						class="«grammar.eclipsePluginExecutableExtensionFactory»:«getProjectTemplateProviderClassName»"
						grammarName="«grammar.languageId»">
					</projectTemplateProvider>
				</extension>
				<extension
					point="org.eclipse.ui.perspectiveExtensions">
					<perspectiveExtension targetID="org.eclipse.ui.resourcePerspective">
						<newWizardShortcut id="«projectWizardClassName»"/>
					</perspectiveExtension>
					<perspectiveExtension targetID="org.eclipse.jdt.ui.JavaPerspective">
						<newWizardShortcut id="«projectWizardClassName»"/>
					</perspectiveExtension>
				</extension>
			'''

			if (generateToolbarButton) {
				projectConfig.eclipsePlugin.pluginXml.entries += '''
					<extension
						point="org.eclipse.ui.menus">
						<menuContribution
							allPopups="false"
							locationURI="toolbar:org.eclipse.ui.main.toolbar">
							<toolbar
								id="«grammar.eclipsePluginBasePackage».toolbar">
								<!--
									For some reason the tooltip is not shown when hovering over the toolbar button
									See also https://www.eclipse.org/forums/index.php/t/1079111/
								-->
								<command
									commandId="org.eclipse.ui.newWizard"
									tooltip="Create a new «grammar.simpleName» project">
									<parameter
										name="newWizardId"
										value="«projectWizardClassName»">
									</parameter>
								</command>
							</toolbar>
						</menuContribution>
					</extension>
				'''
			}
		}

		generateProjectTemplateProvider
		generateDefaultIcons
	}

	def generateProjectTemplateProvider() {
		val initialContentsClass = getProjectTemplateProviderClassName.typeRef
		val quotes = "'''"
		val openVar = "«"
		val closeVar = "»"

		val file = fileAccessFactory.createXtendFile(initialContentsClass)

		file.content = '''
			import org.eclipse.core.runtime.Status
			«IF pluginProject»
				import org.eclipse.jdt.core.JavaCore
			«ENDIF»
			import org.eclipse.xtext.ui.XtextProjectHelper
			«IF pluginProject»
				import org.eclipse.xtext.ui.util.PluginProjectFactory
			«ELSE»
				import org.eclipse.xtext.ui.util.ProjectFactory
			«ENDIF»
			import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
			import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
			import org.eclipse.xtext.ui.wizard.template.ProjectTemplate
			
			import static org.eclipse.core.runtime.IStatus.*
			
			/**
			 * Create a list with all project templates to be shown in the template new project wizard.
			 * 
			 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
			 */
			class «initialContentsClass.simpleName» implements IProjectTemplateProvider {
				override getProjectTemplates() {
					#[new HelloWorldProject]
				}
			}
			
			@ProjectTemplate(label="Hello World", icon="project_template.png", description="<p><b>Hello World</b></p>
			<p>This is a parameterized hello world for «grammar.simpleName». You can set a parameter to modify the content in the generated file
			and a parameter to set the package the file is created in.</p>")
			final class HelloWorldProject {
				val advanced = check("Advanced:", false)
				val advancedGroup = group("Properties")
				val name = combo("Name:", #["Xtext", "World", "Foo", "Bar"], "The name to say 'Hello' to", advancedGroup)
				val path = text("Package:", "mydsl", "The package path to place the files in", advancedGroup)
			
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
			
				«IF pluginProject»
					override generateProjects(IProjectGenerator generator) {
						generator.generate(new PluginProjectFactory => [
							projectName = projectInfo.projectName
							location = projectInfo.locationPath
							projectNatures += #[JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID]
							builderIds += #[JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID]
							folders += "src"
							addFile(«quotes»src/«openVar»path«closeVar»/Model.«language.fileExtensions.get(0)»«quotes», «quotes»
								/*
								 * This is an example model
								 */
								Hello «openVar»name«closeVar»!
							«quotes»)
						])
					}
				«ELSE»
					override generateProjects(IProjectGenerator generator) {
						generator.generate(new ProjectFactory => [
							projectName = projectInfo.projectName
							location = projectInfo.locationPath
							projectNatures += XtextProjectHelper.NATURE_ID
							builderIds += XtextProjectHelper.BUILDER_ID
							addFile(«quotes»src/«openVar»path«closeVar»/Model.«language.fileExtensions.get(0)»«quotes», «quotes»
								/*
								 * This is an example model
								 */
								Hello «openVar»name«closeVar»!
							«quotes»)
						])
					}
				«ENDIF»
			}
		'''
		file.writeTo(projectConfig.eclipsePlugin.src)
	}

	def generateDefaultIcons() {
		val projectTemplate = fileAccessFactory.createBinaryFile("project_template.png")
		if (!projectTemplate.existIn(projectConfig.eclipsePlugin.icons)) {
			projectTemplate.content = readBinaryFileFromPackage("project_template.png")
			projectTemplate.writeTo(projectConfig.eclipsePlugin.icons)
		}
		val newProject = fileAccessFactory.createBinaryFile("new_" + grammar.simpleName + "_proj.gif")
		if (!newProject.existIn(projectConfig.eclipsePlugin.icons)) {
			newProject.content = readBinaryFileFromPackage("new_xproj.gif")
			newProject.writeTo(projectConfig.eclipsePlugin.icons)
		}
	}

	private def byte[] readBinaryFileFromPackage(String fileName) {
		val stream = TemplateProjectWizardFragment.getResourceAsStream(fileName)
		try {
			return ByteStreams.toByteArray(stream);
		} finally {
			stream.close
		}
	}

	protected def String getProjectTemplateProviderClassName() {
		getProjectWizardPackage() + grammar.simpleName + "ProjectTemplateProvider"
	}

	protected def String getProjectWizardClassName() {
		getProjectWizardPackage() + grammar.simpleName + "NewProjectWizard"
	}

	protected def String getProjectWizardPackage() {
		grammar.getEclipsePluginBasePackage + ".wizard."
	}

	/**
	 * Generate the wizard. Set to 'false' by default. Change to 'true' to generate the wizard.
	 */
	def setGenerate(boolean value) {
		generate = value
	}

	/**
	 * Generate a new project wizard toolbar button. Set to 'false' by default. Change to 'true' to add the new project wizard button to the toolbar.
	 * 
	 * @since 2.20
	 */
	def setGenerateToolbarButton(boolean value) {
		generateToolbarButton = value
	}

	/**
	 * Generate the projects as eclipse plugins. Affects only the example content of the templates. Can be changed
	 * manually afterwards.
	 */
	def setPluginProject(boolean value) {
		pluginProject = value
	}

}
