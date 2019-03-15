/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import com.google.inject.Inject
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import org.eclipse.emf.common.util.URI
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
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.IAcceptor

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class ChangeConverter implements IAcceptor<IEmfResourceChange> {

	static class Factory {

		@Inject protected IResourceServiceProvider.Registry registry

		/**
		 * @deprecated use {@link #create(WorkspaceManager, WorkspaceEdit, boolean} instead.
		 */
		@Deprecated
		def ChangeConverter create(WorkspaceManager workspaceManager, WorkspaceEdit edit) {
			new ChangeConverter(workspaceManager, registry, edit, null)
		}

		/**
		 * @since 2.18
		 */
		def ChangeConverter create(WorkspaceManager workspaceManager, WorkspaceEdit edit, IRenameServiceExtension.Options options) {
			new ChangeConverter(workspaceManager, registry, edit, options)
		}
	}

	val WorkspaceManager workspaceManager
	val IResourceServiceProvider.Registry registry
	val WorkspaceEdit edit
	val IRenameServiceExtension.Options options
	
	protected new(WorkspaceManager workspaceManager, IResourceServiceProvider.Registry registry, WorkspaceEdit edit, IRenameServiceExtension.Options options) {
		this.workspaceManager = workspaceManager
		this.registry = registry
		this.edit = edit
		this.options = options
		if (options?.clientSupportsVersionedDocuments)
			this.edit.documentChanges = newArrayList 
		else
			this.edit.changes = newLinkedHashMap
	}

	override accept(IEmfResourceChange change) {
		handleReplacements(change)
	}

	protected def dispatch void handleReplacements(IEmfResourceChange change) {
		val outputStream = new ByteArrayOutputStream
		try {
			val uri = change.resource.URI
			change.resource.save(outputStream, null)
			val newContent = new String(outputStream.toByteArray, change.resource.charset)
			workspaceManager.doRead(uri) [ document, resource |
				val range = new Range(document.getPosition(0), document.getPosition(document.contents.length))
				val textEdit = new TextEdit(range, newContent)
				addTextEdit(uri, document, textEdit)
			]
		} finally {
			outputStream.close
		}
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
			val uri = change.newURI
			workspaceManager.doRead(uri) [ document, resource |
				val textEdits = change.replacements.map [ replacement |
					val start = document.getPosition(replacement.offset)
					val end = document.getPosition(replacement.offset + replacement.length)
					val range = new Range(start, end)
					new TextEdit(range, replacement.replacementText)
				]
				addTextEdit(uri, document, textEdits)
			]
		}
	}
	
	protected def addTextEdit(URI theUri, Document document, TextEdit... textEdits) {
		if (options?.clientSupportsVersionedDocuments) {
			edit.documentChanges +=  
				Either.forLeft(new TextDocumentEdit => [
					textDocument = new VersionedTextDocumentIdentifier => [
						uri = theUri.toString
						version = document.version
					]
					edits = textEdits
				])			
		} else {
			edit.changes.put(theUri.toString, textEdits)
		}
	}
	
}
