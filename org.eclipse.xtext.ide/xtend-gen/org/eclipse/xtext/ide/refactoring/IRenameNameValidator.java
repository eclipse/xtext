/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@ImplementedBy(IRenameNameValidator.RuleBasedNameValidator.class)
@SuppressWarnings("all")
public interface IRenameNameValidator {
  public static class RuleBasedNameValidator implements IRenameNameValidator {
    @Inject
    private IValueConverterService valueConverterService;
    
    @Override
    public void validate(final EObject target, final String newName, final RefactoringIssueAcceptor issues) {
      try {
        this.getNameAsValue(newName);
      } catch (final Throwable _t) {
        if (_t instanceof ValueConverterException) {
          final ValueConverterException e = (ValueConverterException)_t;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Illegal name: ");
          String _message = e.getMessage();
          _builder.append(_message);
          issues.add(RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    
    protected String getNameAsText(final String nameAsValue) {
      return this.valueConverterService.toString(nameAsValue, this.getRuleName());
    }
    
    protected String getNameAsValue(final String nameAsText) {
      return this.valueConverterService.toValue(nameAsText, this.getRuleName(), null).toString();
    }
    
    protected String getRuleName() {
      return "ID";
    }
  }
  
  public abstract void validate(final EObject target, final String newName, final RefactoringIssueAcceptor issues);
}
