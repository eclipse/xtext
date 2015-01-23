/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * Negative literals are not considered since they are parsed as unary expressions, so we
 * don't use as test inputs Short.MIN_VALUE, nor Byte.MIN_VALUE, which are negative values.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("all")
public class NumberLiteralTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public void resolvesNumberLiteralsWithExpectationsTo(final String literal, final String expectedType, final String expectedResult) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ val ");
      _builder.append(expectedType, "");
      _builder.append(" i = ");
      _builder.append(literal, "");
      _builder.append(" }");
      XExpression _expression = this.expression(_builder);
      final XBlockExpression block = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = block.getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XVariableDeclaration varDecl = ((XVariableDeclaration) _last);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(varDecl);
      XExpression _right = varDecl.getRight();
      final LightweightTypeReference rightExpressionType = resolvedTypes.getActualType(((XNumberLiteral) _right));
      JvmType _type = rightExpressionType.getType();
      String _simpleName = _type.getSimpleName();
      Assert.assertEquals(expectedResult, _simpleName);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWithNoExpectationResolveAsInt() {
    this.resolvesNumberLiteralsWithExpectationsTo("10", "", "int");
  }
  
  @Test
  public void testWithIntExpectationResolveAsInt() {
    this.resolvesNumberLiteralsWithExpectationsTo("10", "int", "int");
  }
  
  @Test
  public void testWithByteExpectationResolveAsByte() {
    this.resolvesNumberLiteralsWithExpectationsTo("10", "byte", "byte");
  }
  
  @Test
  public void testWithByteExpectationResolveAsByteWithMaxByte() {
    String _plus = (Integer.valueOf(((int) Byte.MAX_VALUE)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "byte", "byte");
  }
  
  @Test
  public void testWithByteExpectationResolveAsIntWithMaxBytePlusOne() {
    String _plus = (Integer.valueOf((((int) Byte.MAX_VALUE) + 1)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "byte", "int");
  }
  
  @Test
  public void testWithShortExpectationResolveAsShort() {
    this.resolvesNumberLiteralsWithExpectationsTo("10", "short", "short");
  }
  
  @Test
  public void testWithShortExpectationResolveAsShortWithMaxShort() {
    String _plus = (Integer.valueOf(((int) Short.MAX_VALUE)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "short", "short");
  }
  
  @Test
  public void testWithShortExpectationResolveAsIntWithMaxShortPlusOne() {
    String _plus = (Integer.valueOf((((int) Short.MAX_VALUE) + 1)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "short", "int");
  }
  
  @Test
  public void testWithCharExpectationResolveAsChar() {
    this.resolvesNumberLiteralsWithExpectationsTo("10", "char", "char");
  }
  
  @Test
  public void testWithCharExpectationResolveAsCharWithCharacterMaxValue() {
    String _plus = (Integer.valueOf(((int) Character.MAX_VALUE)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "char", "char");
  }
  
  @Test
  public void testWithCharExpectationResolveAsCharWithCharacterMinValue() {
    String _plus = (Integer.valueOf(((int) Character.MIN_VALUE)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "char", "char");
  }
  
  @Test
  public void testWithCharExpectationResolveAsIntWithCharacterMaxValuePlusOne() {
    String _plus = (Integer.valueOf((((int) Character.MAX_VALUE) + 1)) + "");
    this.resolvesNumberLiteralsWithExpectationsTo(_plus, "char", "int");
  }
}
