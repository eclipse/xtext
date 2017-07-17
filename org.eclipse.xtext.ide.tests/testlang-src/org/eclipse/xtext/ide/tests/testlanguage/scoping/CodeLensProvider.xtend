/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.scoping

import org.eclipse.xtext.ide.server.codelens.ICodeLensService
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.lsp4j.CodeLensParams
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.lsp4j.CodeLens
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.Position

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeLensProvider implements ICodeLensService, ICodeLensResolver {
	
	override computeCodeLenses(Document document, XtextResource resource, CodeLensParams params, CancelIndicator indicator) {
		return #[new CodeLens() => [
			command = new Command() => [
				command = "do.this"
				title = "Do Awesome Stuff"
				arguments = #[
					'foo',
					1,
					true
				]
			]
			data = new Position(1,2)
		]]
	}
	
	override resolveCodeLens(Document document, XtextResource resource, CodeLens codeLens, CancelIndicator indicator) {
		codeLens.command.title = codeLens.command.title + "(RESOLVED)" 
		return codeLens
	}
	
}