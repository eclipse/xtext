/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
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
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.xtext.ide.serializer.IEmfResourceChange
import org.eclipse.xtext.ide.serializer.ITextDocumentChange
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.IAcceptor

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 * @deprecated use {@link ChangeConverter2} instead
 */
@Deprecated
class ChangeConverter implements IAcceptor<IEmfResourceChange> {

	static class Factory {

		@Inject IResourceServiceProvider.Registry registry

		def ChangeConverter create(WorkspaceManager workspaceManager, WorkspaceEdit edit) {
			new ChangeConverter(workspaceManager, registry, edit)
		}
	}

	val WorkspaceManager workspaceManager
	val IResourceServiceProvider.Registry registry
	val WorkspaceEdit edit
	
	protected new(WorkspaceManager workspaceManager, IResourceServiceProvider.Registry registry, WorkspaceEdit edit) {
		this.workspaceManager = workspaceManager
		this.registry = registry
		this.edit = edit
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
				addTextEdit(uri, textEdit)
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
				addTextEdit(uri, textEdits)
			]
		}
	}
	
	protected def addTextEdit(URI uri, TextEdit... textEdit) {
		edit.changes.put(uri.toString, textEdit)
	}
}
