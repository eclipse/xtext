/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse def License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SynonmyTypesTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  @Extension
  private SynonymTypesProvider _synonymTypesProvider;
  
  public List<JvmTypeParameter> getDeclaredTypeParameters() {
    List<JvmTypeParameter> _emptyList = CollectionLiterals.<JvmTypeParameter>emptyList();
    return _emptyList;
  }
  
  public void hasSynonyms(final String type, final String... expectedSynonyms) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(type, null);
    this.hasSynonyms(_mappedTo, expectedSynonyms);
  }
  
  public void hasSynonyms(final Pair<String,String> typeAndTypeParams, final String... expectedSynonyms) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = typeAndTypeParams.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = typeAndTypeParams.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = typeAndTypeParams.getKey();
      _builder.append(_key, "");
      _builder.append(" p) {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      LightweightTypeReference _xifexpression = null;
      String _key_1 = typeAndTypeParams.getKey();
      boolean _notEquals = (!Objects.equal(_key_1, null));
      if (_notEquals) {
        EList<JvmFormalParameter> _parameters = operation.getParameters();
        JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
        JvmTypeReference _parameterType = _head.getParameterType();
        LightweightTypeReference _lightweightReference = this.toLightweightReference(_parameterType);
        _xifexpression = _lightweightReference;
      } else {
        AnyTypeReference _anyTypeReference = new AnyTypeReference(this);
        _xifexpression = _anyTypeReference;
      }
      final LightweightTypeReference primary = _xifexpression;
      final HashSet<String> actualSynonyms = CollectionLiterals.<String>newHashSet();
      final SynonymTypesProvider.Acceptor _function = new SynonymTypesProvider.Acceptor() {
        @Override
        protected boolean accept(final LightweightTypeReference type, final EnumSet<ConformanceHint> conformance) {
          String _simpleName = type.getSimpleName();
          boolean _add = actualSynonyms.add(_simpleName);
          return _add;
        }
      };
      this._synonymTypesProvider.collectSynonymTypes(primary, _function);
      String _string_1 = actualSynonyms.toString();
      int _length = expectedSynonyms.length;
      int _size = actualSynonyms.size();
      Assert.assertEquals(_string_1, _length, _size);
      String _string_2 = actualSynonyms.toString();
      boolean _containsAll = actualSynonyms.containsAll(((Collection<? extends Object>)Conversions.doWrapArray(expectedSynonyms)));
      Assert.assertTrue(_string_2, _containsAll);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInt() {
    this.hasSynonyms("int", "Integer");
    this.hasSynonyms("Integer", "int");
  }
  
  @Test
  public void testShort() {
    this.hasSynonyms("short", "Short");
    this.hasSynonyms("Short", "short");
  }
  
  @Test
  public void testDouble() {
    this.hasSynonyms("double", "Double");
    this.hasSynonyms("Double", "double");
  }
  
  @Test
  public void testBoolean() {
    this.hasSynonyms("boolean", "Boolean");
    this.hasSynonyms("Boolean", "boolean");
  }
  
  @Test
  public void testVoid() {
    this.hasSynonyms("void");
    this.hasSynonyms("Void");
  }
  
  @Test
  public void testListToArray() {
    this.hasSynonyms("char[]", "List<Character>");
    this.hasSynonyms("java.util.List<String>", "String[]");
  }
  
  @Test
  public void testIterableToArray_01() {
    this.hasSynonyms("Iterable<? extends Integer>", "Integer[]", "int[]");
  }
  
  @Test
  public void testArrayListToArray_02() {
    this.hasSynonyms("java.util.ArrayList<? extends Integer>", "Integer[]", "int[]");
  }
  
  @Test
  public void testListWithUpperBound_01() {
    this.hasSynonyms("java.util.List<? super Integer>", "Object[]");
  }
  
  @Test
  public void testListWithTypeParameter_01() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("java.util.List<T>", "T extends String");
    this.hasSynonyms(_mappedTo, "T[]");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("java.util.List<? extends T>", "T extends String");
    this.hasSynonyms(_mappedTo_1, "T[]");
  }
  
  @Test
  public void testListWithTypeParameter_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("java.util.List<T>", "T extends Integer");
    this.hasSynonyms(_mappedTo, "T[]", "int[]");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("java.util.List<? extends T>", "T extends Integer");
    this.hasSynonyms(_mappedTo_1, "T[]", "int[]");
  }
  
  @Test
  public void testArrayWithTypeParameter_01() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T[]", "T extends String");
    this.hasSynonyms(_mappedTo, "List<T>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("T[][]", "T extends String");
    this.hasSynonyms(_mappedTo_1, "List<T[]>");
  }
  
  @Test
  public void testArrayWithTypeParameter_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T[]", "T extends Integer");
    this.hasSynonyms(_mappedTo, "List<T>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("T[][]", "T extends Integer");
    this.hasSynonyms(_mappedTo_1, "List<T[]>");
  }
  
  @Test
  public void testTypeParameter_01() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "V, T extends Iterable<V>");
    this.hasSynonyms(_mappedTo, "V[]");
  }
  
  @Test
  public void testTypeParameter_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T extends Iterable<Integer>");
    this.hasSynonyms(_mappedTo, "Integer[]", "int[]");
  }
  
  @Test
  public void testTypeParameter_03() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "V extends Integer, T extends Iterable<V>");
    this.hasSynonyms(_mappedTo, "V[]", "int[]");
  }
}
