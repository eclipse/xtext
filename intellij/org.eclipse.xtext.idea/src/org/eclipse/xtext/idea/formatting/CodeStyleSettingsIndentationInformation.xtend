/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.intellij.formatting.IndentInfo
import com.intellij.psi.codeStyle.CodeStyleSettingsManager
import org.eclipse.xtext.formatting.IIndentationInformation

import static extension org.eclipse.xtext.idea.actionSystem.DataContextExtensions.*

/**
 * @author kosyakov - Initial contribution and API
 */
class CodeStyleSettingsIndentationInformation implements IIndentationInformation {

	override getIndentString() {
		val project = dataContext.project
		val indentOptions = CodeStyleSettingsManager.getSettings(project).indentOptions
		val indentInfo = new IndentInfo(0, 4, 0)
		indentInfo.generateNewWhiteSpace(indentOptions)
	}

}