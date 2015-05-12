/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class CrossrefProposalCreator implements Function1<IEObjectDescription, ContentAssistResult.Entry> {
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final ContentAssistContext contentAssistContext;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final IQualifiedNameConverter qualifiedNameConverter;
  
  @Override
  public ContentAssistResult.Entry apply(final IEObjectDescription candidate) {
    if ((candidate == null)) {
      return null;
    }
    String _prefix = this.contentAssistContext.getPrefix();
    ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, _prefix);
    final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        QualifiedName _name = candidate.getName();
        String _string = CrossrefProposalCreator.this.qualifiedNameConverter.toString(_name);
        it.setProposal(_string);
        EClass _eClass = candidate.getEClass();
        String _name_1 = _eClass.getName();
        it.setDescription(_name_1);
      }
    };
    return ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
  }
  
  public CrossrefProposalCreator(final ContentAssistContext contentAssistContext, final IQualifiedNameConverter qualifiedNameConverter) {
    super();
    this.contentAssistContext = contentAssistContext;
    this.qualifiedNameConverter = qualifiedNameConverter;
  }
  
  @Pure
  protected ContentAssistContext getContentAssistContext() {
    return this.contentAssistContext;
  }
  
  @Pure
  protected IQualifiedNameConverter getQualifiedNameConverter() {
    return this.qualifiedNameConverter;
  }
}
