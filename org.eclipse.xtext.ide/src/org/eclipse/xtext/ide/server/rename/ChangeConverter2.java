/**
 * Copyright (c) 2019, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.rename;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentEdit;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.WorkspaceEditCapabilities;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
public class ChangeConverter2 implements IAcceptor<IEmfResourceChange> {
	public static class Factory {
		@Inject
		protected IResourceServiceProvider.Registry registry;

		@Inject
		protected UriExtensions uriExtensions;

		/**
		 * @since 2.18
		 */
		public ChangeConverter2 create(WorkspaceEdit edit, ILanguageServerAccess access) {
			return new ChangeConverter2(registry, edit, access, uriExtensions);
		}
	}

	private IResourceServiceProvider.Registry registry;

	private UriExtensions uriExtensions;

	private WorkspaceEdit edit;

	private ILanguageServerAccess access;

	private boolean useDocumentChanges;

	protected ChangeConverter2(IResourceServiceProvider.Registry registry, WorkspaceEdit edit,
			ILanguageServerAccess access, UriExtensions uriExtensions) {
		this.registry = registry;
		this.uriExtensions = uriExtensions;
		this.edit = edit;
		this.access = access;
		Boolean documentChanges = null;
		if (access != null) {
			InitializeParams initializeParams = access.getInitializeParams();
			if (initializeParams != null) {
				ClientCapabilities clientCapabilities = initializeParams.getCapabilities();
				if (clientCapabilities != null) {
					WorkspaceClientCapabilities workspaceClientCapabilities = clientCapabilities.getWorkspace();
					if (workspaceClientCapabilities != null) {
						WorkspaceEditCapabilities workspaceEditCapabilities = workspaceClientCapabilities
								.getWorkspaceEdit();
						if (workspaceEditCapabilities != null) {
							documentChanges = workspaceEditCapabilities.getDocumentChanges();
						}
					}
				}
			}
		}
		this.useDocumentChanges = documentChanges == Boolean.TRUE;
		if (this.useDocumentChanges) {
			this.edit.setDocumentChanges(new ArrayList<>());
		} else {
			this.edit.setChanges(new LinkedHashMap<>());
		}
	}

	@Override
	public void accept(IEmfResourceChange change) {
		handleReplacements(change);
	}

	protected void _handleReplacements(IEmfResourceChange change) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			String uri = uriExtensions.toUriString(change.getResource().getURI());
			change.getResource().save(outputStream, null);
			String newContent = new String(outputStream.toByteArray(), getCharset(change.getResource()));
			access.doRead(uri, (ILanguageServerAccess.Context context) -> {
				Document document = context.getDocument();
				Range range = new Range(document.getPosition(0), document.getPosition(document.getContents().length()));
				TextEdit textEdit = new TextEdit(range, newContent);
				return addTextEdit(uri, document, textEdit);
			}).get();
		} catch (InterruptedException | ExecutionException | IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected String getCharset(Resource resource) {
		IEncodingProvider xtextEncodingProvider = registry.getResourceServiceProvider(resource.getURI())
				.get(IEncodingProvider.class);
		if (xtextEncodingProvider != null) {
			return xtextEncodingProvider.getEncoding(resource.getURI());
		} else {
			if (resource instanceof XMLResource) {
				return ((XMLResource) resource).getEncoding();
			} else {
				return Charset.defaultCharset().toString();
			}
		}
	}

	protected void _handleReplacements(ITextDocumentChange change) {
		try {
			if (change.getReplacements().size() > 0) {
				String uri = uriExtensions.toUriString(change.getNewURI());
				access.doRead(uri, (ILanguageServerAccess.Context context) -> {
					Document document = context.getDocument();
					List<TextEdit> textEdits = Lists.transform(change.getReplacements(),
							(ITextReplacement replacement) -> {
								Position start = document.getPosition(replacement.getOffset());
								Position end = document.getPosition(replacement.getOffset() + replacement.getLength());
								Range range = new Range(start, end);
								return new TextEdit(range, replacement.getReplacementText());
							});
					return addTextEdit(uri, document, textEdits.toArray(new TextEdit[textEdits.size()]));
				}).get();
			}
		} catch (InterruptedException | ExecutionException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected Object addTextEdit(String theUri, Document document, TextEdit... textEdits) {
		if (useDocumentChanges) {
			TextDocumentEdit textDocumentEdit = new TextDocumentEdit();
			VersionedTextDocumentIdentifier versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
			versionedTextDocumentIdentifier.setUri(theUri);
			versionedTextDocumentIdentifier.setVersion(document.getVersion());
			textDocumentEdit.setTextDocument(versionedTextDocumentIdentifier);
			textDocumentEdit.setEdits(Arrays.asList(textEdits));
			return edit.getDocumentChanges().add(Either.forLeft(textDocumentEdit));
		} else {
			return edit.getChanges().put(theUri, Arrays.asList(textEdits));
		}
	}

	protected void handleReplacements(IEmfResourceChange change) {
		if (change instanceof ITextDocumentChange) {
			_handleReplacements((ITextDocumentChange) change);
			return;
		} else if (change != null) {
			_handleReplacements(change);
			return;
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.<Object>asList(change).toString());
		}
	}
}
