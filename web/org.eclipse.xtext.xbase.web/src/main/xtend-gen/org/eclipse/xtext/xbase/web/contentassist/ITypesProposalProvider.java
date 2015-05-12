/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;

@SuppressWarnings("all")
public interface ITypesProposalProvider {
  public interface Filter {
    public abstract boolean accept(final int modifiers, final char[] packageName, final char[] simpleTypeName, final char[][] enclosingTypeNames, final String path);
  }
  
  public abstract void createTypeProposals(final ContentAssistContext context, final EReference typeReference, final IAcceptor<ContentAssistResult.Entry> acceptor);
  
  public abstract void createTypeProposals(final ContentAssistContext context, final EReference typeReference, final ITypesProposalProvider.Filter filter, final IAcceptor<ContentAssistResult.Entry> acceptor);
  
  public abstract void createTypeProposals(final ContentAssistContext context, final EReference typeReference, final ITypesProposalProvider.Filter filter, final IValueConverter<String> valueConverter, final IAcceptor<ContentAssistResult.Entry> acceptor);
  
  public abstract void createSubTypeProposals(final JvmType superType, final ContentAssistContext context, final EReference typeReference, final IAcceptor<ContentAssistResult.Entry> acceptor);
  
  public abstract void createSubTypeProposals(final JvmType superType, final ContentAssistContext context, final EReference typeReference, final ITypesProposalProvider.Filter filter, final IAcceptor<ContentAssistResult.Entry> acceptor);
  
  public abstract void createSubTypeProposals(final JvmType superType, final ContentAssistContext context, final EReference typeReference, final ITypesProposalProvider.Filter filter, final IValueConverter<String> valueConverter, final IAcceptor<ContentAssistResult.Entry> acceptor);
}
