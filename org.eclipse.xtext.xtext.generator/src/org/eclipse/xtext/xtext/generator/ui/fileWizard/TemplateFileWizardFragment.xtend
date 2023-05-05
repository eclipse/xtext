/*******************************************************************************
 * Copyright (c) 2018, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.fileWizard

import com.google.common.annotations.Beta
import com.google.common.io.ByteStreams
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef
import com.google.inject.Inject

/**
 * Add a new file wizard with an (optional) template selection page.
 * 
 * Example usage:
 * <pre> 
 * component = XtextGenerator {
 *     language = StandardLanguage {
 *         fileWizard = {
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
class TemplateFileWizardFragment extends AbstractXtextGeneratorFragment {

	@Inject
	extension XtextGeneratorNaming

	@Inject
	FileAccessFactory fileAccessFactory

	@Accessors boolean generate = false;
	@Accessors boolean generateToolbarButton = false;

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
			projectConfig.eclipsePlugin.manifest.exportedPackages += #[
				grammar.getEclipsePluginBasePackage + ".wizard"
			]
		}

		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<extension
					point="org.eclipse.ui.newWizards">
					<category id="«grammar.eclipsePluginBasePackage».category" name="«grammar.simpleName»">
					</category>
					<wizard
						category="«grammar.eclipsePluginBasePackage».category"
						class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.wizard.template.TemplateNewFileWizard"
						id="«fileWizardClassName»"
						name="«grammar.simpleName» File"
						icon="icons/new_«grammar.simpleName»_file.png">
					</wizard>
				</extension>
				<extension
					point="org.eclipse.xtext.ui.fileTemplate">
					<fileTemplateProvider
						class="«grammar.eclipsePluginExecutableExtensionFactory»:«getFileTemplateProviderClassName»"
						grammarName="«grammar.languageId»">
					</fileTemplateProvider>
				</extension>
				<extension
					point="org.eclipse.ui.perspectiveExtensions">
					<perspectiveExtension targetID="org.eclipse.ui.resourcePerspective">
						<newWizardShortcut id="«fileWizardClassName»"/>
					</perspectiveExtension>
					<perspectiveExtension targetID="org.eclipse.jdt.ui.JavaPerspective">
						<newWizardShortcut id="«fileWizardClassName»"/>
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
									tooltip="Create a new «grammar.simpleName» file">
									<parameter
										name="newWizardId"
										value="«fileWizardClassName»">
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
		val initialContentsClass = getFileTemplateProviderClassName.typeRef
		val quotes = "'''"
		val openVar = "«"
		val closeVar = "»"

		val file = fileAccessFactory.createXtendFile(initialContentsClass)

		file.content = '''
			import org.eclipse.xtext.ui.wizard.template.FileTemplate
			import org.eclipse.xtext.ui.wizard.template.IFileGenerator
			import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider
			
			/**
			 * Create a list with all file templates to be shown in the template new file wizard.
			 * 
			 * Each template is able to generate one or more files.
			 */
			class «initialContentsClass.simpleName» implements IFileTemplateProvider {
				override getFileTemplates() {
					#[new HelloWorldFile]
				}
			}
			
			@FileTemplate(label="Hello World", icon="file_template.png", description="Create a hello world for «grammar.simpleName».")
			final class HelloWorldFile {
				val helloName = combo("Hello Name:", #["Xtext", "World", "Foo", "Bar"], "The name to say 'Hello' to")
			
				override generateFiles(IFileGenerator generator) {
					generator.generate(«quotes»«openVar»folder«closeVar»/«openVar»name«closeVar».«language.fileExtensions.get(0)»«quotes», «quotes»
						/*
						 * This is an example model
						 */
						Hello «openVar»helloName«closeVar»!
					«quotes»)
				}
			}
		'''
		file.writeTo(projectConfig.eclipsePlugin.src)
	}

	def generateDefaultIcons() {
		val projectTemplate = fileAccessFactory.createBinaryFile("file_template.png")
		if (!projectTemplate.existIn(projectConfig.eclipsePlugin.icons)) {
			projectTemplate.content = readBinaryFileFromPackage("file_template.png")
			projectTemplate.writeTo(projectConfig.eclipsePlugin.icons)
		}
		val newProject = fileAccessFactory.createBinaryFile("new_" + grammar.simpleName + "_file.png")
		if (!newProject.existIn(projectConfig.eclipsePlugin.icons)) {
			newProject.content = readBinaryFileFromPackage("new_xfile.png")
			newProject.writeTo(projectConfig.eclipsePlugin.icons)
		}
	}

	private def byte[] readBinaryFileFromPackage(String fileName) {
		val stream = TemplateFileWizardFragment.getResourceAsStream(fileName)
		try {
			return ByteStreams.toByteArray(stream);
		} finally {
			stream.close
		}
	}

	protected def String getFileTemplateProviderClassName() {
		getFileWizardPackage() + grammar.simpleName + "FileTemplateProvider"
	}

	protected def String getFileWizardClassName() {
		getFileWizardPackage() + grammar.simpleName + "NewFileWizard"
	}

	protected def String getFileWizardPackage() {
		grammar.getEclipsePluginBasePackage + ".wizard."
	}

	/**
	 * Generate the wizard. Set to 'false' by default. Change to 'true' to generate the wizard.
	 */
	def setGenerate(boolean value) {
		generate = value
	}

	/**
	 * Generate a new file wizard toolbar button. Set to 'false' by default. Change to 'true' to add the new file wizard button to the toolbar.
	 * 
	 * @since 2.20
	 */
	def setGenerateToolbarButton(boolean value) {
		generateToolbarButton = value
	}

}
