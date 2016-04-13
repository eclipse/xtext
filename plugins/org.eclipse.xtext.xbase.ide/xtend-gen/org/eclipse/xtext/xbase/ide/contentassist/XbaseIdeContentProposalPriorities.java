/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Objects;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.StaticFeatureDescriptionWithTypeLiteralReceiver;

@SuppressWarnings("all")
public class XbaseIdeContentProposalPriorities extends IdeContentProposalPriorities {
  @Override
  public int getCrossRefPriority(final IEObjectDescription objectDesc, final ContentAssistEntry entry) {
    boolean _matched = false;
    if (objectDesc instanceof SimpleIdentifiableElementDescription) {
      boolean _and = false;
      String _proposal = entry.getProposal();
      boolean _notEquals = (!Objects.equal(_proposal, "this"));
      if (!_notEquals) {
        _and = false;
      } else {
        String _proposal_1 = entry.getProposal();
        boolean _notEquals_1 = (!Objects.equal(_proposal_1, "super"));
        _and = _notEquals_1;
      }
      if (_and) {
        _matched=true;
        int _crossRefPriority = this.getCrossRefPriority();
        int _plus = (_crossRefPriority + 70);
        return this.adjustPriority(entry, _plus);
      }
    }
    if (!_matched) {
      if (objectDesc instanceof StaticFeatureDescriptionWithTypeLiteralReceiver) {
        _matched=true;
        int _crossRefPriority = this.getCrossRefPriority();
        int _plus = (_crossRefPriority + 60);
        return this.adjustPriority(entry, _plus);
      }
    }
    if (!_matched) {
      if (objectDesc instanceof IIdentifiableElementDescription) {
        _matched=true;
        JvmIdentifiableElement _elementOrProxy = ((IIdentifiableElementDescription)objectDesc).getElementOrProxy();
        boolean _matched_1 = false;
        if (_elementOrProxy instanceof JvmField) {
          _matched_1=true;
          int _crossRefPriority = this.getCrossRefPriority();
          int _plus = (_crossRefPriority + 50);
          return this.adjustPriority(entry, _plus);
        }
        if (!_matched_1) {
          if (_elementOrProxy instanceof JvmExecutable) {
            _matched_1=true;
            int _crossRefPriority = this.getCrossRefPriority();
            int _plus = (_crossRefPriority + 20);
            return this.adjustPriority(entry, _plus);
          }
        }
      }
    }
    return super.getCrossRefPriority(objectDesc, entry);
  }
  
  public int getTypeRefPriority(final ITypeDescriptor typeDesc, final ContentAssistEntry entry) {
    int _crossRefPriority = this.getCrossRefPriority();
    return this.adjustPriority(entry, _crossRefPriority);
  }
}
