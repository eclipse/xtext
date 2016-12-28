/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.quickfix;

import org.eclipse.xtext.example.arithmetics.validation.ArithmeticsValidator;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
@SuppressWarnings("all")
public class ArithmeticsQuickfixProvider extends DefaultQuickfixProvider {
  @Fix(ArithmeticsValidator.NORMALIZABLE)
  public void normalize(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final String string = issue.getData()[0];
    final IModification _function = (IModificationContext it) -> {
      it.getXtextDocument().replace((issue.getOffset()).intValue(), (issue.getLength()).intValue(), string);
    };
    acceptor.accept(issue, ("Replace with " + string), (("Replace expression with \'" + string) + "\'"), "upcase.png", _function);
  }
}
