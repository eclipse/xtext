/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.google.common.base.Objects;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.idea.structureview.XtendEObjectTreeElement;
import org.eclipse.xtend.core.idea.structureview.XtendFeatureTreeElement;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.idea.structureview.DefaultComparator;
import org.eclipse.xtext.idea.structureview.EObjectTreeElement;
import org.eclipse.xtext.idea.structureview.EStructuralFeatureTreeElement;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendTreeElementComparator extends DefaultComparator {
  @Override
  public int getCategory(final TreeElement element) {
    int _xifexpression = (int) 0;
    if ((element instanceof XtendEObjectTreeElement)) {
      int _internalGetCategory = this.internalGetCategory(element);
      int _inheritanceDepth = ((XtendEObjectTreeElement)element).getInheritanceDepth();
      int _multiply = (100 * _inheritanceDepth);
      _xifexpression = (_internalGetCategory + _multiply);
    } else {
      _xifexpression = this.internalGetCategory(element);
    }
    return _xifexpression;
  }
  
  protected int internalGetCategory(final TreeElement element) {
    int _xblockexpression = (int) 0;
    {
      if ((element instanceof EStructuralFeatureTreeElement)) {
        int _xifexpression = (int) 0;
        EStructuralFeature _feature = ((EStructuralFeatureTreeElement)element).getFeature();
        boolean _equals = Objects.equal(_feature, XtendPackage.Literals.XTEND_FILE__PACKAGE);
        if (_equals) {
          _xifexpression = 0;
        } else {
          _xifexpression = 10;
        }
        return _xifexpression;
      }
      if ((element instanceof EObjectTreeElement)) {
        EObject _object = ((EObjectTreeElement)element).getObject();
        EClass _eClass = _object.eClass();
        final EClass eClass = _eClass;
        boolean _matched = false;
        boolean _isSuperTypeOf = XtendPackage.Literals.XTEND_TYPE_DECLARATION.isSuperTypeOf(eClass);
        if (_isSuperTypeOf) {
          _matched=true;
        }
        if (!_matched) {
          boolean _isSuperTypeOf_1 = TypesPackage.Literals.JVM_DECLARED_TYPE.isSuperTypeOf(eClass);
          if (_isSuperTypeOf_1) {
            _matched=true;
          }
        }
        if (!_matched) {
          boolean _isSuperTypeOf_2 = TypesPackage.Literals.JVM_ENUMERATION_LITERAL.isSuperTypeOf(eClass);
          if (_isSuperTypeOf_2) {
            _matched=true;
          }
        }
        if (_matched) {
          return 20;
        }
        if (!_matched) {
          if (Objects.equal(eClass, XtendPackage.Literals.XTEND_FIELD)) {
            _matched=true;
          }
          if (!_matched) {
            if (Objects.equal(eClass, TypesPackage.Literals.JVM_FIELD)) {
              _matched=true;
            }
          }
          if (_matched) {
            int _xifexpression_1 = (int) 0;
            boolean _isStatic = this.isStatic(element);
            if (_isStatic) {
              _xifexpression_1 = 30;
            } else {
              _xifexpression_1 = 50;
            }
            return _xifexpression_1;
          }
        }
        if (!_matched) {
          if (Objects.equal(eClass, XtendPackage.Literals.XTEND_CONSTRUCTOR)) {
            _matched=true;
          }
          if (!_matched) {
            if (Objects.equal(eClass, TypesPackage.Literals.JVM_CONSTRUCTOR)) {
              _matched=true;
            }
          }
          if (_matched) {
            return 60;
          }
        }
        if (!_matched) {
          if (Objects.equal(eClass, XtendPackage.Literals.XTEND_FUNCTION)) {
            _matched=true;
          }
          if (!_matched) {
            if (Objects.equal(eClass, TypesPackage.Literals.JVM_OPERATION)) {
              _matched=true;
            }
          }
          if (_matched) {
            int _xifexpression_2 = (int) 0;
            boolean _isStatic_1 = this.isStatic(element);
            if (_isStatic_1) {
              _xifexpression_2 = 40;
            } else {
              int _xifexpression_3 = (int) 0;
              boolean _isDispatch = this.isDispatch(element);
              if (_isDispatch) {
                _xifexpression_3 = 70;
              } else {
                _xifexpression_3 = 80;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            return _xifexpression_2;
          }
        }
      }
      _xblockexpression = Integer.MAX_VALUE;
    }
    return _xblockexpression;
  }
  
  protected boolean isStatic(final TreeElement element) {
    boolean _xifexpression = false;
    if ((element instanceof XtendFeatureTreeElement)) {
      _xifexpression = ((XtendFeatureTreeElement)element).isStatic();
    }
    return _xifexpression;
  }
  
  protected boolean isDispatch(final TreeElement element) {
    boolean _xifexpression = false;
    if ((element instanceof XtendFeatureTreeElement)) {
      _xifexpression = ((XtendFeatureTreeElement)element).isDispatch();
    }
    return _xifexpression;
  }
}
