/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide.server

import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService
import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeActionService implements ICodeActionService {
	
	override getCodeActions(Document document, XtextResource resource, CodeActionParams params, CancelIndicator indicator) {
		val commands = <Command>newArrayList
		for (d : params.context.diagnostics) {
			if (d.code == TestLanguageValidator.INVALID_NAME) {
				val string = document.getSubstring(d.range) 
				commands += new Command => [
					command = 'my.textedit.command'
					title = '''Make '«string»' upper case'''
					arguments = #[
						new WorkspaceEdit => [
							changes.put(params.textDocument.uri, #[new TextEdit => [
								newText = string.toFirstUpper
								range = d.range
							]])
						]
					]
				]
			}
		}
		return commands
	}
	
}