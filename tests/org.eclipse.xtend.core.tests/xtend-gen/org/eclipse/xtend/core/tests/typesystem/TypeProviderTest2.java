/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.typing.TypeProviderTest;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class TypeProviderTest2 extends TypeProviderTest {
  @Test
  public void testReturnTypeInConstructor_01() throws Exception {
    final XtendConstructor constructor = this.constructor("new() { \'\'.toString }");
    XExpression _expression = constructor.getExpression();
    final XBlockExpression body = ((XBlockExpression) _expression);
    ITypeProvider _typeProvider = this.getTypeProvider();
    JvmTypeReference _expectedType = _typeProvider.getExpectedType(body);
    String _identifier = _expectedType.getIdentifier();
    Assert.assertEquals("void", _identifier);
    ITypeProvider _typeProvider_1 = this.getTypeProvider();
    JvmTypeReference _expectedReturnType = _typeProvider_1.getExpectedReturnType(body, true);
    String _identifier_1 = _expectedReturnType.getIdentifier();
    Assert.assertEquals("void", _identifier_1);
    EList<XExpression> _expressions = body.getExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_expressions);
    final XMemberFeatureCall toString = ((XMemberFeatureCall) _head);
    ITypeProvider _typeProvider_2 = this.getTypeProvider();
    JvmTypeReference _expectedType_1 = _typeProvider_2.getExpectedType(toString);
    Assert.assertNull(_expectedType_1);
    ITypeProvider _typeProvider_3 = this.getTypeProvider();
    JvmTypeReference _expectedReturnType_1 = _typeProvider_3.getExpectedReturnType(toString, true);
    Assert.assertNull(_expectedReturnType_1);
  }
  
  @Test
  public void testTypeOfSuperInConstructor() throws Exception {
    final XtendConstructor constructor = this.constructor("new() { super() }");
    XExpression _expression = constructor.getExpression();
    final XBlockExpression body = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = body.getExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_expressions);
    final XFeatureCall superCall = ((XFeatureCall) _head);
    ITypeProvider _typeProvider = this.getTypeProvider();
    JvmTypeReference _type = _typeProvider.getType(superCall);
    String _identifier = _type.getIdentifier();
    Assert.assertEquals("void", _identifier);
    ITypeProvider _typeProvider_1 = this.getTypeProvider();
    JvmTypeReference _expectedType = _typeProvider_1.getExpectedType(superCall);
    Assert.assertNull(_expectedType);
    ITypeProvider _typeProvider_2 = this.getTypeProvider();
    JvmTypeReference _expectedReturnType = _typeProvider_2.getExpectedReturnType(superCall, true);
    Assert.assertNull(_expectedReturnType);
  }
  
  @Test
  public void testTypeOfThisInConstructor() throws Exception {
    final XtendConstructor constructor = this.constructor("new(int a) { this() } new() {}");
    XExpression _expression = constructor.getExpression();
    final XBlockExpression body = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = body.getExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_expressions);
    final XFeatureCall thisCall = ((XFeatureCall) _head);
    ITypeProvider _typeProvider = this.getTypeProvider();
    JvmTypeReference _type = _typeProvider.getType(thisCall);
    String _identifier = _type.getIdentifier();
    Assert.assertEquals("void", _identifier);
    ITypeProvider _typeProvider_1 = this.getTypeProvider();
    JvmTypeReference _expectedType = _typeProvider_1.getExpectedType(thisCall);
    Assert.assertNull(_expectedType);
    ITypeProvider _typeProvider_2 = this.getTypeProvider();
    JvmTypeReference _expectedReturnType = _typeProvider_2.getExpectedReturnType(thisCall, true);
    Assert.assertNull(_expectedReturnType);
  }
  
  @Test
  @Ignore(value = "TODO improve expectation if the expected type is an unresolved type parameter")
  public void testTypeOfRichStringWithExpectedString_2() throws Exception {
    super.testTypeOfRichStringWithExpectedString_2();
  }
  
  @Test
  @Ignore(value = "TODO improve expectation if the expected type is an unresolved type parameter")
  public void testTypeOfRichStringWithExpectedString_3() throws Exception {
    super.testTypeOfRichStringWithExpectedString_3();
  }
}
