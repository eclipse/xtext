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
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.validation.ValidationResult;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Service class for model validation.
 */
@Singleton
@SuppressWarnings("all")
public class ValidationService {
  @Inject
  @Extension
  private UpdateDocumentService _updateDocumentService;
  
  /**
   * Return the validation result for the given document. The actual validation may have
   * been computed as part of the background work scheduled after another service request,
   * e.g. {@link UpdateDocumentService}. If that background processing has not been done
   * yet, it is executed and then the validation issues are collected.
   */
  public ValidationResult validate(final XtextWebDocumentAccess document) throws InvalidRequestException {
    final CancelableUnitOfWork<Collection<Issue>, IXtextWebDocument> _function = new CancelableUnitOfWork<Collection<Issue>, IXtextWebDocument>() {
      @Override
      public Collection<Issue> exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ValidationService.this._updateDocumentService.processUpdatedDocument(it, cancelIndicator);
        return it.getIssues();
      }
    };
    final Collection<Issue> issues = document.<Collection<Issue>>readOnly(_function);
    final ValidationResult result = new ValidationResult();
    final Function1<Issue, Boolean> _function_1 = new Function1<Issue, Boolean>() {
      @Override
      public Boolean apply(final Issue it) {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf((!Objects.equal(_severity, Severity.IGNORE)));
      }
    };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function_1);
    final Procedure1<Issue> _function_2 = new Procedure1<Issue>() {
      @Override
      public void apply(final Issue issue) {
        ArrayList<ValidationResult.Entry> _entries = result.getEntries();
        String _message = issue.getMessage();
        Severity _severity = issue.getSeverity();
        String _translate = ValidationService.this.translate(_severity);
        Integer _lineNumber = issue.getLineNumber();
        Integer _offset = issue.getOffset();
        Integer _offset_1 = issue.getOffset();
        Integer _length = issue.getLength();
        int _plus = ((_offset_1).intValue() + (_length).intValue());
        ValidationResult.Entry _entry = new ValidationResult.Entry(_message, _translate, _lineNumber, _offset, Integer.valueOf(_plus));
        _entries.add(_entry);
      }
    };
    IterableExtensions.<Issue>forEach(_filter, _function_2);
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
