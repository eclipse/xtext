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
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Group
import org.eclipse.ui.PlatformUI
import org.eclipse.xtext.xtext.ui.internal.Activator
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.SourceLayout
import static org.eclipse.xtext.xtext.ui.wizard.project.Messages.*
import static org.osgi.framework.Bundle.*

class AdvancedNewProjectPage extends WizardPage {

	Button createUiProject
	Button createSDKProject
	Button createP2Project
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
		control = new Composite(parent, SWT.NONE) => [
			layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
			layout = new GridLayout(1, false)
			
			Group [
				text = Messages.WizardNewXtextProjectCreationPage_LabelFacets
				createUiProject = CheckBox [
					text = AdvancedNewProjectPage_projEclipse
				]
				Group [
					createSDKProject = CheckBox [
						text = AdvancedNewProjectPage_projEclipseSDKFeature
					]
					createP2Project = CheckBox [
						text = AdvancedNewProjectPage_projEclipseP2
					]
				]
				createIdeaProject = CheckBox [
					text = AdvancedNewProjectPage_projIdea
					enabled = true
				]
				createWebProject = CheckBox [
					text = AdvancedNewProjectPage_projWeb
					enabled = true
				]
				createIdeProject = CheckBox [
					text = AdvancedNewProjectPage_projIde
					enabled = true
				]
				createTestProject = CheckBox [
					text = Messages.WizardNewXtextProjectCreationPage_TestingSupport
				]
			]
			Group [
				text = AdvancedNewProjectPage_prefBuildSys
				preferredBuildSystem = DropDown[
					enabled = true
					items = BuildSystem.values.map[toString]
				]
			]
			Group [
				text = AdvancedNewProjectPage_srcLayout
				sourceLayout = DropDown[
					enabled = true
					items = SourceLayout.values.map[toString]
				]

			]
			statusWidget = new StatusWidget(it, SWT.NONE) => [
				layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
			]
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
		createSDKProject.addSelectionListener(selectionControl)
		createP2Project.addSelectionListener(selectionControl)
		setDefaults

		PlatformUI.getWorkbench().getHelpSystem().setHelp(shell, "org.eclipse.xtext.xtext.ui.newProject_Advanced")
	}

	def void validate(SelectionEvent e) {
		statusWidget.clearStatus
		checkWidgets(e)
		pageComplete = statusWidget.severtity !== ERROR
	}

	def checkWidgets(SelectionEvent e) {

		if (preferredBuildSystem.isSelected(BuildSystem.MAVEN) && !isBundleResolved("org.eclipse.m2e.maven.runtime")) {
			reportIssue(WARNING, AdvancedNewProjectPage_noM2e)
		}
		if (preferredBuildSystem.isSelected(BuildSystem.GRADLE) && !isBundleResolved("org.eclipse.buildship.core")) {
			reportIssue(WARNING, AdvancedNewProjectPage_noBuildship)
		}
		if (preferredBuildSystem.isSelected(BuildSystem.GRADLE) && createUiProject.selection) {
			reportIssue(WARNING,
				AdvancedNewProjectPage_eclipseAndGradleWarn)
		}
		if (preferredBuildSystem.isSelected(BuildSystem.MAVEN) && createIdeaProject.selection) {
			reportIssue(WARNING,
				AdvancedNewProjectPage_ideaAndMavenWarn)
		}
		if (preferredBuildSystem.isSelected(BuildSystem.NONE) && createIdeaProject.selection) {
			reportIssue(INFORMATION,
				AdvancedNewProjectPage_ideaReqGradleInfo)
		}

		val source = e?.source
		if (createUiProject.selection && !sourceLayout.isSelected(SourceLayout.PLAIN)) {
			if (createUiProject === source) {
				reportIssue(ERROR, '''
				'«createUiProject.text»' requires «SourceLayout.PLAIN» source layout.
				Please <a>select '«SourceLayout.PLAIN»'</a> source layout.''', [
					sourceLayout.select(SourceLayout.PLAIN)
				])
			} else {
				reportIssue(ERROR, '''
				«SourceLayout.MAVEN» source layout is not supported by the '«createUiProject.text»' project.
				Please <a>deselect '«createUiProject.text»'</a>.''', [
					createUiProject.selection = false
				])
			}
		}

		if (preferredBuildSystem.isSelected(BuildSystem.NONE) && sourceLayout.isSelected(SourceLayout.MAVEN)) {
			if (preferredBuildSystem === source) {
				reportIssue(ERROR, '''
				Maven/Gradle source layout is not supported without a build system.
				Please <a>select '«SourceLayout.PLAIN»'</a> source layout.''', [
					sourceLayout.select(SourceLayout.PLAIN)
				])
			} else {
				reportIssue(ERROR, '''
				Maven/Gradle source layout is only supported when using Maven or Gradle build system.
				You need to choose maven or gradle build system.
				Select <a>gradle</a> build.''', [
					preferredBuildSystem.select(BuildSystem.GRADLE)
				])
			}
		}

		if (createWebProject.selection && preferredBuildSystem.isSelected(BuildSystem.NONE)) {
			if (preferredBuildSystem === source) {
				reportIssue(ERROR, '''
				The '«createWebProject.text»' project can not be build without a build system.
				Please <a>deselect '«createWebProject.text»'</a>.''', [
					createWebProject.selection = false
				])
			} else {
				reportIssue(ERROR, '''
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
	}

	def protected select(Combo combo, Enum<?> enu) {
		combo.select(combo.items.indexed.findFirst[value == enu.toString].key)
	}

	def protected boolean isSelected(Combo combo, Enum<?> enu) {
		return enu.toString == combo.text
	}

	def protected <T extends Control> reportIssue(int severity, String text) {
		reportIssue(severity, text, [])
	}

	def protected <T extends Control> reportIssue(int severity, String text, ()=>void fix) {
		statusWidget.setStatus(severity, text, fix, [
			validate(null)
		])
	}

	def protected boolean isBundleResolved(String bundleId) {
		val bundle = Activator.instance.bundle.bundleContext.bundles.findFirst[bundleId == it.symbolicName]
		return bundle !== null && (bundle.state.bitwiseAnd(RESOLVED.bitwiseOr(STARTING).bitwiseOr(ACTIVE)) !== 0)
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
		createSDKProject.selection = false
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

	def boolean isCreateSdkProject() {
		createSDKProject.selection
	}

	def boolean isCreateP2Project() {
		createP2Project.selection
	}

	def BuildSystem getPreferredBuildSystem() {
		BuildSystem.values.get(preferredBuildSystem.selectionIndex)
	}

	def SourceLayout getSourceLayout() {
		SourceLayout.values.get(sourceLayout.selectionIndex)
	}

}