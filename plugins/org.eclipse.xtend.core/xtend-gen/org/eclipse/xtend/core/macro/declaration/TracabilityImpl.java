/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.XtendNamedElementImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.services.Tracability;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class TracabilityImpl implements Tracability {
  private CompilationUnitImpl unit;
  
  public TracabilityImpl(final CompilationUnitImpl unit) {
    this.unit = unit;
  }
  
  public boolean isExternal(final NamedElement element) {
    boolean _and = false;
    boolean _isSource = this.isSource(element);
    boolean _not = (!_isSource);
    if (!_not) {
      _and = false;
    } else {
      boolean _isGenerated = this.isGenerated(element);
      boolean _not_1 = (!_isGenerated);
      _and = _not_1;
    }
    return _and;
  }
  
  public boolean isGenerated(final NamedElement element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof JvmNamedElementImpl) {
        _matched=true;
        JvmIdentifiableElement _delegate = ((JvmNamedElementImpl<? extends JvmIdentifiableElement>)element).getDelegate();
        Resource _eResource = _delegate.eResource();
        XtendFile _xtendFile = this.unit.getXtendFile();
        Resource _eResource_1 = _xtendFile.eResource();
        return Objects.equal(_eResource, _eResource_1);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public boolean isSource(final NamedElement element) {
    return (element instanceof XtendNamedElementImpl<?>);
  }
  
  public NamedElement getPrimaryGeneratedJavaElement(final NamedElement source) {
    boolean _isSource = this.isSource(source);
    if (_isSource) {
      IXtendJvmAssociations _jvmAssociations = this.unit.getJvmAssociations();
      EObject _delegate = ((XtendNamedElementImpl<?>) source).getDelegate();
      Set<EObject> _jvmElements = _jvmAssociations.getJvmElements(_delegate);
      Iterable<JvmIdentifiableElement> _filter = Iterables.<JvmIdentifiableElement>filter(_jvmElements, 
        JvmIdentifiableElement.class);
      final JvmIdentifiableElement derivedElement = IterableExtensions.<JvmIdentifiableElement>head(_filter);
      boolean _tripleNotEquals = (derivedElement != null);
      if (_tripleNotEquals) {
        return this.unit.toNamedElement(derivedElement);
      }
    } else {
      boolean _isGenerated = this.isGenerated(source);
      if (_isGenerated) {
        return source;
      }
    }
    return null;
  }
  
  public NamedElement getPrimarySourceElement(final NamedElement target) {
    boolean _isGenerated = this.isGenerated(target);
    if (_isGenerated) {
      IXtendJvmAssociations _jvmAssociations = this.unit.getJvmAssociations();
      JvmIdentifiableElement _delegate = ((JvmNamedElementImpl<?>) target).getDelegate();
      Set<EObject> _sourceElements = _jvmAssociations.getSourceElements(_delegate);
      final EObject sourceElement = IterableExtensions.<EObject>head(_sourceElements);
      if ((sourceElement instanceof XtendMember)) {
        return this.unit.toXtendMemberDeclaration(((XtendMember)sourceElement));
      } else {
        if ((sourceElement instanceof XtendParameter)) {
          return this.unit.toXtendParameterDeclaration(((XtendParameter)sourceElement));
        }
      }
    } else {
      boolean _isSource = this.isSource(target);
      if (_isSource) {
        return target;
      }
    }
    return null;
  }
  
  public boolean isThePrimaryGeneratedJavaElement(final NamedElement target) {
    boolean _xblockexpression = false;
    {
      final NamedElement source = this.getPrimarySourceElement(target);
      boolean _tripleEquals = (source == null);
      if (_tripleEquals) {
        return false;
      }
      NamedElement _primaryGeneratedJavaElement = this.getPrimaryGeneratedJavaElement(source);
      _xblockexpression = Objects.equal(_primaryGeneratedJavaElement, target);
    }
    return _xblockexpression;
  }
}
