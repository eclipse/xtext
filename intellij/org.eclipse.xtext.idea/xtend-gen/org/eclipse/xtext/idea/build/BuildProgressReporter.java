/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.intellij.compiler.CompilerMessageImpl;
import com.intellij.compiler.ProblemsView;
import com.intellij.openapi.compiler.CompilerMessage;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.HashSet;
import java.util.UUID;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.idea.build.AffectedScope;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.validation.Issue;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildProgressReporter implements BuildRequest.IPostValidationCallback {
  private final UUID sessionId = UUID.randomUUID();
  
  private final AffectedScope affectedScope = new AffectedScope();
  
  private Project project;
  
  private ProblemsView problemsView;
  
  public void setProject(final Project project) {
    this.project = project;
    ProblemsView _instance = ProblemsView.SERVICE.getInstance(project);
    this.problemsView = _instance;
  }
  
  public void clearProgress() {
    this.problemsView.clearProgress();
    this.problemsView.clearOldMessages(this.affectedScope, this.sessionId);
  }
  
  public void markAsAffected(final URI uri) {
    HashSet<URI> _affectedFiles = this.affectedScope.getAffectedFiles();
    _affectedFiles.add(uri);
  }
  
  @Override
  public boolean afterValidate(final URI validated, final Iterable<Issue> issues) {
    this.markAsAffected(validated);
    for (final Issue issue : issues) {
      this.reportIssue(validated, issue);
    }
    return false;
  }
  
  protected void reportIssue(final URI validated, final Issue issue) {
    final CompilerMessage compilerMessage = this.getCompilerMessage(validated, issue);
    this.problemsView.addMessage(compilerMessage, this.sessionId);
  }
  
  protected CompilerMessage getCompilerMessage(final URI validated, final Issue issue) {
    final VirtualFile file = VirtualFileURIUtil.getVirtualFile(validated);
    CompilerMessageCategory _category = this.getCategory(issue);
    String _message = issue.getMessage();
    Integer _lineNumber = issue.getLineNumber();
    Integer _offset = issue.getOffset();
    OpenFileDescriptor _openFileDescriptor = new OpenFileDescriptor(this.project, file, (_offset).intValue());
    return new CompilerMessageImpl(
      this.project, _category, _message, file, (_lineNumber).intValue(), 
      (-1), _openFileDescriptor);
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
}
