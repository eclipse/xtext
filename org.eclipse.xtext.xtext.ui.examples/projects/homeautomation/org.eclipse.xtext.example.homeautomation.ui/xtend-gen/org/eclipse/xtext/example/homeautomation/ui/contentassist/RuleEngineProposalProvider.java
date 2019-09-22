/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.homeautomation.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.example.homeautomation.ui.contentassist.AbstractRuleEngineProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;

/**
 * Exemplary overrides of default Xbase proposals. Does the same as the super implementation.
 */
@SuppressWarnings("all")
public class RuleEngineProposalProvider extends AbstractRuleEngineProposalProvider {
  @Override
  public void completeXBlockExpression_Expressions(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.completeWithinBlock(model, context, acceptor);
  }
  
  @Override
  public void completeXSwitchExpression_Default(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor);
  }
}
