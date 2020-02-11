/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import com.google.common.base.Function
import com.google.common.base.Throwables
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.FileNotFoundException
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.PrepareRenameResult
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
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
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.util.internal.Log

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*

import static extension org.eclipse.lsp4j.util.Ranges.*

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
@Log
@Accessors(PROTECTED_GETTER)
class RenameService2 implements IRenameService2 {

	@Inject extension EObjectAtOffsetHelper eObjectAtOffsetHelper

	@Inject Provider<ServerRefactoringIssueAcceptor> issueProvider

	@Inject IResourceServiceProvider.Registry serviceProviderRegistry

	@Inject TokenUtil tokenUtil

	Function<EObject, String> attributeResolver = SimpleAttributeResolver.newResolver(String, 'name')

	override rename(Options options) {
		val textDocument = options.renameParams.textDocument
		val uri = textDocument.uri
		val issueAcceptor = issueProvider.get
		val shouldPrepareRename = options.languageServerAccess.shouldPrepareRename
		return options.languageServerAccess.doRead(uri) [ context |

			if (shouldPrepareRename) {
				val identifier = new TextDocumentIdentifier(textDocument.uri)
				val position = options.renameParams.position
				val positionParams = new TextDocumentPositionParams(identifier, position)
				val resource = context.resource
				val document = context.document
				val cancelIndicator = options.cancelIndicator

				val prepareRenameResult = doPrepareRename(resource, document, positionParams, cancelIndicator)
				if (!mayPerformRename(prepareRenameResult, options.renameParams)) {
					return null
				}
			}

			val workspaceEdit = new WorkspaceEdit
			val resourceSet = options.languageServerAccess.newLiveScopeResourceSet(context.resource.URI)
			val xtextResource = resourceSet.getResource(context.resource.URI, true)
			if (xtextResource instanceof XtextResource) {
				val position = options.renameParams.position
				var EObject element
				try {
					element = xtextResource.getElementAtOffset(context.document, position)
				} catch (IndexOutOfBoundsException exc) {
					issueAcceptor.add(FATAL, '''Invalid document «position.toPositionFragment(uri)»''')
				}
				if (element === null || element.eIsProxy) {
					issueAcceptor.add(FATAL, '''No element found at «position.toPositionFragment(uri)»''')
				} else {
					val services = serviceProviderRegistry.getResourceServiceProvider(element.eResource.URI)
					val changeSerializer = services.get(IChangeSerializer)
					val change = new RenameChange(options.renameParams.newName, EcoreUtil.getURI(element))
					val renameContext = new RenameContext(#[change], resourceSet, changeSerializer, issueAcceptor)
					val renameStrategy = services.get(IRenameStrategy2)
					renameStrategy.applyRename(renameContext)
					val converterFactory = services.get(ChangeConverter2.Factory)
					val changeConverter = converterFactory.create(workspaceEdit, options.languageServerAccess)
					changeSerializer.applyModifications(changeConverter)
				}
			} else {
				issueAcceptor.add(FATAL, 'Loaded resource is not an XtextResource', context.resource.URI)
			}
			issueAcceptor.checkSeverity
			return workspaceEdit
		].exceptionally [ exception |
			val rootCause = Throwables.getRootCause(exception)
			if (rootCause instanceof FileNotFoundException) {
				if (shouldPrepareRename) {
					return null
				}
			}
			throw exception
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

	override prepareRename(PrepareRenameOptions options) {
		val uri = options.params.textDocument.uri
		val shouldPrepareRename = options.languageServerAccess.shouldPrepareRename
		return options.languageServerAccess.doRead(uri) [ context |
			// We check `shouldPrepareRename` here instead of before the `doRead`
			// because we still have to propagate the error if the resource is missing.
			if (!shouldPrepareRename) {
				return null
			}
			val resource = context.resource
			val document = context.document
			val params = options.params
			val cancelIndicator = options.cancelIndicator
			return doPrepareRename(resource, document, params, cancelIndicator)
		].exceptionally [ exception |
			val rootCause = Throwables.getRootCause(exception)
			if (rootCause instanceof FileNotFoundException) {
				if (shouldPrepareRename) {
					return null
				}
			}
			throw exception
		].get
	}

	protected def Either<Range, PrepareRenameResult> doPrepareRename(Resource resource, Document document,
		TextDocumentPositionParams params, CancelIndicator cancelIndicator) {

		val uri = params.textDocument.uri
		if (resource instanceof XtextResource) {
			val rootNode = resource?.parseResult?.rootNode
			if (rootNode === null) {
				LOG.trace('''Could not retrieve root node for resource. URI: «uri».''')
				return null
			}
			val caretPosition = params.position
			try {
				val caretOffset = document.getOffSet(caretPosition)
				var EObject element
				var candidateOffset = caretOffset
				do {
					element = resource.getElementWithIdentifierAt(candidateOffset)
					if (element !== null && !element.eIsProxy) {
						val leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, candidateOffset)
						if (leaf !== null && leaf.isIdentifier) {
							val leafText = NodeModelUtils.getTokenText(leaf)
							val elementName = element.elementName
							if (!leafText.nullOrEmpty && !elementName.nullOrEmpty && leafText == elementName) {
								val start = document.getPosition(leaf.offset)
								val end = document.getPosition(leaf.offset + elementName.length)
								return Either.forLeft(new Range(start, end))
							}
						}
					}
					candidateOffset = candidateOffset - 1
				} while (candidateOffset >= 0 && candidateOffset + 1 >= caretOffset)
			} catch (IndexOutOfBoundsException e) {
				LOG.trace('''Invalid document «caretPosition.toPositionFragment(uri)»''')
				return null
			}
			LOG.trace('''No element found at «caretPosition.toPositionFragment(uri)»''')
		} else {
			LOG.trace('''Loaded resource is not an XtextResource. URI: «resource.URI»''')
		}
		return null
	}

	/**
	 * If this method returns {@code false}, it is sure, that the rename operation will fail.
	 * There is no guarantee that it will succeed even if it returns {@code true}.
	 */
	protected def boolean mayPerformRename(Either<Range, PrepareRenameResult> prepareRenameResult,
		RenameParams renameParams) {

		return prepareRenameResult !== null && prepareRenameResult.getLeft !== null &&
			prepareRenameResult.getLeft.containsPosition(renameParams.position)
	}

	/**
	 * Tries to read the {@code name} {@link EAttribute} from the
	 * the given {@code element}.
	 *
	 * It never returns an empty string, but a {@code null} instead.
	 */
	protected def getElementName(EObject element) {
		if (element === null) {
			return null
		}
		val name = attributeResolver.apply(element)
		return if(Strings.isEmpty(name)) null else name
	}

	private def toPositionFragment(Position it, String uri) {
		return '''position line: «line» column: «character» in resource: «uri»'''
	}

	private def shouldPrepareRename(ILanguageServerAccess access) {
		val provider = access?.initializeResult?.capabilities?.renameProvider
		return if(provider !== null && provider.isRight) Boolean.TRUE == provider.getRight.prepareProvider else false
	}

}
