/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project

import java.util.regex.Pattern
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Link
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

	StatusWidget statusWidget

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
				].decorate(INFORMATION, "Info about Generic IDE Support")

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
				layoutData = new GridData(SWT.FILL, SWT.BOTTOM, true, true)
			]
		]

		val selectionControl = new SelectionListener() {
			override widgetSelected(SelectionEvent e) {
				validate(e)
			}

			override widgetDefaultSelected(SelectionEvent e) {
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
		checkWidgets(e)
		pageComplete = statusWidget.severtity !== ERROR
	}

	def checkWidgets(SelectionEvent e) {
		val source = e?.source
		if (createUiProject.selection && sourceLayout.selectionIndex != 0) {
			if (createUiProject === source) {
				reportIssue(ERROR, '''
				'«createUiProject.text»' requier Flat source layout.
				Please <a>select 'Flat'</a> source layout.''', [
					sourceLayout.select(0)
				])
			} else {
				reportIssue(ERROR, '''
				Flat source layout is not supported bei the '«createUiProject.text»' project.
				Please <a>deselect '«createUiProject.text»'</a>.''', [
					createUiProject.selection = false
				])
			}
		}

		if (createWebProject.selection && preferredBuildSystem.selectionIndex == 0) {
			if (preferredBuildSystem === source) {
				reportIssue(ERROR, '''
				The '«createWebProject.text»' project can not be build using Eclipse-PDE build.
				Please <a>deselect '«createWebProject.text»'</a>.''', [
					createWebProject.selection = false
				])
			} else {
				reportIssue(WARNING, '''
				To build the '«createWebProject.text»' project, you need to choose maven or gradle build system.
				Select <a>maven</a> build.''', [
					preferredBuildSystem.select(1)
				])
			}
		}

		val dependend = #[createUiProject, createIdeaProject, createWebProject]
		if (!createIdeProject.selection && dependend.exists[selection]) {
			val affectedProjects = dependend.filter[selection].join(', ', [text])
			if (createIdeProject === source) {
				reportIssue(ERROR, '''
				Projects like '«affectedProjects»' depends on '«createIdeProject.text»' project.
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

	def protected <T extends Control> reportIssue(int severity, String text, ()=>void fix) {
		statusWidget.addMessage(severity, text, fix, [validate(null)])
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

	static class StatusWidget extends Composite {
		Link link
		Label imageLabel
		()=>void quickFix = []

		int severity = NONE

		new(Composite parent, int style) {
			super(parent, style)
			createControls()
			visible = false
		}

		def createControls() {
			layout = new GridLayout(2, false)
			imageLabel = new Label(this, SWT.NONE)
			imageLabel.text = "   "
			imageLabel.layoutData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING)
			link = new Link(this, SWT.NONE)
			link.layoutData = new GridData(GridData.FILL_HORIZONTAL)
			link.setFont(this.getFont())
			link.text = '\n\n\n'
			link.addSelectionListener(new SelectionAdapter() {
				override widgetSelected(SelectionEvent e) {
					super.widgetSelected(e)
					quickFix.apply
				}
			})
		}

		def clearStatus() {
			addMessage(NONE, '   ', [], [])
		}

		def addMessage(int severity, String text, ()=>void quickFix, ()=>void callback) {
			visible = severity !== NONE
			imageLabel.image = imageFor(severity)
			link.text = text
			val matcher = Pattern.compile('<a>(.*)</a>').matcher(text)
			link.toolTipText = matcher.replaceAll('$1')
			this.quickFix = [quickFix.apply callback.apply]
			this.severity = severity
		}

		def getSevertity() {
			severity
		}

		def private Image imageFor(int type) {
			switch (type) {
				case IMessageProvider.NONE: {
					null
				}
				case IMessageProvider.INFORMATION: {
					JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_INFO)
				}
				case IMessageProvider.WARNING: {
					JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_WARNING);
				}
				case IMessageProvider.ERROR: {
					JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_ERROR);
				}
			}
		}

	}

}