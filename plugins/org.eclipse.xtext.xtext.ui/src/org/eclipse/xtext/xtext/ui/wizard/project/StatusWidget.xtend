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
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Link
import static org.eclipse.jface.dialogs.IMessageProvider.NONE

/**
 * @author dhuebner - Initial contribution and API
 */
class StatusWidget extends Composite {
	Link link
	Label imageLabel
	()=>void quickFix = []

	int severity = NONE

	new(Composite parent, int style) {
		super(parent, style)
		createControls()
		visible = false
	}

	def protected createControls() {
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
		setStatus(NONE, '   ', [], [])
	}

	def setStatus(int severity, String text, ()=>void quickFix, ()=>void callback) {
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