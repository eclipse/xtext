/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OrderSensitivityTest extends AbstractXbaseTestCase {
  @Test
  public void testOverloadedMethods_01() {
    this.doTestOverloadedAndExpect("testdata.ordersensitivity.CaseA", "overloaded(chars, strings)", "overloaded(java.util.Collection,java.lang.Iterable)");
  }
  
  @Test
  public void testOverloadedMethods_02() {
    this.doTestOverloadedAndExpect("testdata.ordersensitivity.CaseB", "overloaded(chars, strings)", "overloaded(java.util.Collection,java.lang.Iterable)");
  }
  
  @Test
  public void testOverloadedMethods_03() {
    this.doTestOverloadedAndExpect("testdata.ordersensitivity.CaseA", "overloaded(strings, chars)", "overloaded(java.lang.Iterable,java.util.Collection)");
  }
  
  @Test
  public void testOverloadedMethods_04() {
    this.doTestOverloadedAndExpect("testdata.ordersensitivity.CaseB", "overloaded(strings, chars)", "overloaded(java.lang.Iterable,java.util.Collection)");
  }
  
  @Test
  public void testOverloadedClosureMethods_01() {
    this.doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseC", "\'hello\'", "RunnerWithResult");
  }
  
  @Test
  public void testOverloadedClosureMethods_02() {
    this.doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseD", "\'hello\'", "RunnerWithResult");
  }
  
  @Test
  public void testOverloadedClosureMethods_03() {
    this.doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseC", "System::out.println()", "Runner");
  }
  
  @Test
  public void testOverloadedClosureMethods_04() {
    this.doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseD", "System::out.println()", "Runner");
  }
  
  protected void doTestOverloadedAndExpect(final String declarator, final String invocation, final String expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var java.util.List<CharSequence> chars = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var java.util.List<String> strings = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var ");
      _builder.append(declarator, "\t");
      _builder.append(" receiver = null");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("receiver.");
      _builder.append(invocation, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      final XBlockExpression block = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = block.getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _last);
      final JvmIdentifiableElement feature = featureCall.getFeature();
      Assert.assertNotNull("feature is not null", feature);
      boolean _eIsProxy = feature.eIsProxy();
      Assert.assertFalse("feature is resolved", _eIsProxy);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(declarator, "");
      _builder_1.append(".");
      _builder_1.append(expectation, "");
      String _string = _builder_1.toString();
      String _identifier = feature.getIdentifier();
      Assert.assertEquals(_string, _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doTestClosureMethodAndExpect(final String declarator, final String expression, final String expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new ");
      _builder.append(declarator, "");
      _builder.append("().run [| ");
      _builder.append(expression, "");
      _builder.append(" ]");
      XExpression _expression = this.expression(_builder);
      final XMemberFeatureCall featureCall = ((XMemberFeatureCall) _expression);
      final JvmIdentifiableElement feature = featureCall.getFeature();
      Assert.assertNotNull("feature is not null", feature);
      boolean _eIsProxy = feature.eIsProxy();
      Assert.assertFalse("feature is resolved", _eIsProxy);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(declarator, "");
      _builder_1.append(".run(");
      _builder_1.append(declarator, "");
      _builder_1.append("$");
      _builder_1.append(expectation, "");
      _builder_1.append(")");
      String _string = _builder_1.toString();
      String _identifier = feature.getIdentifier();
      Assert.assertEquals(_string, _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
