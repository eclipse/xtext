package org.eclipse.xtext.idea.facet

import com.intellij.facet.ui.FacetValidatorsManager
import com.intellij.facet.ui.ValidationResult
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import java.awt.GridBagConstraints
import javax.swing.JCheckBox
import javax.swing.JComponent
import org.eclipse.xtext.idea.util.IdeaWidgetFactory
import org.eclipse.xtext.idea.util.IdeaWidgetFactory.TwoColumnPanel

import static extension com.intellij.openapi.util.io.FileUtil.*

/** 
 * Created by dhuebner on 19.06.15.
 */
class GeneratorFacetForm {
	extension IdeaWidgetFactory = new IdeaWidgetFactory

	protected JCheckBox activated
	protected TextFieldWithBrowseButton directory
	protected TextFieldWithBrowseButton testDirectory
	protected JCheckBox createDirectory
	protected JCheckBox overwriteFiles
	protected JCheckBox deleteGenerated

	Module module
	FacetValidatorsManager validatorsManager
	JComponent rootPanel

	new(Module module) {
		this(module, null)
	}
	
	new (Module module, FacetValidatorsManager validatorsManager) {
		this.module = module
		this.validatorsManager = validatorsManager
	}

	def protected JComponent createComponent() {
		twoColumnPanel [ extension it |

			row [separator("General")]
			createGeneralSection
			row [label(" ")]

			row [separator("Output Folder")]
			createOutputSection
			row [expand(GridBagConstraints.VERTICAL) label("")]
		]

	}

	def createOutputSection(extension TwoColumnPanel it) {
		row([label("Directory:")], [weightx = 1.0 directory = browseField(module.getProject())])
		row([label("Test Directory:")], [testDirectory = browseField(module.getProject())])

		row [createDirectory = checkBox("Create directory if it doesn't exist")]
		row [overwriteFiles = checkBox("Overwrite existing files")]
		row [deleteGenerated = checkBox("Delete generated files")]
		
		directory.registerDirectoryValidator('The output directory should belong to the module.')
		testDirectory.registerDirectoryValidator('The output test directory should belong to the module.')
	}
	
	protected def void registerDirectoryValidator(TextFieldWithBrowseButton directory, String errorMessage) {
		if(validatorsManager === null) return;

		validatorsManager.registerValidator([
			if (!directory.underModule)
				return new ValidationResult(errorMessage)

			return ValidationResult.OK
		], directory)
	}
	
	protected def boolean isUnderModule(TextFieldWithBrowseButton directory) {
		val path = directory.text
		if (!path.absolute) return true
		
		val root = ModuleRootManager.getInstance(module).contentRoots.head
		return root !== null && root.path.isAncestor(path, false)
	}

	def createGeneralSection(extension TwoColumnPanel it) {
		row [activated = checkBox("Compiler is activated")]
	}

	def void setData(GeneratorConfigurationState data) {
		createDirectory.setSelected(data.isCreateDirectory())
		overwriteFiles.setSelected(data.isOverwriteExisting())
		deleteGenerated.setSelected(data.isDeleteGenerated())
		activated.setSelected(data.isActivated())
		directory.setText(data.getOutputDirectory())
		testDirectory.setText(data.getTestOutputDirectory())
	}

	def void getData(GeneratorConfigurationState data) {
		data.setCreateDirectory(createDirectory.isSelected())
		data.setOverwriteExisting(overwriteFiles.isSelected())
		data.setDeleteGenerated(deleteGenerated.isSelected())
		data.setActivated(activated.isSelected())
		data.setOutputDirectory(directory.getText())
		data.setTestOutputDirectory(testDirectory.getText())
	}

	def boolean isModified(GeneratorConfigurationState data) {
		if(createDirectory.isSelected() !== data.isCreateDirectory()) return true
		if(overwriteFiles.isSelected() !== data.isOverwriteExisting()) return true
		if(deleteGenerated.isSelected() !== data.isDeleteGenerated()) return true
		if(activated.isSelected() !== data.isActivated()) return true
		if(if (directory.getText() !== null)
			!directory.getText().equals(data.getOutputDirectory())
		else
			data.getOutputDirectory() !== null) return true
		if(if (testDirectory.getText() !== null)
			!testDirectory.getText().equals(data.getTestOutputDirectory())
		else
			data.getTestOutputDirectory() !== null) return true
		return false
	}

	def JComponent getRootComponent() {
		if (rootPanel === null) {
			this.rootPanel = createComponent()
			postCreateComponent()
		}
		return rootPanel
	}
	
	def postCreateComponent() {
		deleteGenerated.visible = false
	}

	def Module getModule() {
		this.module
	}
}
