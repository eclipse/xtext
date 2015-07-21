/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.quickfix

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sven Efftinge - Initial contribution and API
 */
abstract class AbstractIssueIntentionAction implements IntentionAction {
	
	@Accessors Issue issue
	
	override getFamilyName() {
		getText()
	}
	
	override isAvailable(Project project, Editor editor, PsiFile file) {
		true
	}
	
	override startInWriteAction() {
		true
	}
	
}