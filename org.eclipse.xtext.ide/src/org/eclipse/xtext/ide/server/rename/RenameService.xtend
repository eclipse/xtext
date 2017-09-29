/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtext.ide.refactoring.IRenameStrategy
import org.eclipse.xtext.ide.refactoring.RenameChange
import org.eclipse.xtext.ide.refactoring.RenameContext
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class RenameService implements IRenameService {
	
	@Inject extension EObjectAtOffsetHelper
	
	@Inject IRenameStrategy renameStrategy 
	
	@Inject ChangeConverter.Factory converterFactory
	
	@Inject extension UriExtensions
	
	@Inject Provider<IChangeSerializer> changeSerializerProvider
	
	@Inject Provider<ServerRefactoringIssueAcceptor> issueProvider
	
	override rename(WorkspaceManager workspaceManager, RenameParams renameParams, CancelIndicator cancelIndicator) {
		val uri = renameParams.textDocument.uri.toUri
		val issueAcceptor = issueProvider.get
		workspaceManager.doRead(uri) [ document, resource | 
			val projectManager = workspaceManager.getProjectManager(uri)
			val resourceSet = projectManager.createNewResourceSet(projectManager.indexState.resourceDescriptions)
			val offset = document.getOffSet(renameParams.position)
			val workspaceEdit = new WorkspaceEdit
			val xtextResource = resourceSet.getResource(resource.URI, true)
			if (xtextResource instanceof XtextResource) {
				val element = xtextResource.resolveElementAt(offset)
				if (element === null)
					issueAcceptor.add(FATAL, '''No element found at position line:«renameParams.position.line» column:«renameParams.position.character»''')
				val change = new RenameChange(renameParams.newName, EcoreUtil.getURI(element))
				val changeSerializer = changeSerializerProvider.get
				val context = new RenameContext(#[change], resourceSet, changeSerializer, issueAcceptor)
				renameStrategy.applyRename(context)
				val changeConverter = converterFactory.create(workspaceManager, workspaceEdit)
				changeSerializer.applyModifications(changeConverter)
			} else {
				issueAcceptor.add(FATAL, 'Loaded resource is not an XtextResource', resource.URI)
			}
			return workspaceEdit
		]
	}
}