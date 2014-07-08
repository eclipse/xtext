/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;

@SuppressWarnings("all")
public abstract class JvmElementImpl<T extends EObject> extends AbstractElementImpl<T> {
  public void remove() {
    this.checkMutable();
    T _delegate = this.getDelegate();
    Resource _eResource = _delegate.eResource();
    boolean _notEquals = (!Objects.equal(_eResource, null));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("This element has already been removed: ");
    T _delegate_1 = this.getDelegate();
    _builder.append(_delegate_1, "");
    Preconditions.checkState(_notEquals, _builder);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    IJvmModelAssociator _jvmModelAssociator = _compilationUnit.getJvmModelAssociator();
    T _delegate_2 = this.getDelegate();
    _jvmModelAssociator.removeAllAssociation(_delegate_2);
    T _delegate_3 = this.getDelegate();
    EcoreUtil.remove(_delegate_3);
    T _delegate_4 = this.getDelegate();
    Resource _eResource_1 = _delegate_4.eResource();
    boolean _equals = Objects.equal(_eResource_1, null);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Couldn\'t remove: ");
    T _delegate_5 = this.getDelegate();
    _builder_1.append(_delegate_5, "");
    Preconditions.checkState(_equals, _builder_1);
  }
  
  protected final void checkMutable() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    boolean _isModifyAllowed = _compilationUnit.isModifyAllowed();
    boolean _not = (!_isModifyAllowed);
    if (_not) {
      throw new IllegalStateException("Element cannot be modified after the transformation phase");
    }
  }
}
