/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.util

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.MacroAwareTextBrowseFolderListener
import com.intellij.ui.SeparatorWithText

/**
 * @author dhuebner - Initial contribution and API
 */
class IdeaWidgetFactory {
	static def TextFieldWithBrowseButton createBrowseField(Project project) {
		val field = new TextFieldWithBrowseButton()
		field.addBrowseFolderListener(
			new MacroAwareTextBrowseFolderListener(FileChooserDescriptorFactory.createSingleFolderDescriptor(),
				project))
			return field
		}

		static def SeparatorWithText createTitledSeparator(String title) {
			val separator = new SeparatorWithText() => [
				caption = title
				captionCentered = false
			]
			return separator
		}
	}