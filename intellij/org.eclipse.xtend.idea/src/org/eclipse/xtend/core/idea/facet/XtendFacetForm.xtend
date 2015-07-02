/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.facet

import com.intellij.openapi.module.Module
import com.intellij.ui.components.JBTextField
import javax.swing.JCheckBox
import javax.swing.JComboBox
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState
import org.eclipse.xtext.idea.facet.GeneratorFacetForm
import org.eclipse.xtext.idea.util.IdeaWidgetFactory
import org.eclipse.xtext.idea.util.IdeaWidgetFactory.TwoColumnPanel

import static java.awt.GridBagConstraints.*

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendFacetForm extends GeneratorFacetForm {
	extension IdeaWidgetFactory = new IdeaWidgetFactory

	JCheckBox useJavaCompilerCompliance
	JComboBox targetJavaVersion
	JCheckBox generateSuppressWarnings
	JCheckBox generateGeneratedAnnotation
	JCheckBox includeDateInGenerated
	JBTextField generatedAnnotationComment

	JCheckBox installDslAsPrimarySource
	JCheckBox hideLocalSyntheticVariables

	new(Module module) {
		super(module)
	}

	override createGeneralSection(extension TwoColumnPanel it) {
		super.createGeneralSection(it)
		row [useJavaCompilerCompliance = checkBox("Use source compatibility level from Java settings")]
		row [
			indent
			container(
				[label("Source compatibility level of generated code:")],
				[expand(HORIZONTAL) targetJavaVersion = new JComboBox(#["Java 6", "Java 7"] as String[])]
			)
		]
		row [generateSuppressWarnings = checkBox("Generate @SuppressWarnings annotations")]
		row [generateGeneratedAnnotation = checkBox("Generate @Generated annotations")]
		row [indent includeDateInGenerated = checkBox("Include current time information")]
		row [
			indent
			container([label("Comment:")], [
				expand(HORIZONTAL)
				anchor = WEST
				generatedAnnotationComment = new JBTextField(20)
			])
		]
	}

	override createOutputSection(extension TwoColumnPanel it) {
		super.createOutputSection(it)
		row [installDslAsPrimarySource = checkBox("Ignore generated Java source when debugging (Use for Android)")]
		row [indent hideLocalSyntheticVariables = checkBox("Hide synthetic local variables in the debugger")]
	}

	override setData(GeneratorConfigurationState data) {
		super.setData(data)
		if (data instanceof XtendGeneratorConfigurationState) {
			useJavaCompilerCompliance.setSelected(data.useJavaCompilerCompliance)
			targetJavaVersion.selectedItem = data.targetJavaVersion

			generateSuppressWarnings.setSelected(data.generateSuppressWarnings)

			generateGeneratedAnnotation.setSelected(data.generateGeneratedAnnotation)
			includeDateInGenerated.setSelected(data.includeDateInGenerated)
			generatedAnnotationComment.text = data.generatedAnnotationComment

			installDslAsPrimarySource.setSelected(data.installDslAsPrimarySource)
		}
	}

	override getData(GeneratorConfigurationState data) {
		super.getData(data)
		if (data instanceof XtendGeneratorConfigurationState) {
			data.useJavaCompilerCompliance = useJavaCompilerCompliance.selected
			data.targetJavaVersion = targetJavaVersion.selectedItem?.toString

			data.generateSuppressWarnings = generateSuppressWarnings.selected

			data.generateGeneratedAnnotation = generateGeneratedAnnotation.selected
			data.includeDateInGenerated = includeDateInGenerated.selected
			data.generatedAnnotationComment = generatedAnnotationComment.text

			data.installDslAsPrimarySource = installDslAsPrimarySource.selected
		}
	}

	override isModified(GeneratorConfigurationState data) {
		if (!super.isModified(data)) {
			if (data instanceof XtendGeneratorConfigurationState) {
				if(useJavaCompilerCompliance.isSelected() !== data.useJavaCompilerCompliance) return true
				if(generateGeneratedAnnotation.isSelected() !== data.generateGeneratedAnnotation) return true
				if(generateSuppressWarnings.isSelected() !== data.generateSuppressWarnings) return true
				if(installDslAsPrimarySource.isSelected() !== data.installDslAsPrimarySource) return true
			// TODO check other properties
			}
			return false
		}
		return true
	}

}