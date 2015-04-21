/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group

class AdvancedNewProjectPage extends WizardPage {

	Button createFeatureProject
	Button createTestProject
	Combo generatorConfigurationField

	new(String pageName) {
		super(pageName)
		title = Messages.AdvancedNewProjectPage_WindowTitle
		description = Messages.AdvancedNewProjectPage_Description
	}

	override createControl(Composite parent) {
		control = new Composite(parent, SWT.NONE) => [
			layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
			layout = new GridLayout(1, false)
			Group [
				text = Messages.WizardNewXtextProjectCreationPage_LabelFacets
				createFeatureProject = CheckBox [
					text = Messages.WizardNewXtextProjectCreationPage_CreateFeatureLabel
				]
				createTestProject = CheckBox [
					text = Messages.WizardNewXtextProjectCreationPage_CreateATestProject
				]
			]
			Group [
				text = Messages.WizardNewXtextProjectCreationPage_GeneratorConfiguration
				val contributions = WizardContribution.getFromRegistry.values
				visible = contributions.size > 1
				generatorConfigurationField = DropDown [
					items = contributions.toList.sortInplace.map[name]
				]
			]
		]
		setDefaults
	}

	def protected Group(Composite parent, (Group)=>void config) {
		new Group(parent, SWT.NONE) => [
			font = parent.font
			layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
			layout = new GridLayout(1, false)
			config.apply(it)
		]
	}

	def protected CheckBox(Composite composite, (Button)=>void config) {
		new Button(composite, SWT.CHECK) => [
			font = parent.font
			layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
			config.apply(it)
		]
	}

	def protected DropDown(Composite parent, (Combo)=>void config) {
		new Combo(parent, SWT.READ_ONLY) => [
			font = parent.font
			layoutData = new GridData(GridData.FILL_HORIZONTAL)
			config.apply(it)
		]
	}

	def protected setDefaults() {
		createFeatureProject.selection = true
		createTestProject.selection = true
		generatorConfigurationField.select(indexOfDefaultConfig)
	}

	def protected int indexOfDefaultConfig() {
		val index = generatorConfigurationField.items.indexOf(defaultConfigName)
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
		val index = generatorConfigurationField.selectionIndex
		generatorConfigurationField.items.get(index)
	}

}