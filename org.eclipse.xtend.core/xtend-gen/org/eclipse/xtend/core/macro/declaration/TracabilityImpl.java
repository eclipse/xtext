/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.services.Tracability;
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

  @Override
  public Element getPrimaryGeneratedJavaElement(final Element source) {
    boolean _isSource = this.isSource(source);
    if (_isSource) {
      final EObject derivedElement = IterableExtensions.<EObject>head(this.unit.getJvmModelAssociations().getJvmElements(((AbstractElementImpl<?>) source).getDelegate()));
      if ((derivedElement != null)) {
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

  @Override
  public Element getPrimarySourceElement(final Element target) {
    boolean _isGenerated = this.isGenerated(target);
    if (_isGenerated) {
      final EObject sourceElement = IterableExtensions.<EObject>head(this.unit.getJvmModelAssociations().getSourceElements(((AbstractElementImpl<?>) target).getDelegate()));
      return this.unit.toXtendElement(sourceElement);
    } else {
      boolean _isSource = this.isSource(target);
      if (_isSource) {
        return target;
      }
    }
    return null;
  }

  @Override
  public boolean isExternal(final Element element) {
    return ((!this.isSource(element)) && (!this.isGenerated(element)));
  }

  @Override
  public boolean isGenerated(final Element element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (element instanceof JvmElementImpl) {
      _matched=true;
      Resource _eResource = ((JvmElementImpl<?>)element).getDelegate().eResource();
      Resource _eResource_1 = this.unit.getXtendFile().eResource();
      return Objects.equal(_eResource, _eResource_1);
    }
    if (!_matched) {
      if (element instanceof JvmTypeParameterDeclarationImpl) {
        _matched=true;
        Resource _eResource = ((JvmTypeParameterDeclarationImpl)element).getDelegate().eResource();
        Resource _eResource_1 = this.unit.getXtendFile().eResource();
        return Objects.equal(_eResource, _eResource_1);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }

  @Override
  public boolean isSource(final Element element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (element instanceof XtendNamedElementImpl) {
      _matched=true;
      _switchResult = true;
    }
    if (!_matched) {
      if (element instanceof XtendAnnotationReferenceImpl) {
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

  @Override
  public boolean isThePrimaryGeneratedJavaElement(final Element target) {
    boolean _xblockexpression = false;
    {
      final Element source = this.getPrimarySourceElement(target);
      if ((source == null)) {
        return false;
      }
      Element _primaryGeneratedJavaElement = this.getPrimaryGeneratedJavaElement(source);
      _xblockexpression = Objects.equal(_primaryGeneratedJavaElement, target);
    }
    return _xblockexpression;
  }
}
