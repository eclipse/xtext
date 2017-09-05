/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide.server

import com.google.inject.Inject
import org.eclipse.emf.common.util.ECollections
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.serializer.ITextDocumentChange
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.CollectionBasedAcceptor
import org.eclipse.xtext.util.StringInputStream

import static org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator.*
import org.eclipse.xtext.ide.serializer.IEmfResourceChange

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeActionService implements ICodeActionService {

	@Inject IChangeSerializer serializer

	override getCodeActions(Document document, XtextResource resource, CodeActionParams params,
		CancelIndicator indicator) {
		val commands = <Command>newArrayList
		for (d : params.context.diagnostics) {
			switch d.code {
				case INVALID_NAME: commands += d.fixInvalidName(document, resource, params)
				case UNSORTED_MEMBERS: commands += d.fixUnsortedMembers(document, resource, params)
			}
		}
		return commands
	}

	def private Command fixInvalidName(Diagnostic d, Document doc, XtextResource res, CodeActionParams params) {
		val string = doc.getSubstring(d.range)
		return new Command => [
			command = 'my.textedit.command'
			title = '''Make '«string»' upper case'''
			arguments = #[
				new WorkspaceEdit => [
					changes.put(params.textDocument.uri, #[new TextEdit => [
						newText = string.toFirstUpper
						range = d.range
					]])
				]
			]
		]
	}

	def private Command fixUnsortedMembers(Diagnostic d, Document doc, XtextResource res, CodeActionParams params) {
		val edit = recordWorkspaceEdit(doc, res) [ copiedResource |
			val model = copiedResource.contents.filter(Model).head
			for (type : model.types) {
				ECollections.sort(type.members, [a, b|a.name <=> b.name])
			}
		]
		return new Command => [
			command = 'my.textedit.command'
			title = '''Sort Members'''
			arguments = #[edit]
		]
	}

	def private WorkspaceEdit recordWorkspaceEdit(Document doc, XtextResource resource, (XtextResource)=>void mod) {
		val rs = new XtextResourceSet()
		val copy = rs.createResource(resource.URI)
		copy.load(new StringInputStream(resource.parseResult.rootNode.text), emptyMap)
		serializer.beginRecordChanges(copy)
		mod.apply(copy as XtextResource)
		val documentchanges = <IEmfResourceChange>newArrayList()
		serializer.endRecordChanges(CollectionBasedAcceptor.of(documentchanges))
		return new WorkspaceEdit => [
			for (documentchange : documentchanges.filter(ITextDocumentChange)) {
				val edits = documentchange.replacements.map [ replacement |
					new TextEdit => [
						newText = replacement.replacementText
						range = new Range(doc.getPosition(replacement.offset), doc.getPosition(replacement.endOffset))
					]
				]
				changes.put(documentchange.newURI.toString, edits)
			}
		]
	}

}
