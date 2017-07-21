/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.codeActions

import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.lsp4j.Command
import java.util.List

/**
 * @author Sven Efftinge - Initial contribution and API
 */
interface ICodeActionService {
	
	def List<? extends Command> getCodeActions(Document document, XtextResource resource, CodeActionParams params, CancelIndicator indicator)
	
}