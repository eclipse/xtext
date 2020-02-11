/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.annotations.Beta;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class JvmElementsProxifyingUnloader implements IReferableElementsUnloader {
  @Override
  public void unloadRoot(final EObject root) {
    boolean _matched = false;
    if (root instanceof JvmMember) {
      _matched=true;
      this.unloadRecursively(((JvmIdentifiableElement)root));
    }
  }
  
  protected void unloadRecursively(final JvmIdentifiableElement element) {
    boolean _matched = false;
    if (element instanceof JvmDeclaredType) {
      _matched=true;
      EList<JvmMember> _members = ((JvmDeclaredType)element).getMembers();
      for (final JvmMember child : _members) {
        this.unloadRecursively(child);
      }
      boolean _matched_1 = false;
      if (element instanceof JvmGenericType) {
        _matched_1=true;
        EList<JvmTypeParameter> _typeParameters = ((JvmGenericType)element).getTypeParameters();
        for (final JvmTypeParameter child_1 : _typeParameters) {
          this.unloadRecursively(child_1);
        }
      }
    }
    if (!_matched) {
      if (element instanceof JvmExecutable) {
        _matched=true;
        EList<JvmFormalParameter> _parameters = ((JvmExecutable)element).getParameters();
        for (final JvmFormalParameter child : _parameters) {
          this.unloadRecursively(child);
        }
        EList<JvmTypeParameter> _typeParameters = ((JvmExecutable)element).getTypeParameters();
        for (final JvmTypeParameter child_1 : _typeParameters) {
          this.unloadRecursively(child_1);
        }
      }
    }
    element.eAdapters().clear();
    ((InternalEObject) element).eSetProxyURI(EcoreUtil.getURI(element));
  }
}
