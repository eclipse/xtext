/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.google.common.base.Objects;
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer;
import com.intellij.compiler.CompilerMessageImpl;
import com.intellij.compiler.ProblemsView;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompilerMessage;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.problems.WolfTheProblemSolver;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.idea.build.AffectedScope;
import org.eclipse.xtext.idea.build.BuildEvent;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildProgressReporter implements BuildRequest.IPostValidationCallback {
  private final UUID sessionId = UUID.randomUUID();
  
  private final AffectedScope affectedScope = new AffectedScope();
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Project project;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private List<BuildEvent> events;
  
  protected ProblemsView getProblemsView() {
    return ProblemsView.SERVICE.getInstance(this.project);
  }
  
  public void clearProgress() {
    boolean _or = false;
    boolean _isUnitTestMode = this.isUnitTestMode();
    if (_isUnitTestMode) {
      _or = true;
    } else {
      boolean _isDisposed = this.project.isDisposed();
      _or = _isDisposed;
    }
    if (_or) {
      return;
    }
    ProblemsView _problemsView = this.getProblemsView();
    _problemsView.clearProgress();
    ProblemsView _problemsView_1 = this.getProblemsView();
    _problemsView_1.clearOldMessages(this.affectedScope, this.sessionId);
  }
  
  public void rehighlight() {
    HashSet<URI> _affectedFiles = this.affectedScope.getAffectedFiles();
    final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        return Boolean.valueOf(BuildProgressReporter.this.shouldRehighlight(it));
      }
    };
    final Iterable<URI> filesToRehighlight = IterableExtensions.<URI>filter(_affectedFiles, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(filesToRehighlight);
    if (_isEmpty) {
      return;
    }
    final WolfTheProblemSolver wolfTheProblemSolver = WolfTheProblemSolver.getInstance(this.project);
    for (final URI fileToRehighlight : filesToRehighlight) {
      VirtualFile _virtualFile = VirtualFileURIUtil.getVirtualFile(fileToRehighlight);
      wolfTheProblemSolver.queue(_virtualFile);
    }
    DaemonCodeAnalyzer _instance = DaemonCodeAnalyzer.getInstance(this.project);
    _instance.restart();
  }
  
  protected boolean shouldRehighlight(final URI fileURI) {
    final Function1<BuildEvent, Boolean> _function = new Function1<BuildEvent, Boolean>() {
      @Override
      public Boolean apply(final BuildEvent it) {
        boolean _or = false;
        BuildEvent.Type _type = it.getType();
        boolean _equals = Objects.equal(_type, BuildEvent.Type.MODIFIED);
        if (_equals) {
          _or = true;
        } else {
          BuildEvent.Type _type_1 = it.getType();
          boolean _equals_1 = Objects.equal(_type_1, BuildEvent.Type.DELETED);
          _or = _equals_1;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<BuildEvent> _filter = IterableExtensions.<BuildEvent>filter(this.events, _function);
    final Function1<BuildEvent, Boolean> _function_1 = new Function1<BuildEvent, Boolean>() {
      @Override
      public Boolean apply(final BuildEvent it) {
        Set<URI> _uRIs = it.getURIs();
        return Boolean.valueOf(_uRIs.contains(fileURI));
      }
    };
    boolean _exists = IterableExtensions.<BuildEvent>exists(_filter, _function_1);
    return (_exists == false);
  }
  
  public void markAsAffected(final URI uri) {
    HashSet<URI> _affectedFiles = this.affectedScope.getAffectedFiles();
    _affectedFiles.add(uri);
  }
  
  @Override
  public boolean afterValidate(final URI validated, final Iterable<Issue> issues) {
    this.markAsAffected(validated);
    Iterable<Issue> _filterNull = IterableExtensions.<Issue>filterNull(issues);
    for (final Issue issue : _filterNull) {
      this.reportIssue(validated, issue);
    }
    return true;
  }
  
  protected void reportIssue(final URI validated, final Issue issue) {
    boolean _or = false;
    boolean _isUnitTestMode = this.isUnitTestMode();
    if (_isUnitTestMode) {
      _or = true;
    } else {
      boolean _isDisposed = this.project.isDisposed();
      _or = _isDisposed;
    }
    if (_or) {
      return;
    }
    final CompilerMessage compilerMessage = this.getCompilerMessage(validated, issue);
    ProblemsView _problemsView = this.getProblemsView();
    _problemsView.addMessage(compilerMessage, this.sessionId);
  }
  
  protected boolean isUnitTestMode() {
    boolean _xblockexpression = false;
    {
      final Application application = ApplicationManager.getApplication();
      boolean _or = false;
      boolean _equals = Objects.equal(application, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _isUnitTestMode = application.isUnitTestMode();
        _or = _isUnitTestMode;
      }
      _xblockexpression = _or;
    }
    return _xblockexpression;
  }
  
  protected CompilerMessage getCompilerMessage(final URI validated, final Issue issue) {
    final VirtualFile file = VirtualFileURIUtil.getVirtualFile(validated);
    CompilerMessageCategory _category = this.getCategory(issue);
    String _message = issue.getMessage();
    Integer _lineNumber = issue.getLineNumber();
    Integer _column = issue.getColumn();
    Integer _offset = issue.getOffset();
    OpenFileDescriptor _openFileDescriptor = new OpenFileDescriptor(this.project, file, (_offset).intValue());
    return new CompilerMessageImpl(
      this.project, _category, _message, file, (_lineNumber).intValue(), (_column).intValue(), _openFileDescriptor);
  }
  
  protected CompilerMessageCategory getCategory(final Issue issue) {
    CompilerMessageCategory _switchResult = null;
    Severity _severity = issue.getSeverity();
    if (_severity != null) {
      switch (_severity) {
        case ERROR:
          _switchResult = CompilerMessageCategory.ERROR;
          break;
        case WARNING:
          _switchResult = CompilerMessageCategory.WARNING;
          break;
        case INFO:
          _switchResult = CompilerMessageCategory.INFORMATION;
          break;
        default:
          _switchResult = CompilerMessageCategory.INFORMATION;
          break;
      }
    } else {
      _switchResult = CompilerMessageCategory.INFORMATION;
    }
    return _switchResult;
  }
  
  public void setProject(final Project project) {
    this.project = project;
  }
  
  public void setEvents(final List<BuildEvent> events) {
    this.events = events;
  }
}
