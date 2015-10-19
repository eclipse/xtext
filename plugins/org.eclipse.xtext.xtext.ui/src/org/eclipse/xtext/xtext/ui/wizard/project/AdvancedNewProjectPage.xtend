/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.ScrolledComposite
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Group
import org.eclipse.xtext.xtext.ui.internal.Activator
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.SourceLayout
import org.osgi.framework.Bundle

class AdvancedNewProjectPage extends WizardPage {

	Button createUiProject
	Button createIdeaProject
	Button createWebProject
	Button createIdeProject
	Button createTestProject
	Combo preferredBuildSystem
	Combo sourceLayout

	StatusWidget statusWidget

	new(String pageName) {
		super(pageName)
		title = Messages.AdvancedNewProjectPage_WindowTitle
		description = Messages.AdvancedNewProjectPage_Description
	}

	override createControl(Composite parent) {
		control = new ScrolledComposite(parent, SWT.V_SCROLL) =>
			[
				layout = new FillLayout
				expandHorizontal = true
				expandVertical = true

				content = new Composite(it, SWT.NONE) =>
					[
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
							].decorate(
								INFORMATION, '''Generic IDE Support is requiered for front end projects like Eclipse, Idea or Web.''')

							createTestProject = CheckBox [
								text = Messages.WizardNewXtextProjectCreationPage_TestingSupport
							]
						]
						Group [
							text = "Preferred Build System"
							preferredBuildSystem = DropDown[
								enabled = true
								items = BuildSystem.values.map[toString]
							]
						]
						Group [
							text = "Source Layout"
							sourceLayout = DropDown[
								enabled = true
								items = SourceLayout.values.map[toString]
							].decorate(INFORMATION, "Info about layout")

						]
						statusWidget = new StatusWidget(it, SWT.NONE) => [
							layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
						]
					]
				minSize = content.computeSize(SWT.DEFAULT, SWT.DEFAULT)
			]

		val selectionControl = new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				validate(e)
			}
		}

		createUiProject.addSelectionListener(selectionControl)
		sourceLayout.addSelectionListener(selectionControl)
		createWebProject.addSelectionListener(selectionControl)
		preferredBuildSystem.addSelectionListener(selectionControl)
		createUiProject.addSelectionListener(selectionControl)
		createIdeaProject.addSelectionListener(selectionControl)
		createWebProject.addSelectionListener(selectionControl)
		createIdeProject.addSelectionListener(selectionControl)
		setDefaults
	}

	def void validate(SelectionEvent e) {
		statusWidget.clearStatus
		message = null
		checkWidgets(e)
		pageComplete = statusWidget.severtity !== ERROR
	}

	def checkWidgets(SelectionEvent e) {
		val source = e?.source
		if (createUiProject.selection && !sourceLayout.isSelected(SourceLayout.PLAIN)) {
			if (createUiProject === source) {
				reportIssue(ERROR, '''
				'«createUiProject.text»' requiers «SourceLayout.PLAIN» source layout.
				Please <a>select '«SourceLayout.PLAIN»'</a> source layout.''', [
					sourceLayout.select(SourceLayout.PLAIN)
				])
			} else {
				reportIssue(ERROR, '''
				«SourceLayout.PLAIN» source layout is not supported by the '«createUiProject.text»' project.
				Please <a>deselect '«createUiProject.text»'</a>.''', [
					createUiProject.selection = false
				])
			}
		}

		if (createWebProject.selection && preferredBuildSystem.isSelected(BuildSystem.ECLIPSE)) {
			if (preferredBuildSystem === source) {
				reportIssue(WARNING, '''
				The '«createWebProject.text»' project can not be build using Eclipse-PDE build.
				Please <a>deselect '«createWebProject.text»'</a>.''', [
					createWebProject.selection = false
				])
			} else {
				reportIssue(WARNING, '''
				To build the '«createWebProject.text»' project, you need to choose maven or gradle build system.
				Select <a>gradle</a> build.''', [
					preferredBuildSystem.select(BuildSystem.GRADLE)
				])
			}
		}

		val dependend = #[createUiProject, createIdeaProject, createWebProject]
		if (!createIdeProject.selection && dependend.exists[selection]) {
			val affectedProjects = dependend.filter[selection].join(', ', [text])
			if (createIdeProject === source) {
				reportIssue(ERROR, '''
				Frontend projects like '«affectedProjects»' depends on '«createIdeProject.text»' project.
				Please <a>deselect</a> these.''', [
					dependend.forEach[selection = false]
				])
			} else {
				reportIssue(ERROR, '''
				Projects like '«affectedProjects»' depends on '«createIdeProject.text»' project.
				Please <a>enable '«createIdeProject.text»'</a> project.''', [
					createIdeProject.selection = true
				])
			}
		}

		if (preferredBuildSystem.isSelected(BuildSystem.MAVEN) && !isBundleResolved("org.eclipse.m2e.maven.runtime")) {
			setMessage('Maven integration for eclipse is not installed. Consider to install M2e.', WARNING)
		}
		if (preferredBuildSystem.isSelected(BuildSystem.GRADLE) && !isBundleResolved("org.eclipse.buildship.core")) {
			setMessage('Gradle integration for eclipse is not installed. Consider to install Buildship.', WARNING)
		}
	}

	def protected select(Combo combo, Enum<?> enu) {
		combo.select(combo.items.indexed.findFirst[value == enu.toString].key)
	}

	def protected boolean isSelected(Combo combo, Enum<?> enu) {
		return enu.toString == combo.text
	}

	def protected <T extends Control> reportIssue(int severity, String text, ()=>void fix) {
		statusWidget.setStatus(severity, text, fix, [
			validate(null)
		])
	}

	def protected boolean isBundleResolved(String bundleId) {
		val bundle = Activator.instance.bundle.bundleContext.bundles.findFirst[bundleId == it.symbolicName]
		return bundle !== null && bundle.state === Bundle.RESOLVED
	}

	def private <T extends Control> T decorate(T control, int severity, String text) {
		val vertical = if(severity === INFORMATION) SWT.DOWN else SWT.UP
		var dec = new ControlDecoration(control, vertical.bitwiseOr(SWT.LEFT), control.parent)
		val decoration = switch (severity) {
			case WARNING:
				FieldDecorationRegistry.DEC_WARNING
			case ERROR:
				FieldDecorationRegistry.DEC_ERROR
			default:
				FieldDecorationRegistry.DEC_INFORMATION
		}
		var infoIndication = FieldDecorationRegistry.getDefault().getFieldDecoration(decoration)
		dec.setImage(infoIndication.getImage())
		dec.descriptionText = text
		return control
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
		createIdeProject.selection = true
		createTestProject.selection = true
		createIdeaProject.selection = false
		createWebProject.selection = false
		preferredBuildSystem.select(BuildSystem.values.head)
		sourceLayout.select(SourceLayout.values.head)
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

}