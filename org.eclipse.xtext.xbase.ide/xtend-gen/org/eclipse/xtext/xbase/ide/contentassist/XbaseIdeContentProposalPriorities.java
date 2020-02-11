/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Objects;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.StaticFeatureDescriptionWithTypeLiteralReceiver;

@SuppressWarnings("all")
public class XbaseIdeContentProposalPriorities extends IdeContentProposalPriorities {
  @Override
  public int getCrossRefPriority(final IEObjectDescription objectDesc, final ContentAssistEntry entry) {
    if ((entry != null)) {
      boolean _matched = false;
      if (objectDesc instanceof SimpleIdentifiableElementDescription) {
        if (((!Objects.equal(entry.getProposal(), "this")) && (!Objects.equal(entry.getProposal(), "super")))) {
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
    }
    return super.getCrossRefPriority(objectDesc, entry);
  }
  
  public int getTypeRefPriority(final ITypeDescriptor typeDesc, final ContentAssistEntry entry) {
    return this.adjustPriority(entry, this.getCrossRefPriority());
  }
}
