/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.quickfix;

import org.eclipse.xtext.example.arithmetics.validation.ArithmeticsValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#quick-fixes
 */
@SuppressWarnings("all")
public class ArithmeticsQuickfixProvider extends DefaultQuickfixProvider {
  @Fix(ArithmeticsValidator.NORMALIZABLE)
  public void normalize(final Issue issue, final IssueResolutionAcceptor acceptor) {
    String[] _data = issue.getData();
    final String string = _data[0];
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext it) throws Exception {
        IXtextDocument _xtextDocument = it.getXtextDocument();
        Integer _offset = issue.getOffset();
        Integer _length = issue.getLength();
        _xtextDocument.replace((_offset).intValue(), (_length).intValue(), string);
      }
    };
    acceptor.accept(issue, ("Replace with " + string), (("Replace expression with \'" + string) + "\'"), "upcase.png", _function);
  }
}
