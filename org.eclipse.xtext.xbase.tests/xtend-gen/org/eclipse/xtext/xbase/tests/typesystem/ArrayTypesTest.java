/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ArrayTypesTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Test
  public void testTryConvertToArray_01() {
    final LightweightTypeReference typeReference = this.toTypeReference("Iterable<?>");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("Object[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_02() {
    final LightweightTypeReference typeReference = this.toTypeReference("Iterable<? extends String>");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("String[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_03() {
    final LightweightTypeReference typeReference = this.toTypeReference("java.util.Collection");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("Object[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_04() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StringIterable");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("String[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_05() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.CharSequenceIterable");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("Object[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_06() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.CharSequenceIterable<StringBuffer>");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("StringBuffer[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_07() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeIterable");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("Object[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_08() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeIterable<String>");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("Object[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_09() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeStringIterable");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("Object[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_10() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeStringIterable<Integer>");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("String[]", arrayType.getSimpleName());
  }
  
  @Test
  public void testTryConvertToArray_11() {
    final LightweightTypeReference typeReference = this.toTypeReference("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.IterableContainer<String>.Iter");
    final ArrayTypeReference arrayType = typeReference.tryConvertToArray();
    Assert.assertEquals("String[]", arrayType.getSimpleName());
  }
  
  protected LightweightTypeReference toTypeReference(final String reference) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("null as ");
      _builder.append(reference);
      final String expression = _builder.toString();
      XExpression _expression = this.expression(expression);
      final XCastedExpression castExpression = ((XCastedExpression) _expression);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(castExpression);
      return resolvedTypes.getActualType(castExpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
