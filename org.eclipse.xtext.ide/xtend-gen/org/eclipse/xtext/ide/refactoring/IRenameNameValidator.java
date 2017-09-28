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
import org.eclipse.xtext.util.Strings;
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
        String value = this.getNameAsValue(newName);
        String text = this.getNameAsText(value);
        boolean _equal = Strings.equal(text, newName);
        boolean _not = (!_equal);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Illegal name: \'");
          _builder.append(newName);
          _builder.append("\'. Consider using \'");
          _builder.append(text);
          _builder.append("\' instead.");
          issues.add(RefactoringIssueAcceptor.Severity.ERROR, _builder.toString());
        }
      } catch (final Throwable _t) {
        if (_t instanceof ValueConverterException) {
          final ValueConverterException e = (ValueConverterException)_t;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Illegal name: ");
          String _message = null;
          if (e!=null) {
            _message=e.getMessage();
          }
          _builder_1.append(_message);
          issues.add(RefactoringIssueAcceptor.Severity.FATAL, _builder_1.toString());
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
