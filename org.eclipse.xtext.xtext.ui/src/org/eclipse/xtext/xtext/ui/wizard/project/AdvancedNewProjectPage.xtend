/*******************************************************************************
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xtext.wizard.LanguageServer
import org.eclipse.xtext.xtext.wizard.SourceLayout

import static org.eclipse.xtext.xtext.ui.wizard.project.Messages.*
import static org.osgi.framework.Bundle.*
import org.eclipse.xtext.util.JUnitVersion
import org.eclipse.swt.widgets.Label

class AdvancedNewProjectPage extends WizardPage {

	Button createUiProject
	Button createSDKProject
	Button createP2Project
	Button createWebProject
	Button createIdeProject
	Button createTestProject
	Button junitVersion4
	Button junitVersion5
	Combo preferredBuildSystem
	Combo createLanguageServer
	Combo sourceLayout
	Group createUiProjectSubGroup

	StatusWidget statusWidget
	
	boolean autoSelectIdeProject
	boolean autoSelectSDKProject

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
				text = Messages.AdvancedNewProjectPage_LabelFacets
				createUiProject = CheckBox [
					text = AdvancedNewProjectPage_projEclipse
				]
				createUiProjectSubGroup = Group [
					createSDKProject = CheckBox [
						text = AdvancedNewProjectPage_projEclipseSDKFeature
					]
					createP2Project = CheckBox [
						text = AdvancedNewProjectPage_projEclipseP2
					]
				]
				createWebProject = CheckBox [
					text = AdvancedNewProjectPage_projWeb
					enabled = true
				]
				createIdeProject = CheckBox [
					text = AdvancedNewProjectPage_projIde
					enabled = false
					it.InfoDecoration(AdvancedNewProjectPage_projIde_description)
					layoutData = new GridData(SWT.LEFT, SWT.CENTER, true, false)
				]
				new Composite(it, SWT.NONE) => [
					layout = new GridLayout(4, false) => [
						marginWidth = 0
						marginHeight = 0
					]
					createTestProject = CheckBox [
						text = Messages.WizardNewXtextProjectCreationPage_TestingSupport
						layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
					]
					new Label(it, SWT.LEFT) => [
						text = AdvancedNewProjectPage_junitVersion
					]
					junitVersion4 = Radio [
						layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
						text = "4"
						selection = true
					]
					junitVersion5 = Radio [
						layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
						text = "5"
					]
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
				text = AdvancedNewProjectPage_languageServer
				createLanguageServer = DropDown[
					enabled = false
					items = LanguageServer.values.map[toString]
					it.InfoDecoration(AdvancedNewProjectPage_languageServer_description)
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
		val uiButtons = #[createUiProject,createWebProject]
		val selectionControlUi = new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				if ((e.source as Button).selection) {
					if (!createIdeProject.selection) {
						autoSelectIdeProject = true
					}
					createIdeProject.selection = true
					createIdeProject.enabled = false
				} else {
					if (uiButtons.forall[!selection]) {
						createIdeProject.enabled = true
					}
					// auto deselect SDK and p2 project when Eclipse plug-in is deselected
					if (e.source == createUiProject) {
						createSDKProject.selection = false
						createP2Project.selection = false
					}
				}
				validate(e)
			}
		}
		val selectionControlUpdateSite = new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				if ((e.source as Button).selection) {
					if (!createSDKProject.selection) {
						autoSelectSDKProject = true
					}
					createSDKProject.selection = true
					createSDKProject.enabled = false
				} else {
					createSDKProject.enabled = true
				}
				validate(e)
			}
		}

		createUiProject.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				val uiProjectSelected = createUiProject.selection
				createUiProjectSubGroup.enabled = uiProjectSelected
				createSDKProject.enabled = uiProjectSelected
				createP2Project.enabled = uiProjectSelected
				validate(e)
			}
		})
		preferredBuildSystem.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				val boolean lsEnabled = (getPreferredBuildSystem!=BuildSystem.NONE)
				createLanguageServer.enabled = lsEnabled
				validate(e)
			}
		})
		createLanguageServer.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				if (createLanguageServer.isSelected(LanguageServer.NONE)) {
					if (uiButtons.forall[!selection]) {
						createIdeProject.enabled = true
					}
				} else {
					if (!createIdeProject.selection) {
						createIdeProject.selection = true
						autoSelectIdeProject = true
					}
				}
				validate(e)
			}
		})
		createTestProject.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent e) {
				val enabled = createTestProject.selection==true
				junitVersion4.enabled = enabled
				junitVersion5.enabled = enabled
				validate(e)
			}
		})
		
		sourceLayout.addSelectionListener(selectionControl)
		createUiProject.addSelectionListener(selectionControlUi)
		createWebProject.addSelectionListener(selectionControlUi)
		createIdeProject.addSelectionListener(selectionControl)
		createSDKProject.addSelectionListener(selectionControl)
		createP2Project.addSelectionListener(selectionControlUpdateSite)
		createLanguageServer.addSelectionListener(selectionControl)
		setDefaults

		PlatformUI.getWorkbench().getHelpSystem().setHelp(shell, "org.eclipse.xtext.xtext.ui.newProject_Advanced")
	}

	def void validate(SelectionEvent e) {
		statusWidget.clearStatus
		checkWidgets(e)
		pageComplete = statusWidget.severtity !== ERROR
	}

	def checkWidgets(SelectionEvent e) {
		val uiButtons = #[createUiProject,createWebProject]
		
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
		if (createUiProject.selection && createP2Project.selection && !createSDKProject.selection) {
			addIssue(INFORMATION,
				AdvancedNewProjectPage_p2AndSdkInfo)
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
				You need to choose Maven or Gradle build system.
				Select <a>Gradle</a> build.''', [
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
				To build the '«createWebProject.text»' project, you need to choose Maven or Gradle build system.
				Select <a>Gradle</a> build.''', [
					preferredBuildSystem.select(BuildSystem.GRADLE)
				])
			}
		}
		
		if (uiButtons.exists[selection]) {
			createIdeProject.enabled = false
		}

		if (autoSelectIdeProject) {
			autoSelectIdeProject = false
			reportIssue(INFORMATION, ''''«createIdeProject.text»' project was automatically selected as option '«(source as Button).text»' requires it.''')
		}
		if (autoSelectSDKProject) {
			autoSelectSDKProject = false
			reportIssue(INFORMATION, ''''«createSDKProject.text»' was automatically selected as option '«(source as Button).text»' requires it.''')
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

	def protected <T extends Control> addIssue(int severity, String text) {
		statusWidget.addStatus(severity, text)
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

	def protected Radio(Composite composite, (Button)=>void config) {
		new Button(composite, SWT.RADIO) => [
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
	
	def protected InfoDecoration(Control control, String text) {
		val infoField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION)
		new ControlDecoration(control, SWT.TOP + SWT.RIGHT) => [
			image = infoField.image
			descriptionText = text
			showHover = true
		]
	}

	def protected setDefaults() {
		createUiProject.selection = true
		createIdeProject.selection = true
		createTestProject.selection = true
		createWebProject.selection = false
		createSDKProject.selection = false
		createP2Project.selection = false
		preferredBuildSystem.select(BuildSystem.values.head)
		createLanguageServer.select(LanguageServer.values.head)
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

	def boolean isCreateWebProject() {
		createWebProject.selection
	}

	def boolean isCreateSdkProject() {
		createUiProject.selection && createSDKProject.selection
	}

	def boolean isCreateP2Project() {
		createUiProject.selection && createP2Project.selection
	}

	def BuildSystem getPreferredBuildSystem() {
		BuildSystem.values.get(preferredBuildSystem.selectionIndex)
	}

	def SourceLayout getSourceLayout() {
		SourceLayout.values.get(sourceLayout.selectionIndex)
	}
	
	def LanguageServer getLanguageServer () {
		if (getPreferredBuildSystem==BuildSystem.NONE)
			return LanguageServer.NONE
		LanguageServer.values.get(createLanguageServer.selectionIndex)
	}
	
	def JUnitVersion getSelectedJUnitVersion () {
		if (junitVersion4.selection) {
			return JUnitVersion.JUNIT_4;
		} else if (junitVersion5.selection) {
			return JUnitVersion.JUNIT_5;
		} else {
			throw new IllegalStateException
		}
	}

}