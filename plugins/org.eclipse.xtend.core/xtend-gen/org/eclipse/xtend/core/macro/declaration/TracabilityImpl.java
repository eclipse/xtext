/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmElementImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.XtendNamedElementImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.services.Tracability;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
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
    return this.isExternal(((Element) element));
  }
  
  public boolean isGenerated(final NamedElement element) {
    return this.isGenerated(((Element) element));
  }
  
  public boolean isSource(final NamedElement element) {
    return this.isSource(((Element) element));
  }
  
  public NamedElement getPrimaryGeneratedJavaElement(final NamedElement source) {
    Element _primaryGeneratedJavaElement = this.getPrimaryGeneratedJavaElement(((Element) source));
    return ((NamedElement) _primaryGeneratedJavaElement);
  }
  
  public NamedElement getPrimarySourceElement(final NamedElement target) {
    Element _primarySourceElement = this.getPrimarySourceElement(((Element) target));
    return ((NamedElement) _primarySourceElement);
  }
  
  public boolean isThePrimaryGeneratedJavaElement(final NamedElement target) {
    return this.isThePrimaryGeneratedJavaElement(((Element) target));
  }
  
  public Element getPrimaryGeneratedJavaElement(final Element source) {
    boolean _isSource = this.isSource(source);
    if (_isSource) {
      IXtendJvmAssociations _jvmAssociations = this.unit.getJvmAssociations();
      EObject _delegate = ((AbstractElementImpl<?>) source).getDelegate();
      Set<EObject> _jvmElements = _jvmAssociations.getJvmElements(_delegate);
      final EObject derivedElement = IterableExtensions.<EObject>head(_jvmElements);
      boolean _tripleNotEquals = (derivedElement != null);
      if (_tripleNotEquals) {
        return this.unit.toJvmElement(derivedElement);
      }
    } else {
      boolean _isGenerated = this.isGenerated(source);
      if (_isGenerated) {
        return source;
      }
    }
    return null;
  }
  
  public Element getPrimarySourceElement(final Element target) {
    boolean _isGenerated = this.isGenerated(target);
    if (_isGenerated) {
      IXtendJvmAssociations _jvmAssociations = this.unit.getJvmAssociations();
      EObject _delegate = ((AbstractElementImpl<?>) target).getDelegate();
      Set<EObject> _sourceElements = _jvmAssociations.getSourceElements(_delegate);
      final EObject sourceElement = IterableExtensions.<EObject>head(_sourceElements);
      return this.unit.toXtendElement(sourceElement);
    } else {
      boolean _isSource = this.isSource(target);
      if (_isSource) {
        return target;
      }
    }
    return null;
  }
  
  public boolean isExternal(final Element element) {
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
  
  public boolean isGenerated(final Element element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof JvmElementImpl) {
        _matched=true;
        EObject _delegate = ((JvmElementImpl<?>)element).getDelegate();
        Resource _eResource = _delegate.eResource();
        XtendFile _xtendFile = this.unit.getXtendFile();
        Resource _eResource_1 = _xtendFile.eResource();
        return Objects.equal(_eResource, _eResource_1);
      }
    }
    if (!_matched) {
      if (element instanceof JvmTypeParameterDeclarationImpl) {
        _matched=true;
        JvmTypeParameter _delegate = ((JvmTypeParameterDeclarationImpl)element).getDelegate();
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
  
  public boolean isSource(final Element element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XtendNamedElementImpl) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (element instanceof Expression) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (element instanceof TypeReferenceImpl) {
        JvmTypeReference _source = ((TypeReferenceImpl)element).getSource();
        boolean _tripleNotEquals = (_source != null);
        if (_tripleNotEquals) {
          _matched=true;
          _switchResult = true;
        }
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public boolean isThePrimaryGeneratedJavaElement(final Element target) {
    boolean _xblockexpression = false;
    {
      final Element source = this.getPrimarySourceElement(target);
      boolean _tripleEquals = (source == null);
      if (_tripleEquals) {
        return false;
      }
      Element _primaryGeneratedJavaElement = this.getPrimaryGeneratedJavaElement(source);
      _xblockexpression = Objects.equal(_primaryGeneratedJavaElement, target);
    }
    return _xblockexpression;
  }
}
