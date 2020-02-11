/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
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
    Assert.assertEquals("Iterator<Object>", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("ArrayList<Object>", operation.getContextType().getSimpleName());
    Assert.assertEquals("iterator()", operation.getSimpleSignature());
  }
  
  @Test
  public void testStaticMethod() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList");
    Assert.assertEquals("ArrayList<Object>", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("newArrayList()", operation.getSimpleSignature());
  }
  
  @Test
  public void testStaticMethod_02() {
    final InvokedResolvedOperation operation = this.toOperation("newImmutableList");
    Assert.assertEquals("List<Object>", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("newImmutableList(Object[])", operation.getSimpleSignature());
  }
  
  @Test
  public void testToArray_01() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.toArray");
    Assert.assertEquals("Object[]", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("toArray()", operation.getSimpleSignature());
  }
  
  @Test
  public void testToArray_02() {
    final InvokedResolvedOperation operation = this.toOperation("<String>newArrayList.toArray");
    Assert.assertEquals("Object[]", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("toArray()", operation.getSimpleSignature());
  }
  
  @Test
  public void testToArrayWithParam_01() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.toArray(null as String[])");
    Assert.assertEquals("String[]", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("toArray(String[])", operation.getSimpleSignature());
  }
  
  @Test
  public void testToArrayWithParam_02() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList.<CharSequence>toArray(null as String[])");
    Assert.assertEquals("CharSequence[]", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("toArray(CharSequence[])", operation.getSimpleSignature());
  }
  
  @Test
  public void testArrayListOfStringIteratesStrings() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList(\"\").iterator");
    Assert.assertEquals("Iterator<String>", operation.getResolvedReturnType().getSimpleName());
    Assert.assertEquals("ArrayList<String>", operation.getContextType().getSimpleName());
    Assert.assertEquals("iterator()", operation.getSimpleSignature());
  }
  
  @Test
  public void testTypeArguments_01() {
    final InvokedResolvedOperation operation = this.toOperation("(null as overrides.AbstractForCharSequence).method");
    Assert.assertEquals("CharSequence", operation.getResolvedReturnType().getSimpleName());
    final Function1<JvmTypeParameter, CharSequence> _function = (JvmTypeParameter it) -> {
      return it.getSimpleName();
    };
    Assert.assertEquals("V, K", IterableExtensions.<JvmTypeParameter>join(operation.getResolvedTypeParameters(), ", ", _function));
    final Function1<LightweightTypeReference, CharSequence> _function_1 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    Assert.assertEquals("CharSequence, CharSequence", IterableExtensions.<LightweightTypeReference>join(operation.getResolvedTypeArguments(), ", ", _function_1));
    Assert.assertEquals("method(Class<? extends CharSequence>)", operation.getSimpleSignature());
  }
  
  @Test
  public void testTypeArguments_02() {
    final InvokedResolvedOperation operation = this.toOperation("newArrayList(1, 1d)");
    boolean _isJava12OrLater = AbstractXbaseTestCase.isJava12OrLater();
    if (_isJava12OrLater) {
      Assert.assertEquals("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>", operation.getResolvedReturnType().getSimpleName());
      final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
        return it.getSimpleName();
      };
      Assert.assertEquals("Number & Comparable<?> & Constable & ConstantDesc", IterableExtensions.<LightweightTypeReference>join(operation.getResolvedTypeArguments(), ", ", _function));
      Assert.assertEquals("newArrayList(Number & Comparable<?> & Constable & ConstantDesc[])", operation.getSimpleSignature());
    } else {
      Assert.assertEquals("ArrayList<Number & Comparable<?>>", operation.getResolvedReturnType().getSimpleName());
      final Function1<LightweightTypeReference, CharSequence> _function_1 = (LightweightTypeReference it) -> {
        return it.getSimpleName();
      };
      Assert.assertEquals("Number & Comparable<?>", IterableExtensions.<LightweightTypeReference>join(operation.getResolvedTypeArguments(), ", ", _function_1));
      Assert.assertEquals("newArrayList(Number & Comparable<?>[])", operation.getSimpleSignature());
    }
  }
  
  @Test
  public void testTypeArguments_03() {
    final InvokedResolvedOperation operation = this.toOperation("(newArrayList() as Iterable<? extends String>).toList");
    Assert.assertEquals("List<? extends String>", operation.getResolvedReturnType().getSimpleName());
    final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    Assert.assertEquals("? extends String", IterableExtensions.<LightweightTypeReference>join(operation.getResolvedTypeArguments(), ", ", _function));
    Assert.assertEquals("toList(Iterable<? extends String>)", operation.getSimpleSignature());
  }
  
  @Test
  public void testExplicitTypeArguments() {
    final InvokedResolvedOperation operation = this.toOperation("(null as overrides.AbstractForCharSequence).<String, StringBuilder>method");
    Assert.assertEquals("String", operation.getResolvedReturnType().getSimpleName());
    final Function1<JvmTypeParameter, CharSequence> _function = (JvmTypeParameter it) -> {
      return it.getSimpleName();
    };
    Assert.assertEquals("V, K", IterableExtensions.<JvmTypeParameter>join(operation.getResolvedTypeParameters(), ", ", _function));
    final Function1<LightweightTypeReference, CharSequence> _function_1 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    Assert.assertEquals("String, StringBuilder", IterableExtensions.<LightweightTypeReference>join(operation.getResolvedTypeArguments(), ", ", _function_1));
    Assert.assertEquals("method(Class<? extends String>)", operation.getSimpleSignature());
  }
}
