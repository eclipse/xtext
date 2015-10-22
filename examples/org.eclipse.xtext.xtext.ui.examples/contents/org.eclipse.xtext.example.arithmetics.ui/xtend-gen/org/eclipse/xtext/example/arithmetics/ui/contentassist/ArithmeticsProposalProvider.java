/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.contentassist;

import com.google.common.base.Function;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.ui.contentassist.AbstractArithmeticsProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * @author Sven Efftinge - initial contribution and API
 */
@SuppressWarnings("all")
public class ArithmeticsProposalProvider extends AbstractArithmeticsProposalProvider {
  /**
   * sets the selection on the arguments for proposed functions.
   */
  @Override
  public void completePrimaryExpression_Func(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.completePrimaryExpression_Func(model, assignment, context, 
      new ICompletionProposalAcceptor.Delegate(acceptor) {
        @Override
        public void accept(final ICompletionProposal proposal) {
          if ((proposal instanceof ConfigurableCompletionProposal)) {
            ConfigurableCompletionProposal ccp = ((ConfigurableCompletionProposal) proposal);
            String string = ccp.getReplacementString();
            Character _valueOf = Character.valueOf('(');
            char _charValue = _valueOf.charValue();
            int indexOfOpenPar = string.indexOf(_charValue);
            if ((indexOfOpenPar != (-1))) {
              int oldSelectionStart = ccp.getSelectionStart();
              int _length = string.length();
              int _minus = (oldSelectionStart - _length);
              int _plus = (_minus + indexOfOpenPar);
              int _plus_1 = (_plus + 1);
              ccp.setSelectionStart(_plus_1);
              int _selectionStart = ccp.getSelectionStart();
              int _minus_1 = (oldSelectionStart - _selectionStart);
              int _minus_2 = (_minus_1 - 1);
              ccp.setSelectionLength(_minus_2);
            }
          }
          super.accept(proposal);
        }
      });
  }
  
  @Override
  protected String getDisplayString(final EObject element, final String qualifiedNameAsString, final String shortName) {
    if ((element instanceof DeclaredParameter)) {
      return shortName;
    }
    return super.getDisplayString(element, qualifiedNameAsString, shortName);
  }
  
  @Override
  protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(final String ruleName, final ContentAssistContext contentAssistContext) {
    return super.getProposalFactory(null, contentAssistContext);
  }
}
