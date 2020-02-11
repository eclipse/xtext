/**
 * Copyright (c) 2019 TypeFox (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.serializer;

import com.google.inject.Inject;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;

/**
 * Customized reference updater to handle FQN renaming gracefully.
 * 
 * <p>
 * When renaming {@code Foo} to {@code Bar}, it follows the default logic,
 * but when renaming {@code my.type.Foo} to {@code Bar}, it will result
 * in {@code my.type.Bar} instead of {@code Bar}.
 */
@SuppressWarnings("all")
public class TestLanguageReferenceUpdater extends ReferenceUpdater {
  @Inject
  private IQualifiedNameConverter nameConverter;
  
  @Inject
  @SerializerScopeProviderBinding
  private IScopeProvider scopeProvider;
  
  @Override
  public void updateReference(final ITextRegionDiffBuilder rewriter, final IUpdatableReference it) {
    boolean _isModified = rewriter.isModified(it.getReferenceRegion());
    if (_isModified) {
      return;
    }
    final IScope scope = this.scopeProvider.getScope(it.getSourceEObject(), it.getEReference());
    final ISemanticRegion region = it.getReferenceRegion();
    final QualifiedName oldName = this.nameConverter.toQualifiedName(region.getText());
    final IEObjectDescription oldDesc = scope.getSingleElement(oldName);
    if (((oldDesc != null) && (oldDesc.getEObjectOrProxy() == it.getTargetEObject()))) {
      return;
    }
    String newName = this.findValidName(it, scope);
    if ((newName != null)) {
      int _segmentCount = oldName.getSegmentCount();
      boolean _greaterThan = (_segmentCount > 1);
      if (_greaterThan) {
        newName = oldName.skipLast(1).append(newName).toString();
      }
      rewriter.replace(region, newName);
    }
  }
}
