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
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.SourceLayout

class AdvancedNewProjectPage extends WizardPage {

	Button createUiProject
	Button createIdeaProject
	Button createWebProject
	Button createIdeProject
	Button createTestProject
	Combo preferredBuildSystem
	Combo sourceLayout

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
				createUiProject = CheckBox [
					text = "Eclipse Plugin"
				]
				createIdeaProject = CheckBox [
					text = "IntelliJ IDEA Plugin"
					enabled = true
				]
				createWebProject = CheckBox [
					text = "Web Integration"
					enabled = true
				]
				createIdeProject = CheckBox [
					text = "Generic IDE Support"
					enabled = true
				]
				createTestProject = CheckBox [
					text = Messages.WizardNewXtextProjectCreationPage_TestingSupport
				]
			]
			Group [
				text = "Preferred Build System"
				preferredBuildSystem = DropDown[
					enabled = true
					items = #["Eclipse", "Maven", "Gradle"]
				]
			]
			Group [
				text = "Source Layout"
				sourceLayout = DropDown[
					enabled = true
					items = #["Plain", "Maven/Gradle"]
				]
			]
		]

		createIdeaProject.require(createIdeProject)
		createWebProject.require(createIdeProject)
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
		createUiProject.selection = true
		createIdeaProject.selection = false
		createWebProject.selection = false
		createIdeProject.selection = false
		createTestProject.selection = false
		preferredBuildSystem.select(0)
		sourceLayout.select(0)
	}

	def boolean isCreateUiProject() {
		createUiProject.selection
	}

	def boolean isCreateTestProject() {
		createTestProject.selection
	}

	def boolean isCreateIdeProject() {
		createIdeProject.selection
	}

	def boolean isCreateIntellijProject() {
		createIdeaProject.selection
	}

	def boolean isCreateWebProject() {
		createWebProject.selection
	}
	
	def BuildSystem getPreferredBuildSystem() {
		BuildSystem.values.get(preferredBuildSystem.selectionIndex)
	}
	
	def SourceLayout getSourceLayout() {
		SourceLayout.values.get(sourceLayout.selectionIndex)
	}

	def private require(Button project, Button requirement) {
		val selectionControl = new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				if (project.equals(e.widget) && project.selection) {
					requirement.selection = true
				} else if (requirement.equals(e.widget) && !requirement.selection) {
					project.selection = false
				}
			}
		}
		project.addSelectionListener(selectionControl)
		requirement.addSelectionListener(selectionControl)
	}
}