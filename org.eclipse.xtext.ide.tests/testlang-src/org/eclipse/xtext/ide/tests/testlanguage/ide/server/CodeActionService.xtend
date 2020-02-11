/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide.server

import com.google.inject.Inject
import org.eclipse.emf.common.util.ECollections
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.serializer.IEmfResourceChange
import org.eclipse.xtext.ide.serializer.ITextDocumentChange
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration
import org.eclipse.xtext.util.CollectionBasedAcceptor

import static org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeActionService implements ICodeActionService2 {

	@Inject IChangeSerializer serializer

	override getCodeActions(Options options) {
		val actions = newArrayList
		for (d : options.codeActionParams.context.diagnostics) {
			switch d.code {
				case INVALID_NAME: actions += Either.forLeft(d.fixInvalidName(options))
				case UNSORTED_MEMBERS: actions += Either.forRight(d.fixUnsortedMembers(options))
			}
		}
		return actions
	}

	def private Command fixInvalidName(Diagnostic d, Options options) {
		val string = options.document.getSubstring(d.range)
		return new Command => [
			command = 'my.textedit.command'
			title = '''Make '«string»' upper case'''
			arguments = #[
				new WorkspaceEdit => [
					changes.put(options.codeActionParams.textDocument.uri, #[new TextEdit => [
						newText = string.toFirstUpper
						range = d.range
					]])
				]
			]
		]
	}

	def private CodeAction fixUnsortedMembers(Diagnostic d, Options options) {
		val wsEdit = recordWorkspaceEdit(options) [ copiedResource |
			val model = copiedResource.contents.filter(Model).head
			for (type : model.elements.filter(TypeDeclaration)) {
				ECollections.sort(type.members, [a, b|a.name <=> b.name])
			}
		]
		return new CodeAction => [
			title = '''Sort Members'''
			diagnostics = #[d]
			edit = wsEdit
		]
	}

	def private WorkspaceEdit recordWorkspaceEdit(Options options, IChangeSerializer.IModification<Resource> mod) {
		val rs = options.languageServerAccess.newLiveScopeResourceSet(options.resource.URI)
		val copy = rs.getResource(options.resource.URI, true)
		serializer.addModification(copy, mod)
		val documentchanges = <IEmfResourceChange>newArrayList()
		serializer.applyModifications(CollectionBasedAcceptor.of(documentchanges))
		return new WorkspaceEdit => [
			for (documentchange : documentchanges.filter(ITextDocumentChange)) {
				val edits = documentchange.replacements.map [ replacement |
					new TextEdit => [
						newText = replacement.replacementText
						range = new Range(options.document.getPosition(replacement.offset), options.document.getPosition(replacement.endOffset))
					]
				]
				changes.put(documentchange.newURI.toString, edits)
			}
		]
	}

}
