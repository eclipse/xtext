/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 * @deprectated implement IRenameService2 instead.
 */
@Deprecated
interface IRenameService {
	def WorkspaceEdit rename(WorkspaceManager workspaceManager, RenameParams renameParams, CancelIndicator cancelIndicator) 
}

/**
 * The implementation of rename refactoring for a language.
 * 
 * As opposed to {@link IRenameService} this returns {@link TextDocumentChanges} if the 
 * client supports versioned documents.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.17
 */
interface IRenameServiceExtension {
	def WorkspaceEdit rename(WorkspaceManager workspaceManager, RenameParams renameParams, Options options, CancelIndicator cancelIndicator)

	@Data
	class Options {
		boolean clientSupportsVerisonedDocuments
	}
}