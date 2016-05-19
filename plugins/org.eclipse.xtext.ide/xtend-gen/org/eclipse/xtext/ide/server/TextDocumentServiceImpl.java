/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import io.typefox.lsapi.CompletionItem;
import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DiagnosticImpl;
import io.typefox.lsapi.NotificationCallback;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.PublishDiagnosticsParamsImpl;
import io.typefox.lsapi.RangeImpl;
import io.typefox.lsapi.TextDocumentPositionParams;
import io.typefox.lsapi.TextDocumentService;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class TextDocumentServiceImpl implements TextDocumentService {
  @Override
  public List<? extends CompletionItem> completion(final TextDocumentPositionParams position) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void publishDiagnostics(final URI uri, final Iterable<? extends Issue> issues) {
    PublishDiagnosticsParamsImpl _publishDiagnosticsParamsImpl = new PublishDiagnosticsParamsImpl();
    final Procedure1<PublishDiagnosticsParamsImpl> _function = new Procedure1<PublishDiagnosticsParamsImpl>() {
      @Override
      public void apply(final PublishDiagnosticsParamsImpl it) {
        String _fileString = uri.toFileString();
        it.setUri(_fileString);
        final Function1<Issue, DiagnosticImpl> _function = new Function1<Issue, DiagnosticImpl>() {
          @Override
          public DiagnosticImpl apply(final Issue it) {
            return TextDocumentServiceImpl.this.toDiagnostic(it);
          }
        };
        Iterable<DiagnosticImpl> _map = IterableExtensions.map(issues, _function);
        List<DiagnosticImpl> _list = IterableExtensions.<DiagnosticImpl>toList(_map);
        it.setDiagnostics(_list);
      }
    };
    final PublishDiagnosticsParamsImpl diagnostics = ObjectExtensions.<PublishDiagnosticsParamsImpl>operator_doubleArrow(_publishDiagnosticsParamsImpl, _function);
    for (final NotificationCallback<PublishDiagnosticsParams> diagnosticsCallback : this.diagnosticListeners) {
      diagnosticsCallback.onNotification(diagnostics);
    }
  }
  
  private DiagnosticImpl toDiagnostic(final Issue issue) {
    DiagnosticImpl _diagnosticImpl = new DiagnosticImpl();
    final Procedure1<DiagnosticImpl> _function = new Procedure1<DiagnosticImpl>() {
      @Override
      public void apply(final DiagnosticImpl it) {
        String _code = issue.getCode();
        it.setCode(_code);
        int _switchResult = (int) 0;
        Severity _severity = issue.getSeverity();
        if (_severity != null) {
          switch (_severity) {
            case ERROR:
              _switchResult = Diagnostic.SEVERITY_ERROR;
              break;
            case WARNING:
              _switchResult = Diagnostic.SEVERITY_WARNING;
              break;
            case INFO:
              _switchResult = Diagnostic.SEVERITY_INFO;
              break;
            default:
              _switchResult = Diagnostic.SEVERITY_HINT;
              break;
          }
        } else {
          _switchResult = Diagnostic.SEVERITY_HINT;
        }
        it.setSeverity(Integer.valueOf(_switchResult));
        String _message = issue.getMessage();
        it.setMessage(_message);
        RangeImpl _rangeImpl = new RangeImpl();
        final Procedure1<RangeImpl> _function = new Procedure1<RangeImpl>() {
          @Override
          public void apply(final RangeImpl it) {
            PositionImpl _positionImpl = new PositionImpl();
            final Procedure1<PositionImpl> _function = new Procedure1<PositionImpl>() {
              @Override
              public void apply(final PositionImpl it) {
                Integer _lineNumber = issue.getLineNumber();
                it.setLine((_lineNumber).intValue());
                Integer _column = issue.getColumn();
                it.setCharacter((_column).intValue());
              }
            };
            PositionImpl _doubleArrow = ObjectExtensions.<PositionImpl>operator_doubleArrow(_positionImpl, _function);
            it.setStart(_doubleArrow);
            PositionImpl _positionImpl_1 = new PositionImpl();
            final Procedure1<PositionImpl> _function_1 = new Procedure1<PositionImpl>() {
              @Override
              public void apply(final PositionImpl it) {
                Integer _lineNumber = issue.getLineNumber();
                it.setLine((_lineNumber).intValue());
                Integer _column = issue.getColumn();
                Integer _length = issue.getLength();
                int _plus = ((_column).intValue() + (_length).intValue());
                it.setCharacter(_plus);
              }
            };
            PositionImpl _doubleArrow_1 = ObjectExtensions.<PositionImpl>operator_doubleArrow(_positionImpl_1, _function_1);
            it.setEnd(_doubleArrow_1);
          }
        };
        RangeImpl _doubleArrow = ObjectExtensions.<RangeImpl>operator_doubleArrow(_rangeImpl, _function);
        it.setRange(_doubleArrow);
      }
    };
    return ObjectExtensions.<DiagnosticImpl>operator_doubleArrow(_diagnosticImpl, _function);
  }
  
  private List<NotificationCallback<PublishDiagnosticsParams>> diagnosticListeners = CollectionLiterals.<NotificationCallback<PublishDiagnosticsParams>>newArrayList();
  
  @Override
  public void onPublishDiagnostics(final NotificationCallback<PublishDiagnosticsParams> callback) {
    this.diagnosticListeners.add(callback);
  }
}
