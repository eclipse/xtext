/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.smoke;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Case_9 extends Case_8 {
  protected CharSequence _generateTypeRef(final ENamedElement c) {
    CharSequence _xifexpression = null;
    EObject _eContainer = c.eContainer();
    boolean _tripleNotEquals = (_eContainer != null);
    if (_tripleNotEquals) {
      _xifexpression = this.generateTypeRef(c.eContainer());
    } else {
      CharSequence _xifexpression_1 = null;
      boolean _eIsProxy = c.eIsProxy();
      if (_eIsProxy) {
        StringConcatenation _builder = new StringConcatenation();
        String _name = c.getName();
        _builder.append(_name);
        _xifexpression_1 = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  protected CharSequence _generateTypeRef(final EObject o) {
    return this.generateTypeRef(o.eContainer());
  }

  @Override
  public <T1 extends Object> List<List<T1>> foo(final T1 t) {
    final List<List<T1>> x = super.<T1>foo(t);
    x.toString();
    return null;
  }

  public CharSequence generateTypeRef(final EObject c) {
    if (c instanceof ENamedElement) {
      return _generateTypeRef((ENamedElement)c);
    } else if (c != null) {
      return _generateTypeRef(c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
