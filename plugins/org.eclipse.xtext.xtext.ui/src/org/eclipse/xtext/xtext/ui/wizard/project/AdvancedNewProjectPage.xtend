/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project

import java.util.List
import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label

class AdvancedNewProjectPage extends WizardPage {

	Button createFeatureProject
	Button createTestProject
	Combo generatorConfigurationField

	new(String pageName) {
		super(pageName)
		title = Messages.WizardNewXtextProjectCreationPage_WindowTitle
		description = Messages.WizardNewXtextProjectCreationPage_Description
	}

	override createControl(Composite parent) {
		val showGeneratorConfigCombo = WizardContribution.fromRegistry.size > 1
		val facetsGroup = new Group(parent, SWT.NONE) => [
			font = parent.font
			text = Messages.WizardNewXtextProjectCreationPage_LabelFacets
			layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
			layout = new GridLayout(if(showGeneratorConfigCombo) 2 else 1, false)
		]

		val composite = new Composite(facetsGroup, SWT.NONE) => [
			layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
			layout = new GridLayout(1, false)
		]

		createFeatureProject = composite.newCheckBox => [
			text = Messages.WizardNewXtextProjectCreationPage_CreateFeatureLabel
			selection = true
		]

		createTestProject = composite.newCheckBox => [
			text = Messages.WizardNewXtextProjectCreationPage_CreateATestProject
			selection = true
		]

		if (showGeneratorConfigCombo) {
			new Label(composite, SWT.NONE) => [
				text = Messages.WizardNewXtextProjectCreationPage_GeneratorConfiguration
			]
			generatorConfigurationField = new Combo(composite, SWT.READ_ONLY) => [
				layoutData = new GridData(GridData.FILL_HORIZONTAL) => [
					horizontalSpan = 1
				]
				font = parent.font
			]
			fillMweSnippet
		}

		control = facetsGroup
	}

	def protected newCheckBox(Composite composite) {
		new Button(composite, SWT.CHECK) => [
			layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false) => [
				horizontalSpan = 1
			]
		]
	}

	def protected void fillMweSnippet() {
		val contributions = WizardContribution.getFromRegistry.values
		val names = contributions.toList.sortInplace.map[name]
		if (generatorConfigurationField !== null) {
			generatorConfigurationField.items = names
			generatorConfigurationField.select(names.indexOfDefault)
		}

	}

	def protected int indexOfDefault(List<String> contributions) {
		val index = contributions.indexOf(defaultConfigName)
		if(index !== -1) index else 0
	}

	def protected String getDefaultConfigName() {
		"Standard"
	}

	def boolean isCreateFeatureProject() {
		createFeatureProject.selection
	}

	def boolean isCreateTestProject() {
		createTestProject.selection
	}

	def String getGeneratorConfig() {
		if (generatorConfigurationField === null)
			WizardContribution.fromRegistry.values.head.name
		else {
			val index = generatorConfigurationField.selectionIndex
			generatorConfigurationField.items.get(index)
		}
	}

}