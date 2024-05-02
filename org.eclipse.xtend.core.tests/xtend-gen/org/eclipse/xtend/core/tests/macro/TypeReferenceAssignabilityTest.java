/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.typesystem.AssignabilityTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeReferenceAssignabilityTest extends AssignabilityTest {
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;

  @Override
  public void isAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs, final boolean expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(lhsAndParams.getValue());
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value = lhsAndParams.getValue();
          _builder.append(_value);
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _fixup = this.fixup(lhsAndParams.getKey());
      _builder.append(_fixup);
      _builder.append(" lhs, ");
      String _fixup_1 = this.fixup(rhs);
      _builder.append(_fixup_1);
      _builder.append(" rhs) {}");
      final String signature = _builder.toString();
      final XtendFunction function = this.function(signature.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EObject _rootContainer = EcoreUtil.getRootContainer(function);
      final XtendFile xtendFile = ((XtendFile) _rootContainer);
      final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
        TypeReference _xifexpression = null;
        String _key = lhsAndParams.getKey();
        boolean _tripleNotEquals = (_key != null);
        if (_tripleNotEquals) {
          _xifexpression = it.toTypeReference(IterableExtensions.<JvmFormalParameter>head(operation.getParameters()).getParameterType());
        } else {
          _xifexpression = it.toTypeReference(this.getOwner().newAnyTypeReference());
        }
        final TypeReference lhsType = _xifexpression;
        TypeReference _xifexpression_1 = null;
        if ((rhs != null)) {
          _xifexpression_1 = it.toTypeReference(IterableExtensions.<JvmFormalParameter>lastOrNull(operation.getParameters()).getParameterType());
        } else {
          _xifexpression_1 = it.toTypeReference(this.getOwner().newAnyTypeReference());
        }
        final TypeReference rhsType = _xifexpression_1;
        String _simpleName = lhsType.getSimpleName();
        String _plus = (_simpleName + " := ");
        String _simpleName_1 = rhsType.getSimpleName();
        String _plus_1 = (_plus + _simpleName_1);
        Assert.assertEquals(_plus_1, Boolean.valueOf(expectation), 
          Boolean.valueOf(this.testIsAssignable(it, lhsType, rhsType)));
        if (expectation) {
          Iterable<? extends TypeReference> _declaredSuperTypes = lhsType.getDeclaredSuperTypes();
          for (final TypeReference superType : _declaredSuperTypes) {
            if (((superType.isArray() == lhsType.isArray()) || (lhsType.isArray() == rhsType.isArray()))) {
              Assert.assertEquals(superType.toString(), Boolean.valueOf(expectation), Boolean.valueOf(this.testIsAssignable(it, superType, rhsType)));
            }
          }
        }
      };
      this.asCompilationUnit(xtendFile, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public boolean testIsAssignable(final CompilationUnitImpl unit, final TypeReference lhs, final TypeReference rhs) {
    Assert.assertTrue(this.doIsAssignable(lhs, lhs));
    Assert.assertTrue(this.doIsAssignable(rhs, rhs));
    final boolean result = this.doIsAssignable(lhs, rhs);
    return result;
  }

  public boolean doIsAssignable(final TypeReference lhs, final TypeReference rhs) {
    return lhs.isAssignableFrom(rhs);
  }

  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    block.apply(compilationUnit);
  }
}
