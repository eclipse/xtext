/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.typesystem.CommonSuperTypeTest;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class OldAPICommonSuperTypeTest extends CommonSuperTypeTest {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private TypeConformanceComputer typeConformanceComputer;
  
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  @Inject
  @Extension
  private Primitives _primitives;
  
  public Object isSuperTypeOf(final Pair<String, String> superTypeAndParam, final String... types) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = superTypeAndParam.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = superTypeAndParam.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      {
        boolean _hasElements = false;
        for(final String type : types) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _fixup = this.fixup(type);
          _builder.append(_fixup, "");
          _builder.append(" t");
        }
      }
      _builder.append(") {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      final Function1<JvmFormalParameter, JvmTypeReference> _function = new Function1<JvmFormalParameter, JvmTypeReference>() {
        public JvmTypeReference apply(final JvmFormalParameter it) {
          return it.getParameterType();
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<JvmFormalParameter, JvmTypeReference>map(_parameters, _function);
      final ArrayList<JvmTypeReference> typeReferences = new ArrayList<JvmTypeReference>(_map);
      JvmTypeReference computedSuperType = this.typeConformanceComputer.getCommonSuperType(typeReferences);
      String _key = superTypeAndParam.getKey();
      String _simpleName = null;
      if (computedSuperType!=null) {
        _simpleName=computedSuperType.getSimpleName();
      }
      Assert.assertEquals(_key, _simpleName);
      Iterable<JvmTypeReference> _plus = Iterables.<JvmTypeReference>concat(typeReferences, typeReferences);
      List<JvmTypeReference> _list = IterableExtensions.<JvmTypeReference>toList(_plus);
      JvmTypeReference _commonSuperType = this.typeConformanceComputer.getCommonSuperType(_list);
      computedSuperType = _commonSuperType;
      String _key_1 = superTypeAndParam.getKey();
      String _simpleName_1 = null;
      if (computedSuperType!=null) {
        _simpleName_1=computedSuperType.getSimpleName();
      }
      Assert.assertEquals(_key_1, _simpleName_1);
      List<JvmTypeReference> _reverseView = ListExtensions.<JvmTypeReference>reverseView(typeReferences);
      JvmTypeReference _commonSuperType_1 = this.typeConformanceComputer.getCommonSuperType(_reverseView);
      computedSuperType = _commonSuperType_1;
      String _key_2 = superTypeAndParam.getKey();
      String _simpleName_2 = null;
      if (computedSuperType!=null) {
        _simpleName_2=computedSuperType.getSimpleName();
      }
      Assert.assertEquals(_key_2, _simpleName_2);
      boolean _or = false;
      boolean _is = false;
      if (computedSuperType!=null) {
        _is=this._typeReferences.is(computedSuperType, Void.TYPE);
      }
      if (_is) {
        _or = true;
      } else {
        boolean _isPrimitive = false;
        if (computedSuperType!=null) {
          _isPrimitive=this._primitives.isPrimitive(computedSuperType);
        }
        _or = _isPrimitive;
      }
      boolean _not_1 = (!_or);
      if (_not_1) {
        JvmAnyTypeReference _createJvmAnyTypeReference = TypesFactory.eINSTANCE.createJvmAnyTypeReference();
        JvmAnyTypeReference _createJvmAnyTypeReference_1 = TypesFactory.eINSTANCE.createJvmAnyTypeReference();
        List<JvmAnyTypeReference> _newImmutableList = CollectionLiterals.<JvmAnyTypeReference>newImmutableList(_createJvmAnyTypeReference, _createJvmAnyTypeReference_1);
        Iterable<JvmTypeReference> _plus_1 = Iterables.<JvmTypeReference>concat(typeReferences, _newImmutableList);
        List<JvmTypeReference> _list_1 = IterableExtensions.<JvmTypeReference>toList(_plus_1);
        JvmTypeReference _commonSuperType_2 = this.typeConformanceComputer.getCommonSuperType(_list_1);
        computedSuperType = _commonSuperType_2;
        String _key_3 = superTypeAndParam.getKey();
        String _simpleName_3 = null;
        if (computedSuperType!=null) {
          _simpleName_3=computedSuperType.getSimpleName();
        }
        Assert.assertEquals(_key_3, _simpleName_3);
      }
      return computedSuperType;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void isFunctionAndEquivalentTo(final Object reference, final String type) {
    Assert.assertTrue((reference instanceof XFunctionTypeRef));
    JvmTypeReference _equivalent = ((XFunctionTypeRef) reference).getEquivalent();
    String _simpleName = _equivalent.getSimpleName();
    Assert.assertEquals(type, _simpleName);
  }
}
