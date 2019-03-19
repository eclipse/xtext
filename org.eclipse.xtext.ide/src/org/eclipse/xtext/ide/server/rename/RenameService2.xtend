/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
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
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2
import org.eclipse.xtext.ide.refactoring.RenameChange
import org.eclipse.xtext.ide.refactoring.RenameContext
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
@Accessors(PROTECTED_GETTER)
class RenameService2 implements IRenameService2 {
	
	@Inject extension EObjectAtOffsetHelper eObjectAtOffsetHelper
	
	@Inject Provider<ServerRefactoringIssueAcceptor> issueProvider
	
	@Inject IResourceServiceProvider.Registry serviceProviderRegistry

	@Inject TokenUtil tokenUtil
	
	override rename(ILanguageServerAccess access, RenameParams renameParams, CancelIndicator cancelIndicator) {
		val issueAcceptor = issueProvider.get
		access.doRead(renameParams.textDocument.uri) [ context |
			val workspaceEdit = new WorkspaceEdit
			val resourceSet = access.newLiveScopeResourceSet(context.resource.URI)
			val xtextResource = resourceSet.getResource(context.resource.URI, true)
			if (xtextResource instanceof XtextResource) {
				var EObject element;
				try {
					element = xtextResource.getElementAtOffset(context.document, renameParams.position)
				} catch (IndexOutOfBoundsException exc) {
					issueAcceptor.add(
						FATAL, '''Invalid document position line:«renameParams.position.line» column:«renameParams.position.character»'''
					)
				}
				if (issueAcceptor.maximumSeverity !== FATAL && element === null || element.eIsProxy) {
					issueAcceptor.add(
						FATAL, '''No element found at position line:«renameParams.position.line» column:«renameParams.position.character»''')
				} else {
					val services = serviceProviderRegistry.getResourceServiceProvider(element.eResource.URI)
					val changeSerializer = services.get(IChangeSerializer)
					val change = new RenameChange(renameParams.newName, EcoreUtil.getURI(element))
					val renameContext = new RenameContext(#[change], resourceSet, changeSerializer, issueAcceptor)
					val renameStrategy = services.get(IRenameStrategy2)
					renameStrategy.applyRename(renameContext)
					val converterFactory = services.get(ChangeConverter2.Factory)
					val changeConverter = converterFactory.create(workspaceEdit, access)
					changeSerializer.applyModifications(changeConverter)
				}
			} else {
				issueAcceptor.add(FATAL, 'Loaded resource is not an XtextResource', context.resource.URI)
			}
			return workspaceEdit
		].get
	}

	protected def EObject getElementAtOffset(XtextResource xtextResource, Document document, Position caretPosition) {
		val caretOffset = document.getOffSet(caretPosition)
		return xtextResource.getElementWithIdentifierAt(caretOffset) 
			?: xtextResource.getElementWithIdentifierAt(caretOffset - 1)
	}
	
	protected def getElementWithIdentifierAt(XtextResource xtextResource, int offset) {
		if (offset >= 0) {
			val rootNode = xtextResource?.parseResult?.rootNode
			if (rootNode !== null) {
				val leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset)
				if (leaf !== null && leaf.isIdentifier) {
					return xtextResource.resolveElementAt(offset)	
				}
			}
		}
		return null
	}
	
	protected def isIdentifier(ILeafNode leafNode) {
		return (leafNode.grammarElement instanceof RuleCall || leafNode.grammarElement instanceof CrossReference)
			&& !tokenUtil.isWhitespaceOrCommentNode(leafNode) 
	}
}
