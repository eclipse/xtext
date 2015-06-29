package org.eclipse.xtext.idea.facet

import com.intellij.openapi.module.Module
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JCheckBox
import javax.swing.JComponent
import org.eclipse.xtext.idea.util.IdeaWidgetFactory
import java.awt.GridBagConstraints

/** 
 * Created by dhuebner on 19.06.15.
 */
class GeneratorFacetForm<T extends GeneratorConfigurationState> {
	extension IdeaWidgetFactory = new IdeaWidgetFactory

	JCheckBox activated
	TextFieldWithBrowseButton directory
	TextFieldWithBrowseButton testDirectory
	JCheckBox createDirectory
	JCheckBox overwriteFiles
	JCheckBox deleteGenerated

	Module module
	JComponent rootPanel

	new(Module module) {
		this.module = module
		this.rootPanel = createComponent()
	}

	def protected JComponent createComponent() {
		twoColumnPanel [ extension it |

			row [separator("General")]
			row [activated = checkBox("Compiler is activated")]
			row [label(" ")]

			row [separator("Output Folder")]
			row([label("Directory:")], [weightx = 1.0 directory = browseField(module.getProject())])
			row([label("Test Directory:")], [testDirectory = browseField(module.getProject())])

			row [createDirectory = checkBox("Create directory if it doesn't exist")]
			row [overwriteFiles = checkBox("Overwrite existing files")]
			row [deleteGenerated = checkBox("Delete generated files")]
			expand(GridBagConstraints.VERTICAL)
		]

	}

	def void setData(GeneratorConfigurationState data) {
		createDirectory.setSelected(data.isCreateDirectory())
		overwriteFiles.setSelected(data.isOverwriteExisting())
		deleteGenerated.setSelected(data.isDeleteGenerated())
		activated.setSelected(data.isActivated())
		directory.setText(data.getOutputDirectory())
		testDirectory.setText(data.getTestOutputDirectory())
	}

	def void getData(T data) {
		data.setCreateDirectory(createDirectory.isSelected())
		data.setOverwriteExisting(overwriteFiles.isSelected())
		data.setDeleteGenerated(deleteGenerated.isSelected())
		data.setActivated(activated.isSelected())
		data.setOutputDirectory(directory.getText())
		data.setTestOutputDirectory(testDirectory.getText())
	}

	def boolean isModified(T data) {
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
		return rootPanel
	}

}
