/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.contentassist

import com.google.common.base.Strings
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.typefox.lsapi.CompletionItemKind
import io.typefox.lsapi.CompletionList
import io.typefox.lsapi.TextDocumentPositionParams
import io.typefox.lsapi.builders.CompletionListBuilder
import io.typefox.lsapi.impl.CompletionItemImpl
import io.typefox.lsapi.impl.PositionImpl
import io.typefox.lsapi.impl.RangeImpl
import io.typefox.lsapi.impl.TextEditImpl
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.TextRegion

/**
 * @author kosyakov - Initial contribution and API
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
        val result = new CompletionListBuilder()
        // we set isInComplete to true, so we get asked always, which is the best match to the expected behavior in Xtext
        result.isIncomplete(true);

        val acceptor = proposalAcceptorProvider.get
        val caretOffset = document.getOffSet(params.position)
        val caretPosition = new PositionImpl(params.position as PositionImpl)
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
            result.item(item)
        ]
        return result.build
    }

    protected def void createProposals(String document, TextRegion selection, int caretOffset, XtextResource resource, IIdeContentProposalAcceptor acceptor) {
        if(caretOffset > document.length) return;

        val contextFactory = contextFactoryProvider.get
        contextFactory.pool = executorService
        val contexts = contextFactory.create(document, selection, caretOffset, resource)
        proposalProvider.createProposals(contexts, acceptor)
    }

    protected def CompletionItemImpl toCompletionItem(ContentAssistEntry entry, int caretOffset,
        PositionImpl caretPosition, Document document) {
        val completionItem = new CompletionItemImpl
        completionItem.label = entry.label ?: entry.proposal
        completionItem.detail = entry.description
        completionItem.documentation = entry.documentation
        val prefixOffset = caretOffset - (entry.prefix ?: '').length
        val prefixPosition = document.getPosition(prefixOffset)
        completionItem.textEdit = new TextEditImpl(new RangeImpl(prefixPosition, caretPosition), entry.proposal)
        completionItem.kind = translateKind(entry)
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
}
