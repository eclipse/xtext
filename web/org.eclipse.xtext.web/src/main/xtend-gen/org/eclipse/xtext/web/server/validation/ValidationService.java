/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.validation.ValidationResult;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Service class for model validation.
 */
@Singleton
@SuppressWarnings("all")
public class ValidationService extends AbstractCachedService<ValidationResult> {
  @Inject
  private IResourceValidator resourceValidator;
  
  /**
   * Return the validation result for the given document. The actual validation may have
   * been computed as part of the background work scheduled after another service request,
   * e.g. {@link UpdateDocumentService}. If that background processing has not been done
   * yet, it is executed and then the validation issues are collected.
   */
  @Override
  public ValidationResult compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator) {
    XtextResource _resource = it.getResource();
    final List<Issue> issues = this.resourceValidator.validate(_resource, CheckMode.ALL, cancelIndicator);
    final ValidationResult result = new ValidationResult();
    final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
      @Override
      public Boolean apply(final Issue it) {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf((!Objects.equal(_severity, Severity.IGNORE)));
      }
    };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
    for (final Issue issue : _filter) {
      List<ValidationResult.Issue> _issues = result.getIssues();
      String _message = issue.getMessage();
      Severity _severity = issue.getSeverity();
      String _translate = this.translate(_severity);
      Integer _lineNumber = issue.getLineNumber();
      Integer _column = issue.getColumn();
      Integer _offset = issue.getOffset();
      Integer _length = issue.getLength();
      ValidationResult.Issue _issue = new ValidationResult.Issue(_message, _translate, _lineNumber, _column, _offset, _length);
      _issues.add(_issue);
    }
    return result;
  }
  
  protected String translate(final Severity severity) {
    String _switchResult = null;
    if (severity != null) {
      switch (severity) {
        case WARNING:
          _switchResult = "warning";
          break;
        case ERROR:
          _switchResult = "error";
          break;
        case INFO:
          _switchResult = "info";
          break;
        default:
          _switchResult = "ignore";
          break;
      }
    } else {
      _switchResult = "ignore";
    }
    return _switchResult;
  }
}
