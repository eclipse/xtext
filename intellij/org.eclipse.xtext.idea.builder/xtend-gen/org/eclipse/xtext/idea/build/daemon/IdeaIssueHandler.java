/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.idea.build.daemon.XtextBuildResultCollector;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.jetbrains.jps.incremental.messages.BuildMessage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaIssueHandler implements IIssueHandler {
  @Accessors
  private XtextBuildResultCollector buildResultCollector;
  
  @Override
  public boolean handleIssue(final Iterable<Issue> issues) {
    boolean errorFree = true;
    final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
      @Override
      public Boolean apply(final Issue it) {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf((!Objects.equal(_severity, Severity.IGNORE)));
      }
    };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
    for (final Issue issue : _filter) {
      {
        Protocol.BuildIssue _buildIssue = new Protocol.BuildIssue();
        final Procedure1<Protocol.BuildIssue> _function_1 = new Procedure1<Protocol.BuildIssue>() {
          @Override
          public void apply(final Protocol.BuildIssue it) {
            BuildMessage.Kind _kind = IdeaIssueHandler.this.getKind(issue);
            it.setKind(_kind);
            String _message = issue.getMessage();
            it.setMessage(_message);
            URI _uriToProblem = issue.getUriToProblem();
            String _path = _uriToProblem.path();
            it.setPath(_path);
            Integer _offset = issue.getOffset();
            it.setStartOffset((_offset).intValue());
            Integer _offset_1 = issue.getOffset();
            Integer _length = issue.getLength();
            int _plus = ((_offset_1).intValue() + (_length).intValue());
            it.setEndOffset(_plus);
            Integer _offset_2 = issue.getOffset();
            it.setLocationOffset((_offset_2).intValue());
            Integer _lineNumber = issue.getLineNumber();
            it.setLine((_lineNumber).intValue());
            it.setColumn(0);
          }
        };
        Protocol.BuildIssue _doubleArrow = ObjectExtensions.<Protocol.BuildIssue>operator_doubleArrow(_buildIssue, _function_1);
        this.buildResultCollector.addIssue(_doubleArrow);
        boolean _and = false;
        if (!errorFree) {
          _and = false;
        } else {
          Severity _severity = issue.getSeverity();
          boolean _notEquals = (!Objects.equal(_severity, Severity.ERROR));
          _and = _notEquals;
        }
        errorFree = _and;
      }
    }
    return errorFree;
  }
  
  private BuildMessage.Kind getKind(final Issue issue) {
    BuildMessage.Kind _switchResult = null;
    Severity _severity = issue.getSeverity();
    if (_severity != null) {
      switch (_severity) {
        case ERROR:
          _switchResult = BuildMessage.Kind.ERROR;
          break;
        case WARNING:
          _switchResult = BuildMessage.Kind.WARNING;
          break;
        case INFO:
          _switchResult = BuildMessage.Kind.INFO;
          break;
        case IGNORE:
          _switchResult = BuildMessage.Kind.PROGRESS;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  @Pure
  public XtextBuildResultCollector getBuildResultCollector() {
    return this.buildResultCollector;
  }
  
  public void setBuildResultCollector(final XtextBuildResultCollector buildResultCollector) {
    this.buildResultCollector = buildResultCollector;
  }
}
