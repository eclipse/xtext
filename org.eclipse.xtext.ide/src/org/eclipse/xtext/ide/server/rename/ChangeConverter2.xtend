/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import com.google.inject.Inject
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentEdit
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.serializer.IEmfResourceChange
import org.eclipse.xtext.ide.serializer.ITextDocumentChange
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.IAcceptor

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
class ChangeConverter2 implements IAcceptor<IEmfResourceChange> {

	static class Factory {

		@Inject protected IResourceServiceProvider.Registry registry
		@Inject protected UriExtensions uriExtensions

		/**
		 * @since 2.18
		 */
		def ChangeConverter2 create(WorkspaceEdit edit, ILanguageServerAccess access) {
			new ChangeConverter2(registry, edit, access, uriExtensions)
		}
	}

	val IResourceServiceProvider.Registry registry
	val extension UriExtensions uriExtensions
	val WorkspaceEdit edit
	val ILanguageServerAccess access
	val boolean useDocumentChanges
	
	protected new(IResourceServiceProvider.Registry registry, WorkspaceEdit edit, ILanguageServerAccess access, UriExtensions uriExtensions) {
		this.registry = registry
		this.uriExtensions = uriExtensions
		this.edit = edit
		this.access = access
		this.useDocumentChanges = access?.initializeParams?.capabilities?.workspace?.workspaceEdit?.documentChanges === Boolean.TRUE
		if (useDocumentChanges)
			this.edit.documentChanges = newArrayList 
		else
			this.edit.changes = newLinkedHashMap
	}

	override accept(IEmfResourceChange change) {
		handleReplacements(change)
	}

	protected def dispatch void handleReplacements(IEmfResourceChange change) {
		val outputStream = new ByteArrayOutputStream
		val uri = change.resource.URI.toUriString
		change.resource.save(outputStream, null)
		val newContent = new String(outputStream.toByteArray, change.resource.charset)
		access.doRead(uri) [ context |
			val document = context.document
			val range = new Range(document.getPosition(0), document.getPosition(document.contents.length))
			val textEdit = new TextEdit(range, newContent)
			addTextEdit(uri, document, textEdit)
		].get
	}

	protected def String getCharset(Resource resource) {
		val xtextEncodingProvider = registry.getResourceServiceProvider(resource.URI).get(IEncodingProvider)
		if (xtextEncodingProvider !== null)
			return xtextEncodingProvider.getEncoding(resource.URI)
		else if (resource instanceof XMLResource)
			resource.encoding
		else
			Charset.defaultCharset.toString
	}

	protected def dispatch void handleReplacements(ITextDocumentChange change) {
		if (change.replacements.size > 0) {
			val uri = change.newURI.toUriString
			access.doRead(uri) [ context |
				val document = context.document
				val textEdits = change.replacements.map [ replacement |
					val start = document.getPosition(replacement.offset)
					val end = document.getPosition(replacement.offset + replacement.length)
					val range = new Range(start, end)
					new TextEdit(range, replacement.replacementText)
				]
				addTextEdit(uri, document, textEdits)
			].get
		}
	}
	
	protected def addTextEdit(String theUri, Document document, TextEdit... textEdits) {
		if (useDocumentChanges) {
			edit.documentChanges +=  
				Either.forLeft(new TextDocumentEdit => [
					textDocument = new VersionedTextDocumentIdentifier => [
						uri = theUri
						version = document.version
					]
					edits = textEdits
				])			
		} else {
			edit.changes.put(theUri, textEdits)
		}
	}
	
}
