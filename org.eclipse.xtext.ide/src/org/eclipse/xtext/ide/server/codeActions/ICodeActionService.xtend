/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.codeActions

import java.util.List
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 * @deprecated use {@link ICodeActionService2} instead
 */
@Deprecated
interface ICodeActionService {
	
	def List<Either<Command, CodeAction>> getCodeActions(Document document, XtextResource resource, CodeActionParams params, CancelIndicator indicator)
		
}

/**
 * @author Jan Koehnlein
 * @since 2.18
 */
 interface ICodeActionService2 {
	
	def List<Either<Command, CodeAction>> getCodeActions(Options options)
		
	@Accessors
	class Options {
		Document document
		XtextResource resource
		ILanguageServerAccess languageServerAccess
		CodeActionParams codeActionParams
		CancelIndicator cancelIndicator
	}
}
 