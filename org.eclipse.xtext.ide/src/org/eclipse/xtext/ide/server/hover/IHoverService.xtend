/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.hover

import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import com.google.inject.ImplementedBy

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(HoverService)
interface IHoverService {

	public static val EMPTY_HOVER = new Hover(emptyList, null)

	/**
	 * callback for 'textDocument/hover' requests.
	 */
	def Hover hover(Document document, XtextResource resource, TextDocumentPositionParams params, CancelIndicator cancelIndicator);
}
