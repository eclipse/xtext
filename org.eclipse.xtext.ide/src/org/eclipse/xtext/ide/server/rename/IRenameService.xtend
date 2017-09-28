/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import com.google.inject.ImplementedBy
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(RenameService)
interface IRenameService {
	def WorkspaceEdit rename(WorkspaceManager workspaceManager, RenameParams renameParams, CancelIndicator cancelIndicator) 
}