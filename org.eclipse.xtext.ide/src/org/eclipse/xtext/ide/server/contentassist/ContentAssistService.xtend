/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.contentassist

import com.google.common.base.Strings
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.ArrayList
import java.util.concurrent.ExecutorService
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionItemKind
import org.eclipse.lsp4j.CompletionList
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.TextEdit
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.TextRegion
import org.eclipse.lsp4j.InsertTextFormat

/**
 * @author kosyakov - Initial contribution and API
 * @author Dennis Huebner - additionalTextEdits support
 * 
 * @since 2.11
 */
@Singleton
class ContentAssistService {

    public static val DEFAULT_PROPOSALS_LIMIT = 1000

    @Inject Provider<ContentAssistContextFactory> contextFactoryProvider

    @Inject ExecutorService executorService

    @Inject IdeContentProposalProvider proposalProvider

    @Inject Provider<IdeContentProposalAcceptor> proposalAcceptorProvider

    @Inject OperationCanceledManager operationCanceledManager

    def CompletionList createCompletionList(Document document, XtextResource resource,
        TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
        val result = new CompletionList
        // we set isInComplete to true, so we get asked always, which is the best match to the expected behavior in Xtext
        result.setIsIncomplete(true);

        val acceptor = proposalAcceptorProvider.get
        val caretOffset = document.getOffSet(params.position)
        val caretPosition = params.position
        val position = new TextRegion(caretOffset, 0)
        try {
            createProposals(document.contents, position, caretOffset, resource, acceptor)
        } catch (Throwable t) {
            if (!operationCanceledManager.isOperationCanceledException(t)) {
                throw t
            }
        }
        acceptor.getEntries().forEach [ it, idx |
            val item = toCompletionItem(caretOffset, caretPosition, document)
            item.sortText = Strings.padStart(Integer.toString(idx), 5, "0")
            result.items += item
        ]
        return result
    }

    protected def void createProposals(String document, TextRegion selection, int caretOffset, XtextResource resource, IIdeContentProposalAcceptor acceptor) {
        if(caretOffset > document.length) return;

        val contextFactory = contextFactoryProvider.get
        contextFactory.pool = executorService
        val contexts = contextFactory.create(document, selection, caretOffset, resource)
        proposalProvider.createProposals(contexts, acceptor)
    }

    protected def CompletionItem toCompletionItem(ContentAssistEntry entry, int caretOffset,
        Position caretPosition, Document document) {
        val completionItem = new CompletionItem
        completionItem.label = entry.label ?: entry.proposal
        completionItem.detail = entry.description
        completionItem.documentation = entry.documentation
        val prefixOffset = caretOffset - (entry.prefix ?: '').length
        val prefixPosition = document.getPosition(prefixOffset)
        completionItem.textEdit = new TextEdit(new Range(prefixPosition, caretPosition), entry.proposal)
        completionItem.kind = translateKind(entry)
        if (!entry.textReplacements.empty) {
            if (completionItem.additionalTextEdits === null) {
                completionItem.additionalTextEdits = new ArrayList(entry.textReplacements.size)
            }
            entry.textReplacements.forEach [
                completionItem.additionalTextEdits += toTextEdit(document)
            ]
        }
        if (entry.kind == ContentAssistEntry.KIND_SNIPPET) {
            completionItem.insertTextFormat = InsertTextFormat.Snippet
        }
        return completionItem
    }

    protected def translateKind(ContentAssistEntry entry) {
        switch entry.kind {
            case ContentAssistEntry.KIND_CLASS: CompletionItemKind.Class
            case ContentAssistEntry.KIND_COLOR: CompletionItemKind.Color
            case ContentAssistEntry.KIND_CONSTRUCTOR: CompletionItemKind.Constructor
            case ContentAssistEntry.KIND_ENUM: CompletionItemKind.Enum
            case ContentAssistEntry.KIND_FIELD: CompletionItemKind.Field
            case ContentAssistEntry.KIND_FILE: CompletionItemKind.File
            case ContentAssistEntry.KIND_FUNCTION: CompletionItemKind.Function
            case ContentAssistEntry.KIND_INTERFACE: CompletionItemKind.Interface
            case ContentAssistEntry.KIND_KEYWORD: CompletionItemKind.Keyword
            case ContentAssistEntry.KIND_METHOD: CompletionItemKind.Method
            case ContentAssistEntry.KIND_MODULE: CompletionItemKind.Module
            case ContentAssistEntry.KIND_PROPERTY: CompletionItemKind.Property
            case ContentAssistEntry.KIND_REFERENCE: CompletionItemKind.Reference
            case ContentAssistEntry.KIND_SNIPPET: CompletionItemKind.Snippet
            case ContentAssistEntry.KIND_TEXT: CompletionItemKind.Text
            case ContentAssistEntry.KIND_UNIT: CompletionItemKind.Unit
            case ContentAssistEntry.KIND_VALUE: CompletionItemKind.Value
            case ContentAssistEntry.KIND_VARIABLE: CompletionItemKind.Variable
            default: CompletionItemKind.Value
        }
    }

    protected def toTextEdit(ReplaceRegion region, Document doc) {
        val start = if (region.offset > doc.contents.length) {
               val docEnd = doc.getPosition(doc.contents.length)
               new Position(docEnd.line, docEnd.character + region.length)
           } else
                doc.getPosition(region.offset)
        val end = if (region.endOffset > doc.contents.length)
                new Position(start.line, start.character + region.length)
            else
                doc.getPosition(region.endOffset)
        new TextEdit(new Range(start, end), region.text)
    }
}
