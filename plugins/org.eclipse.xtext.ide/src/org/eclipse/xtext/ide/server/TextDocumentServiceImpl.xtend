/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import io.typefox.lsapi.Diagnostic
import io.typefox.lsapi.DiagnosticImpl
import io.typefox.lsapi.NotificationCallback
import io.typefox.lsapi.PositionImpl
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.RangeImpl
import io.typefox.lsapi.TextDocumentPositionParams
import io.typefox.lsapi.TextDocumentService
import java.util.List
import org.eclipse.xtext.validation.Issue
import org.eclipse.emf.common.util.URI
import io.typefox.lsapi.PublishDiagnosticsParamsImpl
import io.typefox.lsapi.CompletionItem
import io.typefox.lsapi.ReferenceParams
import io.typefox.lsapi.DocumentSymbolParams
import io.typefox.lsapi.CodeActionParams
import io.typefox.lsapi.CodeLensParams
import io.typefox.lsapi.CodeLens
import io.typefox.lsapi.DocumentFormattingParams
import io.typefox.lsapi.DocumentRangeFormattingParams
import io.typefox.lsapi.DocumentOnTypeFormattingParams
import io.typefox.lsapi.RenameParams
import io.typefox.lsapi.DidOpenTextDocumentParams
import io.typefox.lsapi.DidChangeTextDocumentParams
import io.typefox.lsapi.DidCloseTextDocumentParams
import io.typefox.lsapi.DidSaveTextDocumentParams

/**
 * @author efftinge - Initial contribution and API
 */
class TextDocumentServiceImpl implements TextDocumentService {
    
    override completion(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    def void publishDiagnostics(URI uri, Iterable<? extends Issue> issues) {
        val diagnostics = new PublishDiagnosticsParamsImpl => [
            it.uri = uri.toFileString
            it.diagnostics = issues.map[toDiagnostic].toList
        ]
        for (diagnosticsCallback : diagnosticListeners) {
            diagnosticsCallback.call(diagnostics)
        }
    }
    
    private def DiagnosticImpl toDiagnostic(Issue issue) {
        new DiagnosticImpl => [
            code = issue.code 
            severity = switch issue.severity {
                case ERROR : Diagnostic.SEVERITY_ERROR
                case WARNING : Diagnostic.SEVERITY_WARNING
                case INFO : Diagnostic.SEVERITY_INFO
                default : Diagnostic.SEVERITY_HINT
            }
            message = issue.message
            range = new RangeImpl => [
                start = new PositionImpl => [
                    line = issue.lineNumber
                    character = issue.column
                ]
                end = new PositionImpl => [
                    line = issue.lineNumber
                    character = issue.column + issue.length
                ]
            ]
        ]
    }
    
    private List<NotificationCallback<PublishDiagnosticsParams>> diagnosticListeners = newArrayList()
    
    override onPublishDiagnostics(NotificationCallback<PublishDiagnosticsParams> callback) {
        diagnosticListeners.add(callback)
    }
    
    override resolveCompletionItem(CompletionItem unresolved) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override hover(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override signatureHelp(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override definition(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override references(ReferenceParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override documentHighlight(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override documentSymbol(DocumentSymbolParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override codeAction(CodeActionParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override codeLens(CodeLensParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override resolveCodeLens(CodeLens unresolved) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override formatting(DocumentFormattingParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override rangeFormatting(DocumentRangeFormattingParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override onTypeFormatting(DocumentOnTypeFormattingParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override rename(RenameParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didOpen(DidOpenTextDocumentParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didChange(DidChangeTextDocumentParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didClose(DidCloseTextDocumentParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didSave(DidSaveTextDocumentParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    
}