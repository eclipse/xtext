/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.typesystem.AssignabilityTest;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class OldAPIAssignabilityTest extends AssignabilityTest {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private TypeConformanceComputer conformanceComputer;
  
  public void isAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs, final boolean expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = lhsAndParams.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = lhsAndParams.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = lhsAndParams.getKey();
      String _fixup = this.fixup(_key);
      _builder.append(_fixup, "");
      _builder.append(" lhs, ");
      String _fixup_1 = this.fixup(rhs);
      _builder.append(_fixup_1, "");
      _builder.append(" rhs) {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      JvmTypeReference _xifexpression = null;
      String _key_1 = lhsAndParams.getKey();
      boolean _notEquals = (!Objects.equal(_key_1, null));
      if (_notEquals) {
        EList<JvmFormalParameter> _parameters = operation.getParameters();
        JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
        _xifexpression = _head.getParameterType();
      } else {
        _xifexpression = TypesFactory.eINSTANCE.createJvmAnyTypeReference();
      }
      final JvmTypeReference lhsType = _xifexpression;
      JvmTypeReference _xifexpression_1 = null;
      boolean _notEquals_1 = (!Objects.equal(rhs, null));
      if (_notEquals_1) {
        EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
        JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
        _xifexpression_1 = _last.getParameterType();
      } else {
        _xifexpression_1 = TypesFactory.eINSTANCE.createJvmAnyTypeReference();
      }
      final JvmTypeReference rhsType = _xifexpression_1;
      boolean _isConformant = this.conformanceComputer.isConformant(lhsType, rhsType);
      Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_isConformant));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
