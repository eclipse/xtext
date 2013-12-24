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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.typesystem.AssignabilityTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeReferenceAssignabilityTest extends AssignabilityTest {
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  public void isAssignableFrom(final Pair<String,String> lhsAndParams, final String rhs, final boolean expectation) {
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
        public void apply(@Extension final CompilationUnitImpl unit) {
          LightweightTypeReference _xifexpression = null;
          String _key = lhsAndParams.getKey();
          boolean _notEquals = (!Objects.equal(_key, null));
          if (_notEquals) {
            EList<JvmFormalParameter> _parameters = operation.getParameters();
            JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
            JvmTypeReference _parameterType = _head.getParameterType();
            TypeReference _newTypeReference = TypeReferenceAssignabilityTest.this.newTypeReference(_parameterType, unit);
            LightweightTypeReference _lightweightTypeReference = unit.toLightweightTypeReference(_newTypeReference);
            _xifexpression = _lightweightTypeReference;
          } else {
            AnyTypeReference _anyTypeReference = new AnyTypeReference(TypeReferenceAssignabilityTest.this);
            _xifexpression = _anyTypeReference;
          }
          final LightweightTypeReference lhsType = _xifexpression;
          LightweightTypeReference _xifexpression_1 = null;
          boolean _notEquals_1 = (!Objects.equal(rhs, null));
          if (_notEquals_1) {
            EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
            JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
            JvmTypeReference _parameterType_1 = _last.getParameterType();
            TypeReference _newTypeReference_1 = TypeReferenceAssignabilityTest.this.newTypeReference(_parameterType_1, unit);
            LightweightTypeReference _lightweightTypeReference_1 = unit.toLightweightTypeReference(_newTypeReference_1);
            _xifexpression_1 = _lightweightTypeReference_1;
          } else {
            AnyTypeReference _anyTypeReference_1 = new AnyTypeReference(TypeReferenceAssignabilityTest.this);
            _xifexpression_1 = _anyTypeReference_1;
          }
          final LightweightTypeReference rhsType = _xifexpression_1;
          String _simpleName = lhsType.getSimpleName();
          String _plus = (_simpleName + " := ");
          String _simpleName_1 = rhsType.getSimpleName();
          String _plus_1 = (_plus + _simpleName_1);
          boolean _testIsAssignable = TypeReferenceAssignabilityTest.this.testIsAssignable(lhsType, rhsType);
          Assert.assertEquals(_plus_1, Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable));
          if (expectation) {
            List<LightweightTypeReference> _allSuperTypes = lhsType.getAllSuperTypes();
            for (final LightweightTypeReference superType : _allSuperTypes) {
              boolean _or = false;
              boolean _isArray = superType.isArray();
              boolean _isArray_1 = lhsType.isArray();
              boolean _equals = (_isArray == _isArray_1);
              if (_equals) {
                _or = true;
              } else {
                boolean _isArray_2 = lhsType.isArray();
                boolean _isArray_3 = rhsType.isArray();
                boolean _equals_1 = (_isArray_2 == _isArray_3);
                _or = (_equals || _equals_1);
              }
              if (_or) {
                String _string = superType.toString();
                boolean _testIsAssignable_1 = TypeReferenceAssignabilityTest.this.testIsAssignable(superType, rhsType);
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
  
  public boolean testIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    boolean _doIsAssignable = this.doIsAssignable(lhs, lhs);
    Assert.assertTrue(_doIsAssignable);
    JvmTypeReference _typeReference = lhs.toTypeReference();
    LightweightTypeReference _lightweightReference = this.toLightweightReference(_typeReference);
    boolean _doIsAssignable_1 = this.doIsAssignable(lhs, _lightweightReference);
    Assert.assertTrue(_doIsAssignable_1);
    JvmTypeReference _typeReference_1 = rhs.toTypeReference();
    LightweightTypeReference _lightweightReference_1 = this.toLightweightReference(_typeReference_1);
    boolean _doIsAssignable_2 = this.doIsAssignable(rhs, _lightweightReference_1);
    Assert.assertTrue(_doIsAssignable_2);
    final boolean result = this.doIsAssignable(lhs, rhs);
    boolean _isPrimitiveVoid = rhs.isPrimitiveVoid();
    boolean _not = (!_isPrimitiveVoid);
    if (_not) {
      ITypeReferenceOwner _owner = rhs.getOwner();
      WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(_owner);
      final WildcardTypeReference wcRhs = _wildcardTypeReference;
      LightweightTypeReference _wrapperTypeIfPrimitive = rhs.getWrapperTypeIfPrimitive();
      wcRhs.addUpperBound(_wrapperTypeIfPrimitive);
      boolean _doIsAssignable_3 = this.doIsAssignable(lhs, wcRhs);
      Assert.assertEquals(Boolean.valueOf(result), Boolean.valueOf(_doIsAssignable_3));
      ITypeReferenceOwner _owner_1 = rhs.getOwner();
      CompoundTypeReference _compoundTypeReference = new CompoundTypeReference(_owner_1, true);
      final CompoundTypeReference compoundRhs = _compoundTypeReference;
      compoundRhs.addComponent(rhs);
      ITypeReferenceOwner _owner_2 = rhs.getOwner();
      CommonTypeComputationServices _services = _owner_2.getServices();
      TypeReferences _typeReferences = _services.getTypeReferences();
      ITypeReferenceOwner _owner_3 = rhs.getOwner();
      ResourceSet _contextResourceSet = _owner_3.getContextResourceSet();
      final JvmType object = _typeReferences.findDeclaredType(Object.class, _contextResourceSet);
      ITypeReferenceOwner _owner_4 = rhs.getOwner();
      ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(_owner_4, object);
      compoundRhs.addComponent(_parameterizedTypeReference);
      String _plus = (lhs + " := ");
      String _string = compoundRhs.toString();
      String _plus_1 = (_plus + _string);
      boolean _doIsAssignable_4 = this.doIsAssignable(lhs, compoundRhs);
      Assert.assertEquals(_plus_1, Boolean.valueOf(result), Boolean.valueOf(_doIsAssignable_4));
    }
    return result;
  }
  
  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    block.apply(compilationUnit);
  }
  
  public TypeReference newTypeReference(final JvmTypeReference reference, @Extension final CompilationUnitImpl unit) {
    TypeReference _typeReference = unit.toTypeReference(reference);
    LightweightTypeReference _lightweightTypeReference = unit.toLightweightTypeReference(_typeReference);
    TypeReference _newTypeReference = this.newTypeReference(_lightweightTypeReference, unit);
    return _newTypeReference;
  }
  
  public TypeReference newTypeReference(final LightweightTypeReference reference, @Extension final CompilationUnitImpl unit) {
    TypeReference _xblockexpression = null;
    {
      @Extension
      final TypeReferenceProvider typeReferenceProvider = unit.getTypeReferenceProvider();
      List<LightweightTypeReference> _typeArguments = reference.getTypeArguments();
      final Function1<LightweightTypeReference,TypeReference> _function = new Function1<LightweightTypeReference,TypeReference>() {
        public TypeReference apply(final LightweightTypeReference it) {
          TypeReference _newTypeReference = TypeReferenceAssignabilityTest.this.newTypeReference(it, unit);
          return _newTypeReference;
        }
      };
      final List<TypeReference> typeArguments = ListExtensions.<LightweightTypeReference, TypeReference>map(_typeArguments, _function);
      final LightweightTypeReference invariantBoundSubstitute = reference.getInvariantBoundSubstitute();
      int depth = 0;
      LightweightTypeReference componentType = invariantBoundSubstitute;
      boolean _isArray = componentType.isArray();
      boolean _while = _isArray;
      while (_while) {
        {
          LightweightTypeReference _componentType = componentType.getComponentType();
          componentType = _componentType;
          depth = (depth + 1);
        }
        boolean _isArray_1 = componentType.isArray();
        _while = _isArray_1;
      }
      JvmType _type = componentType.getType();
      Type _type_1 = unit.toType(_type);
      TypeReference typeReference = typeReferenceProvider.newTypeReference(_type_1, ((TypeReference[])Conversions.unwrapArray(typeArguments, TypeReference.class)));
      boolean _isWildcard = reference.isWildcard();
      if (_isWildcard) {
        LightweightTypeReference _lowerBoundSubstitute = reference.getLowerBoundSubstitute();
        boolean _equals = Objects.equal(_lowerBoundSubstitute, invariantBoundSubstitute);
        if (_equals) {
          TypeReference _newWildcardTypeReferenceWithLowerBound = typeReferenceProvider.newWildcardTypeReferenceWithLowerBound(typeReference);
          typeReference = _newWildcardTypeReferenceWithLowerBound;
        } else {
          TypeReference _newWildcardTypeReference = typeReferenceProvider.newWildcardTypeReference(typeReference);
          typeReference = _newWildcardTypeReference;
        }
      }
      int i = 0;
      boolean _while_1 = (i < depth);
      while (_while_1) {
        {
          i = (i + 1);
          TypeReference _newArrayTypeReference = typeReferenceProvider.newArrayTypeReference(typeReference);
          typeReference = _newArrayTypeReference;
        }
        _while_1 = (i < depth);
      }
      _xblockexpression = (typeReference);
    }
    return _xblockexpression;
  }
}
