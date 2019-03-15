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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2
import org.eclipse.xtext.ide.refactoring.RenameChange
import org.eclipse.xtext.ide.refactoring.RenameContext
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.util.CancelIndicator

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Accessors(PROTECTED_GETTER)
class RenameService implements IRenameService, IRenameServiceExtension {
	
	@Inject extension EObjectAtOffsetHelper eObjectAtOffsetHelper
	
	@Inject IRenameStrategy2 renameStrategy 
	
	@Inject ChangeConverter.Factory converterFactory
	
	@Inject extension UriExtensions uriExtensions
	
	@Inject Provider<IChangeSerializer> changeSerializerProvider
	
	@Inject Provider<ServerRefactoringIssueAcceptor> issueProvider
	
	@Inject IResourceServiceProvider.Registry serviceProviderRegistry
	
	@Inject TokenUtil tokenUtil
	
	/**
	 * @deprecated use {@link #rename(WorkspaceManager, RenameParams, Options, CancelIndicator)} 
	 *    instead.
	 */
	@Deprecated
	override rename(WorkspaceManager workspaceManager, RenameParams renameParams, CancelIndicator cancelIndicator) {
		rename(workspaceManager, renameParams, new Options(false), cancelIndicator)
	}
	
	override rename(WorkspaceManager workspaceManager, RenameParams renameParams, Options options, CancelIndicator cancelIndicator) {
		val uri = renameParams.textDocument.uri.toUri
		val issueAcceptor = issueProvider.get
		workspaceManager.doRead(uri) [ document, resource |
			val projectManager = workspaceManager.getProjectManager(uri)
			val resourceSet = projectManager.createNewResourceSet(projectManager.indexState.resourceDescriptions)
			resourceSet.loadOptions.put(ResourceDescriptionsProvider.LIVE_SCOPE, true)
			val workspaceEdit = new WorkspaceEdit
			val xtextResource = resourceSet.getResource(resource.URI, true)
			if (xtextResource instanceof XtextResource) {
				val element = xtextResource.getElementAtOffset(document, renameParams.position)
				if (element === null || element.eIsProxy) {
					issueAcceptor.add(
						FATAL, '''No element found at position line:«renameParams.position.line» column:«renameParams.position.character»''')
				} else {
					val services = serviceProviderRegistry.getResourceServiceProvider(element.eResource.URI)
					val changeSerializer = services.get(IChangeSerializer)
					val change = new RenameChange(renameParams.newName, EcoreUtil.getURI(element))
					val context = new RenameContext(#[change], resourceSet, changeSerializer, issueAcceptor)
					val renameStrategy = services.get(IRenameStrategy2)
					renameStrategy.applyRename(context)
					val converterFactory = services.get(ChangeConverter.Factory)
					val changeConverter = converterFactory.create(workspaceManager, workspaceEdit, options)
					changeSerializer.applyModifications(changeConverter)
				}
			} else {
				issueAcceptor.add(FATAL, 'Loaded resource is not an XtextResource', resource.URI)
			}
			return workspaceEdit
		]
	}

	protected def EObject getElementAtOffset(XtextResource xtextResource, Document document, Position caretPosition) {
		val caretOffset = document.getOffSet(caretPosition)
		val leafNode = NodeModelUtils.findLeafNodeAtOffset(xtextResource.parseResult.rootNode, caretOffset)
		val offset = if (caretOffset === xtextResource.parseResult.rootNode.endOffset && caretOffset > 0 && leafNode.offset === caretOffset && !isIdentifier(leafNode)) 
				caretOffset - 1
			else 
				caretOffset
		return xtextResource.resolveElementAt(offset)
	}
	
	protected def isIdentifier(ILeafNode leafNode) {
		return leafNode.grammarElement instanceof TerminalRule
			&& !tokenUtil.isWhitespaceOrCommentNode(leafNode) 
	}
}