package org.eclipse.xtext.idea.wizard

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.ui.ComboBox
import javax.swing.JCheckBox
import javax.swing.JPanel
import javax.swing.JTextField
import org.eclipse.xtext.idea.util.IdeaWidgetFactory
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor.FileExtensions
import org.eclipse.xtext.xtext.wizard.ProjectLayout
import org.eclipse.xtext.xtext.wizard.SourceLayout

import static java.awt.GridBagConstraints.*
import com.intellij.openapi.diagnostic.Logger
import com.intellij.ide.wizard.CommitStepException
import com.intellij.openapi.util.io.FileUtil

class XtextWizardStep extends ModuleWizardStep {
	static final Logger LOG = Logger.getInstance(XtextWizardStep.name)

	extension IdeaWidgetFactory = new IdeaWidgetFactory

	JPanel mainPanel

	JTextField nameField
	JTextField extensionField

	JCheckBox idea
	JCheckBox web
	JCheckBox test

	ComboBox buildSystem
	ComboBox layout

	WizardContext context

	new(WizardContext context) {
		this.context = context
	}

	override getComponent() {
		try {
			if (mainPanel === null) {
				mainPanel = createMainPanel()
			}
			return mainPanel
		} catch (Exception exception) {
			LOG.error("Initialisation failed.", exception)
			return new JPanel
		}
	}

	def JPanel createMainPanel() {
		twoColumnPanel [ extension it |

			row [separator("Language")]
			row([label("Name:")], [expand(HORIZONTAL) nameField = textField('org.xtext.example.mydsl.MyDsl')])
			row([label("Extension:")], [extensionField = textField('mydsl')])
			row [label(" ")]

			row [separator("Facets")]
			row [idea = checkBox("Intellij Idea Plugin")]
			row [web = checkBox("Web Integration")]
			row [test = checkBox("Testing Support")]
			row [label(" ")]

			row [separator("Project Settings")]
			row([label("Build System:")], [
				indentRight(400)
				buildSystem = comboBox(BuildSystem.GRADLE, BuildSystem.MAVEN)
			])
			row([label("Source Layout:")], [indentRight(400) layout = comboBox(SourceLayout.PLAIN, SourceLayout.MAVEN)])

			row [expand(VERTICAL) label("")]
		]
	}

	override updateDataModel() {
		val xtextBuilder = context.projectBuilder as XtextModuleBuilder
		val config = xtextBuilder.getWizardConfiguration()

		config.language.name = nameField.text
		config.language.fileExtensions = FileExtensions.fromString(extensionField.text)

		config.runtimeProject.enabled = true
		config.ideProject.enabled = true
		config.runtimeProject.testProject.enabled = test.selected
		config.intellijProject.enabled = idea.selected
		config.webProject.enabled = idea.selected

		config.preferredBuildSystem = buildSystem.selectedItem as BuildSystem
		config.sourceLayout = layout.selectedItem as SourceLayout
		config.projectLayout = ProjectLayout.HIERARCHICAL
		config.baseName = FileUtil.getNameWithoutExtension(nameField.text)
	}

	override updateStep() {
	}

	override onWizardFinished() throws CommitStepException {
		val xtextBuilder = context.projectBuilder as XtextModuleBuilder
		val config = xtextBuilder.getWizardConfiguration
		config.rootLocation = context.projectFileDirectory

	}

}