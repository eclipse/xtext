/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.web.contentassist.ITypeFilter;
import org.eclipse.xtext.xbase.web.contentassist.ITypesProposalProvider;

@SuppressWarnings("all")
public class DummyTypesProposalProvider implements ITypesProposalProvider {
  @Override
  public void createTypeProposals(final ContentAssistContext context, final EReference typeReference, final IValueConverter<String> valueConverter, final ITypeFilter filter, final IWebContentProposaAcceptor acceptor) {
    String _prefix = context.getPrefix();
    ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
    final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        it.setProposal("Object");
        it.setDescription("java.lang");
      }
    };
    ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
    acceptor.accept(_doubleArrow, 500);
    String _prefix_1 = context.getPrefix();
    ContentAssistResult.Entry _entry_1 = new ContentAssistResult.Entry(_prefix_1);
    final Procedure1<ContentAssistResult.Entry> _function_1 = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        it.setProposal("String");
        it.setDescription("java.lang");
      }
    };
    ContentAssistResult.Entry _doubleArrow_1 = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry_1, _function_1);
    acceptor.accept(_doubleArrow_1, 500);
  }
}
