/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.override.InvokedResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class InvokedResolvedOperationTest extends AbstractXbaseTestCase {
  @Inject
  private InvokedResolvedOperation.Provider invokedOperationProvider;
  
  public InvokedResolvedOperation toOperation(final String expression) {
    try {
      XExpression _expression = this.expression(expression);
      final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _expression);
      return this.invokedOperationProvider.resolve(featureCall);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIteratorOfObject() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.iterator");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("Iterator<Object>", _simpleName);
    LightweightTypeReference _contextType = operation.getContextType();
    String _simpleName_1 = _contextType.getSimpleName();
    Assert.assertEquals("ArrayList<Object>", _simpleName_1);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("iterator()", _simpleSignature);
  }
  
  @Test
  public void testStaticMethod() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("ArrayList<Object>", _simpleName);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("newArrayList(Object[])", _simpleSignature);
  }
  
  @Test
  public void testToArray_01() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.toArray");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("Object[]", _simpleName);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("toArray()", _simpleSignature);
  }
  
  @Test
  public void testToArray_02() {
    final InvokedResolvedOperation operation = this.toOperation("<String>newArrayList.toArray");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("Object[]", _simpleName);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("toArray()", _simpleSignature);
  }
  
  @Test
  public void testToArrayWithParam_01() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.toArray(null as String[])");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("String[]", _simpleName);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("toArray(String[])", _simpleSignature);
  }
  
  @Test
  public void testToArrayWithParam_02() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.<CharSequence>toArray(null as String[])");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("CharSequence[]", _simpleName);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("toArray(CharSequence[])", _simpleSignature);
  }
  
  @Test
  public void testArrayListOfStringIteratesStrings() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList(\"\").iterator");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("Iterator<String>", _simpleName);
    LightweightTypeReference _contextType = operation.getContextType();
    String _simpleName_1 = _contextType.getSimpleName();
    Assert.assertEquals("ArrayList<String>", _simpleName_1);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("iterator()", _simpleSignature);
  }
  
  @Test
  public void testTypeArguments_01() {
    final InvokedResolvedOperation operation = this.toOperation("(null as overrides.AbstractForCharSequence).method");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("CharSequence", _simpleName);
    List<JvmTypeParameter> _resolvedTypeParameters = operation.getResolvedTypeParameters();
    final Function1<JvmTypeParameter, CharSequence> _function = (JvmTypeParameter it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<JvmTypeParameter>join(_resolvedTypeParameters, ", ", _function);
    Assert.assertEquals("V, K", _join);
    List<LightweightTypeReference> _resolvedTypeArguments = operation.getResolvedTypeArguments();
    final Function1<LightweightTypeReference, CharSequence> _function_1 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join_1 = IterableExtensions.<LightweightTypeReference>join(_resolvedTypeArguments, ", ", _function_1);
    Assert.assertEquals("CharSequence, CharSequence", _join_1);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("method(Class<? extends CharSequence>)", _simpleSignature);
  }
  
  @Test
  public void testTypeArguments_02() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList(1, 1d)");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("ArrayList<Number & Comparable<?>>", _simpleName);
    List<LightweightTypeReference> _resolvedTypeArguments = operation.getResolvedTypeArguments();
    final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(_resolvedTypeArguments, ", ", _function);
    Assert.assertEquals("Number & Comparable<?>", _join);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("newArrayList(Number & Comparable<?>[])", _simpleSignature);
  }
  
  @Test
  public void testTypeArguments_03() {
    final InvokedResolvedOperation operation = this.toOperation("(newArrayList() as Iterable<? extends String>).toList");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("List<? extends String>", _simpleName);
    List<LightweightTypeReference> _resolvedTypeArguments = operation.getResolvedTypeArguments();
    final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(_resolvedTypeArguments, ", ", _function);
    Assert.assertEquals("? extends String", _join);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("toList(Iterable<? extends String>)", _simpleSignature);
  }
  
  @Test
  public void testExplicitTypeArguments() {
    final InvokedResolvedOperation operation = this.toOperation("(null as overrides.AbstractForCharSequence).<String, StringBuilder>method");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    List<JvmTypeParameter> _resolvedTypeParameters = operation.getResolvedTypeParameters();
    final Function1<JvmTypeParameter, CharSequence> _function = (JvmTypeParameter it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<JvmTypeParameter>join(_resolvedTypeParameters, ", ", _function);
    Assert.assertEquals("V, K", _join);
    List<LightweightTypeReference> _resolvedTypeArguments = operation.getResolvedTypeArguments();
    final Function1<LightweightTypeReference, CharSequence> _function_1 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join_1 = IterableExtensions.<LightweightTypeReference>join(_resolvedTypeArguments, ", ", _function_1);
    Assert.assertEquals("String, StringBuilder", _join_1);
    String _simpleSignature = operation.getSimpleSignature();
    Assert.assertEquals("method(Class<? extends String>)", _simpleSignature);
  }
}
