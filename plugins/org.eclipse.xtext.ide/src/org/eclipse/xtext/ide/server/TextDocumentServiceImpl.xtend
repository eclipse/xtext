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
            diagnosticsCallback.onNotification(diagnostics)
        }
    }
    
    private def Diagnostic toDiagnostic(Issue issue) {
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
    
}