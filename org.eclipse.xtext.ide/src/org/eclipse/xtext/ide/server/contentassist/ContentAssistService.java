/**
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.contentassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.InsertTextFormat;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 * @author Dennis Huebner - additionalTextEdits support
 * 
 * @since 2.11
 */
@Singleton
public class ContentAssistService {
	public final static int DEFAULT_PROPOSALS_LIMIT = 1000;

	@Inject
	private Provider<ContentAssistContextFactory> contextFactoryProvider;

	@Inject
	private ExecutorService executorService;

	@Inject
	private IdeContentProposalProvider proposalProvider;

	@Inject
	private Provider<IdeContentProposalAcceptor> proposalAcceptorProvider;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	public CompletionList createCompletionList(Document document, XtextResource resource, CompletionParams params,
			CancelIndicator cancelIndicator) {
		try {
			CompletionList result = new CompletionList();
			IdeContentProposalAcceptor acceptor = proposalAcceptorProvider.get();
			acceptor.setCancelIndicator(cancelIndicator);
			Position caretPosition = params.getPosition();
			int caretOffset = document.getOffSet(caretPosition);
			TextRegion position = new TextRegion(caretOffset, 0);
			try {
				createProposals(document.getContents(), position, caretOffset, resource, acceptor);
				result.setIsIncomplete(!acceptor.didAcceptAllProposals());
			} catch (Throwable t) {
				result.setIsIncomplete(true);
				if (!operationCanceledManager.isOperationCanceledException(t)) {
					throw t;
				}
			}
			int idx = 0;
			for (ContentAssistEntry it : acceptor.getEntries()) {
				CompletionItem item = toCompletionItem(it, caretOffset, caretPosition, document);
				item.setSortText(Strings.padStart(Integer.toString(idx), 5, '0'));
				result.getItems().add(item);
				idx++;
			}
			return result;
		} catch (Throwable e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected void createProposals(String document, TextRegion selection, int caretOffset, XtextResource resource,
			IIdeContentProposalAcceptor acceptor) {
		if (caretOffset > document.length()) {
			return;
		}
		ContentAssistContextFactory contextFactory = contextFactoryProvider.get();
		contextFactory.setPool(executorService);
		ContentAssistContext[] contexts = contextFactory.create(document, selection, caretOffset, resource);
		proposalProvider.createProposals(Arrays.asList(contexts), acceptor);
	}

	protected CompletionItem toCompletionItem(ContentAssistEntry entry, int caretOffset, Position caretPosition,
			Document document) {
		CompletionItem completionItem = new CompletionItem();
		String label = entry.getLabel();
		if (label == null) {
			label = entry.getProposal();
		}
		completionItem.setLabel(label);
		completionItem.setDetail(entry.getDescription());
		completionItem.setDocumentation(entry.getDocumentation());
		String prefix = entry.getPrefix();
		if (prefix == null) {
			prefix = "";
		}
		int prefixOffset = caretOffset - prefix.length();
		Position prefixPosition = document.getPosition(prefixOffset);
		completionItem.setTextEdit(Either.forLeft(new TextEdit(new Range(prefixPosition, caretPosition), entry.getProposal())));
		completionItem.setKind(translateKind(entry));
		if (!entry.getTextReplacements().isEmpty()) {
			if (completionItem.getAdditionalTextEdits() == null) {
				completionItem.setAdditionalTextEdits(new ArrayList<>(entry.getTextReplacements().size()));
			}
			entry.getTextReplacements().forEach(
					(ReplaceRegion it) -> completionItem.getAdditionalTextEdits().add(toTextEdit(it, document)));
		}
		if (ContentAssistEntry.KIND_SNIPPET.equals(entry.getKind())) {
			completionItem.setInsertTextFormat(InsertTextFormat.Snippet);
		}
		return completionItem;
	}

	protected CompletionItemKind translateKind(ContentAssistEntry entry) {
		if (entry.getKind() != null) {
			switch (entry.getKind()) {
			case ContentAssistEntry.KIND_CLASS:
				return CompletionItemKind.Class;
			case ContentAssistEntry.KIND_COLOR:
				return CompletionItemKind.Color;
			case ContentAssistEntry.KIND_CONSTRUCTOR:
				return CompletionItemKind.Constructor;
			case ContentAssistEntry.KIND_ENUM:
				return CompletionItemKind.Enum;
			case ContentAssistEntry.KIND_FIELD:
				return CompletionItemKind.Field;
			case ContentAssistEntry.KIND_FILE:
				return CompletionItemKind.File;
			case ContentAssistEntry.KIND_FUNCTION:
				return CompletionItemKind.Function;
			case ContentAssistEntry.KIND_INTERFACE:
				return CompletionItemKind.Interface;
			case ContentAssistEntry.KIND_KEYWORD:
				return CompletionItemKind.Keyword;
			case ContentAssistEntry.KIND_METHOD:
				return CompletionItemKind.Method;
			case ContentAssistEntry.KIND_MODULE:
				return CompletionItemKind.Module;
			case ContentAssistEntry.KIND_PROPERTY:
				return CompletionItemKind.Property;
			case ContentAssistEntry.KIND_REFERENCE:
				return CompletionItemKind.Reference;
			case ContentAssistEntry.KIND_SNIPPET:
				return CompletionItemKind.Snippet;
			case ContentAssistEntry.KIND_TEXT:
				return CompletionItemKind.Text;
			case ContentAssistEntry.KIND_UNIT:
				return CompletionItemKind.Unit;
			case ContentAssistEntry.KIND_VALUE:
				return CompletionItemKind.Value;
			case ContentAssistEntry.KIND_VARIABLE:
				return CompletionItemKind.Variable;
			default:
				return CompletionItemKind.Value;
			}
		} else {
			return CompletionItemKind.Value;
		}
	}

	protected TextEdit toTextEdit(ReplaceRegion region, Document doc) {
		final Position start = getPosition(doc, region.getOffset());
		final Position end = getPosition(doc, region.getEndOffset());
		return new TextEdit(new Range(start, end), region.getText());
	}
	
	private Position getPosition(final Document doc, final int offset) {
		final int docLength = doc.getContents().length();
		return offset > docLength ? doc.getPosition(docLength) : doc.getPosition(offset);
    }
    
}
