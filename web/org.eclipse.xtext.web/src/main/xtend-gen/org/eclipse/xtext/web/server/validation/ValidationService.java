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
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.data.ValidationResult;
import org.eclipse.xtext.web.server.model.XtextDocument;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ValidationService {
  @Inject
  private IResourceValidator resourceValidator;
  
  public ValidationResult validate(final XtextDocument document, final String requiredStateId) throws InvalidRequestException {
    final IUnitOfWork<List<Issue>, XtextDocument.ReadAccess> _function = new IUnitOfWork<List<Issue>, XtextDocument.ReadAccess>() {
      @Override
      public List<Issue> exec(final XtextDocument.ReadAccess access) throws Exception {
        List<Issue> _xblockexpression = null;
        {
          access.checkStateId(requiredStateId);
          XtextResource _resource = access.getResource();
          _xblockexpression = ValidationService.this.resourceValidator.validate(_resource, CheckMode.ALL, CancelIndicator.NullImpl);
        }
        return _xblockexpression;
      }
    };
    final List<Issue> issues = document.<List<Issue>>readOnly(_function);
    final ValidationResult result = new ValidationResult();
    final Function1<Issue, Boolean> _function_1 = new Function1<Issue, Boolean>() {
      @Override
      public Boolean apply(final Issue it) {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf((!Objects.equal(_severity, Severity.IGNORE)));
      }
    };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function_1);
    final Consumer<Issue> _function_2 = new Consumer<Issue>() {
      @Override
      public void accept(final Issue issue) {
        ArrayList<ValidationResult.Entry> _entries = result.getEntries();
        String _message = issue.getMessage();
        Severity _severity = issue.getSeverity();
        String _translate = ValidationService.this.translate(_severity);
        Integer _lineNumber = issue.getLineNumber();
        int _plus = ((_lineNumber).intValue() + 1);
        Integer _offset = issue.getOffset();
        Integer _offset_1 = issue.getOffset();
        Integer _length = issue.getLength();
        int _plus_1 = ((_offset_1).intValue() + (_length).intValue());
        ValidationResult.Entry _entry = new ValidationResult.Entry(_message, _translate, Integer.valueOf(_plus), _offset, Integer.valueOf(_plus_1));
        _entries.add(_entry);
      }
    };
    _filter.forEach(_function_2);
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
