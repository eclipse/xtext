/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractSuperTypesTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  public void assertSuperTypes(final Class<? extends Object> type, final String... superTypes) {
    String _canonicalName = type.getCanonicalName();
    Pair<String,String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    this.assertSuperTypes(_mappedTo, superTypes);
  }
  
  public void assertSuperTypes(final String type, final String... superTypes) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(type, null);
    this.assertSuperTypes(_mappedTo, superTypes);
  }
  
  public void assertSuperTypes(final Pair<String,String> type, final String... superTypes) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = type.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = type.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = type.getKey();
      _builder.append(_key, "");
      _builder.append(" type) {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      JvmTypeReference _parameterType = _head.getParameterType();
      final LightweightTypeReference subtype = this.toLightweightReference(_parameterType);
      List<String> _list = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(superTypes)));
      Iterable<LightweightTypeReference> _collectSuperTypes = this.collectSuperTypes(subtype);
      final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
        public String apply(final LightweightTypeReference it) {
          return it.getSimpleName();
        }
      };
      Iterable<String> _map = IterableExtensions.<LightweightTypeReference, String>map(_collectSuperTypes, _function);
      List<String> _list_1 = IterableExtensions.<String>toList(_map);
      Assert.assertEquals(_list, _list_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public abstract Iterable<LightweightTypeReference> collectSuperTypes(final LightweightTypeReference reference);
  
  @Test
  public void testObject() {
    this.assertSuperTypes("Object");
  }
  
  @Test
  public void testSerializable() {
    this.assertSuperTypes(Serializable.class, "Object");
  }
  
  @Test
  public abstract void testString();
  
  @Test
  public void testCollections() {
    this.assertSuperTypes(Collections.class, "Object");
  }
  
  @Test
  public abstract void testRawCollection();
  
  @Test
  public abstract void testStringCollection();
  
  @Test
  public abstract void testStringArray();
  
  @Test
  public abstract void testObjectArray();
  
  @Test
  public abstract void testPrimitiveArray();
  
  @Test
  public abstract void testRawList();
  
  @Test
  public abstract void testStringList();
  
  @Test
  public abstract void testStringArrayArrayList();
  
  @Test
  public abstract void testTypeParameters();
  
  @Test
  public abstract void testTypeParameterArray();
  
  @Test
  public abstract void testDependentTypeParameters();
  
  @Test
  public abstract void testDependentTypeParametersWithBounds();
  
  @Test
  public void testTypeParametersWithoutUpperBound() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T");
    this.assertSuperTypes(_mappedTo, "Object");
  }
}
