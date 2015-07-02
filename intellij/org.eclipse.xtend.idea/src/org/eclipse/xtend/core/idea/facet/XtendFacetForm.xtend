/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.facet

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.LanguageLevelModuleExtension
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.impl.LanguageLevelProjectExtensionImpl
import com.intellij.openapi.roots.ui.configuration.LanguageLevelCombo
import com.intellij.pom.java.LanguageLevel
import com.intellij.ui.components.JBTextField
import javax.swing.JCheckBox
import javax.swing.JLabel
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
	JLabel targetJavaVersionLbl
	LanguageLevelCombo targetJavaVersion
	JCheckBox generateSuppressWarnings
	JCheckBox generateGeneratedAnnotation
	JCheckBox includeDateInGenerated
	JBTextField generatedAnnotationComment

	JCheckBox installDslAsPrimarySource
	JCheckBox hideLocalSyntheticVariables

	new(Module module) {
		super(module)
	}

	override protected createComponent() {
		val comp = super.createComponent()
		includeDateInGenerated.enabled = false
		generatedAnnotationComment.enabled = false
		hideLocalSyntheticVariables.enabled = false

		useJavaCompilerCompliance.addItemListener [
			targetJavaVersion.enabled = !useJavaCompilerCompliance.selected
			targetJavaVersionLbl.enabled = !useJavaCompilerCompliance.selected

		]
		generateGeneratedAnnotation.addItemListener [
			includeDateInGenerated.enabled = generateGeneratedAnnotation.selected
			generatedAnnotationComment.enabled = generateGeneratedAnnotation.selected
		]
		installDslAsPrimarySource.addItemListener [
			hideLocalSyntheticVariables.enabled = installDslAsPrimarySource.selected
		]
		return comp
	}

	override createGeneralSection(extension TwoColumnPanel it) {
		super.createGeneralSection(it)
		row [useJavaCompilerCompliance = checkBox("Use source compatibility level from Java settings")]
		row [
			indent
			container(
				[targetJavaVersionLbl = label("Source compatibility level of generated code:")],
				[expand(HORIZONTAL) targetJavaVersion = createLanguageLavelCombo()]
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
			if (LanguageLevel.values.findFirst[it.name() === data.targetJavaVersion] != null) {
				targetJavaVersion.selectedItem = LanguageLevel.valueOf(data.targetJavaVersion)
			} else {
				targetJavaVersion.selectedItem = null
			}

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
				if(if (targetJavaVersion.selectedItem !== null)
					!targetJavaVersion.selectedItem.toString.equals(data.targetJavaVersion)
				else
					data.targetJavaVersion !== null) return true

				if(generateSuppressWarnings.isSelected() !== data.generateSuppressWarnings) return true

				if(generateGeneratedAnnotation.isSelected() !== data.generateGeneratedAnnotation) return true
				if(includeDateInGenerated.isSelected() !== data.includeDateInGenerated) return true
				if(if (generatedAnnotationComment.getText() !== null)
					!generatedAnnotationComment.getText().equals(data.generatedAnnotationComment)
				else
					data.generatedAnnotationComment !== null) return true

				if(installDslAsPrimarySource.isSelected() !== data.installDslAsPrimarySource) return true
			}
			return false
		}
		return true
	}

	def LanguageLevelCombo createLanguageLavelCombo() {
		val defItem = "Module default"
		val langLavelCombo = new LanguageLevelCombo(defItem) {
			val llExt = ModuleRootManager.getInstance(module).getModuleExtension(LanguageLevelModuleExtension)

			override protected LanguageLevel getDefaultLevel() {
				var langLevel = llExt.languageLevel
				if (langLevel == null) {
					langLevel = LanguageLevelProjectExtensionImpl.getInstanceImpl(module.project).getCurrentLevel()
				}
				return langLevel
			}
		}
		langLavelCombo.insertItemAt(defItem, 0);
		return langLavelCombo
	}
}