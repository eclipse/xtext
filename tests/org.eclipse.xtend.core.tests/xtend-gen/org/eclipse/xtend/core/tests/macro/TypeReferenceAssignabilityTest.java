/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
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
      EObject _rootContainer = EcoreUtil.getRootContainer(function);
      final XtendFile xtendFile = ((XtendFile) _rootContainer);
      final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
        @Override
        public void apply(final CompilationUnitImpl it) {
          TypeReference _xifexpression = null;
          String _key = lhsAndParams.getKey();
          boolean _notEquals = (!Objects.equal(_key, null));
          if (_notEquals) {
            EList<JvmFormalParameter> _parameters = operation.getParameters();
            JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
            JvmTypeReference _parameterType = _head.getParameterType();
            _xifexpression = it.toTypeReference(_parameterType);
          } else {
            ITypeReferenceOwner _owner = TypeReferenceAssignabilityTest.this.getOwner();
            AnyTypeReference _newAnyTypeReference = _owner.newAnyTypeReference();
            _xifexpression = it.toTypeReference(_newAnyTypeReference);
          }
          final TypeReference lhsType = _xifexpression;
          TypeReference _xifexpression_1 = null;
          boolean _notEquals_1 = (!Objects.equal(rhs, null));
          if (_notEquals_1) {
            EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
            JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
            JvmTypeReference _parameterType_1 = _last.getParameterType();
            _xifexpression_1 = it.toTypeReference(_parameterType_1);
          } else {
            ITypeReferenceOwner _owner_1 = TypeReferenceAssignabilityTest.this.getOwner();
            AnyTypeReference _newAnyTypeReference_1 = _owner_1.newAnyTypeReference();
            _xifexpression_1 = it.toTypeReference(_newAnyTypeReference_1);
          }
          final TypeReference rhsType = _xifexpression_1;
          String _simpleName = lhsType.getSimpleName();
          String _plus = (_simpleName + " := ");
          String _simpleName_1 = rhsType.getSimpleName();
          String _plus_1 = (_plus + _simpleName_1);
          boolean _testIsAssignable = TypeReferenceAssignabilityTest.this.testIsAssignable(it, lhsType, rhsType);
          Assert.assertEquals(_plus_1, Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable));
          if (expectation) {
            Iterable<? extends TypeReference> _declaredSuperTypes = lhsType.getDeclaredSuperTypes();
            for (final TypeReference superType : _declaredSuperTypes) {
              if (((superType.isArray() == lhsType.isArray()) || (lhsType.isArray() == rhsType.isArray()))) {
                String _string = superType.toString();
                boolean _testIsAssignable_1 = TypeReferenceAssignabilityTest.this.testIsAssignable(it, superType, rhsType);
                Assert.assertEquals(_string, Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable_1));
              }
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
    boolean _doIsAssignable = this.doIsAssignable(lhs, lhs);
    Assert.assertTrue(_doIsAssignable);
    boolean _doIsAssignable_1 = this.doIsAssignable(rhs, rhs);
    Assert.assertTrue(_doIsAssignable_1);
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
