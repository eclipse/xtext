/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.smoke;

import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Case_6 {
  protected Object _transform(final EPackage packageDecl) {
    final Function1<EObject, Object> _function = (EObject e) -> {
      return this.transform(((EStructuralFeature) e));
    };
    return ListExtensions.<EObject, Object>map(packageDecl.eContents(), _function);
  }

  protected Object _transform(final EStructuralFeature entity) {
    ArrayList<EObject> _xblockexpression = null;
    {
      final Object inferredType = null;
      _xblockexpression = CollectionLiterals.<EObject>newArrayList(((EObject) ((EObject)inferredType)));
    }
    return _xblockexpression;
  }

  protected Object _transform(final EClass model) {
    final Function1<ETypeParameter, Object> _function = (ETypeParameter e) -> {
      return this.transform(e);
    };
    return ListExtensions.<ETypeParameter, Object>map(model.getETypeParameters(), _function);
  }

  public Object transform(final ENamedElement model) {
    if (model instanceof EClass) {
      return _transform((EClass)model);
    } else if (model instanceof EStructuralFeature) {
      return _transform((EStructuralFeature)model);
    } else if (model instanceof EPackage) {
      return _transform((EPackage)model);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model).toString());
    }
  }
}
