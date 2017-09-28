/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.rename;

import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerRefactoringIssueAcceptor implements RefactoringIssueAcceptor {
  public static class Issue {
    private RefactoringIssueAcceptor.Severity severity;
    
    private String message;
  }
  
  private List<ServerRefactoringIssueAcceptor.Issue> issues = CollectionLiterals.<ServerRefactoringIssueAcceptor.Issue>newArrayList();
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final URI uri, final ResourceSet resourceSet) {
    this.addIssue(severity, message);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final URI resourceUri) {
    this.addIssue(severity, message);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final EObject element) {
    this.addIssue(severity, message);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final EObject element, final ITextRegion region) {
    this.addIssue(severity, message);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final Exception exc, final Logger log) {
    this.addIssue(severity, message);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final Object... params) {
    ServerRefactoringIssueAcceptor.Issue _issue = new ServerRefactoringIssueAcceptor.Issue();
    final Procedure1<ServerRefactoringIssueAcceptor.Issue> _function = (ServerRefactoringIssueAcceptor.Issue it) -> {
      it.severity = severity;
      it.message = message;
    };
    ServerRefactoringIssueAcceptor.Issue _doubleArrow = ObjectExtensions.<ServerRefactoringIssueAcceptor.Issue>operator_doubleArrow(_issue, _function);
    this.issues.add(_doubleArrow);
    this.checkSeverity();
  }
  
  protected boolean addIssue(final RefactoringIssueAcceptor.Severity severity, final String message) {
    ServerRefactoringIssueAcceptor.Issue _issue = new ServerRefactoringIssueAcceptor.Issue();
    final Procedure1<ServerRefactoringIssueAcceptor.Issue> _function = (ServerRefactoringIssueAcceptor.Issue it) -> {
      it.severity = severity;
      it.message = message;
    };
    ServerRefactoringIssueAcceptor.Issue _doubleArrow = ObjectExtensions.<ServerRefactoringIssueAcceptor.Issue>operator_doubleArrow(_issue, _function);
    return this.issues.add(_doubleArrow);
  }
  
  public RefactoringIssueAcceptor.Severity getMaximumSeverity() {
    RefactoringIssueAcceptor.Severity _elvis = null;
    final Function1<ServerRefactoringIssueAcceptor.Issue, RefactoringIssueAcceptor.Severity> _function = (ServerRefactoringIssueAcceptor.Issue it) -> {
      return it.severity;
    };
    ServerRefactoringIssueAcceptor.Issue _minBy = IterableExtensions.<ServerRefactoringIssueAcceptor.Issue, RefactoringIssueAcceptor.Severity>minBy(this.issues, _function);
    RefactoringIssueAcceptor.Severity _severity = null;
    if (_minBy!=null) {
      _severity=_minBy.severity;
    }
    if (_severity != null) {
      _elvis = _severity;
    } else {
      _elvis = RefactoringIssueAcceptor.Severity.OK;
    }
    return _elvis;
  }
  
  public ResponseError toResponseError() {
    ResponseError _xblockexpression = null;
    {
      final RefactoringIssueAcceptor.Severity maxSeverity = this.getMaximumSeverity();
      ResponseError _responseError = new ResponseError();
      final Procedure1<ResponseError> _function = (ResponseError it) -> {
        String _switchResult = null;
        if (maxSeverity != null) {
          switch (maxSeverity) {
            case OK:
              _switchResult = "Refactoring is possible";
              break;
            case INFO:
              _switchResult = "Refactoring is possible";
              break;
            case WARNING:
              _switchResult = "Refactoring could cause issues";
              break;
            case ERROR:
              _switchResult = "Refactoring has errors";
              break;
            case FATAL:
              _switchResult = "Refactoring cannot be performed";
              break;
            default:
              break;
          }
        }
        it.setMessage(_switchResult);
        final Function1<ServerRefactoringIssueAcceptor.Issue, RefactoringIssueAcceptor.Severity> _function_1 = (ServerRefactoringIssueAcceptor.Issue it_1) -> {
          return it_1.severity;
        };
        final Function1<ServerRefactoringIssueAcceptor.Issue, String> _function_2 = (ServerRefactoringIssueAcceptor.Issue it_1) -> {
          return it_1.message;
        };
        it.setData(IterableExtensions.join(ListExtensions.<ServerRefactoringIssueAcceptor.Issue, String>map(ListExtensions.<ServerRefactoringIssueAcceptor.Issue>reverse(IterableExtensions.<ServerRefactoringIssueAcceptor.Issue, RefactoringIssueAcceptor.Severity>sortBy(this.issues, _function_1)), _function_2), "\n"));
        int _switchResult_1 = (int) 0;
        if (maxSeverity != null) {
          switch (maxSeverity) {
            case OK:
              _switchResult_1 = 0;
              break;
            case INFO:
              _switchResult_1 = 0;
              break;
            case WARNING:
              _switchResult_1 = 0;
              break;
            case ERROR:
              _switchResult_1 = ResponseErrorCode.UnknownErrorCode.getValue();
              break;
            case FATAL:
              _switchResult_1 = ResponseErrorCode.UnknownErrorCode.getValue();
              break;
            default:
              break;
          }
        }
        it.setCode(_switchResult_1);
      };
      _xblockexpression = ObjectExtensions.<ResponseError>operator_doubleArrow(_responseError, _function);
    }
    return _xblockexpression;
  }
  
  public void checkSeverity() {
    RefactoringIssueAcceptor.Severity _maximumSeverity = this.getMaximumSeverity();
    boolean _lessThan = (_maximumSeverity.compareTo(RefactoringIssueAcceptor.Severity.WARNING) < 0);
    if (_lessThan) {
      ResponseError _responseError = this.toResponseError();
      throw new ResponseErrorException(_responseError);
    }
  }
}
