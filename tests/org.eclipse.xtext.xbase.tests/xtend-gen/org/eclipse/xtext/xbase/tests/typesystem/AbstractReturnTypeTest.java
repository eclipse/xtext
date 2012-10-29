/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractReturnTypeTest<Reference extends Object> extends AbstractTypeResolverTest<Reference> {
  @Test
  public void testReturnType_01() throws Exception {
    this.resolvesTo("return \'foo\'", "String");
  }
  
  @Test
  public void testReturnType_02() throws Exception {
    this.resolvesTo("return try { if (true) \'foo\' else \'bar\' } finally { String::valueOf(\'zonk\') }", "String");
  }
  
  @Test
  public void testReturnType_03() throws Exception {
    this.resolvesTo("{ val c = [ int i | return i ] c.apply(1) return null }", "null");
  }
  
  @Test
  public void testReturnType_04() throws Exception {
    this.resolvesTo("{ val c = [ int i | i ] c.apply(1) return null }", "null");
  }
  
  @Test
  public void testReturnType_06() throws Exception {
    this.resolvesTo("{ var closure = [| return \'literal\'] return closure.apply }", "String");
  }
  
  @Test
  public void testReturnType_08() throws Exception {
    this.resolvesTo("return [| return \'literal\'].apply", "String");
  }
  
  @Test
  public void testIfExpression_03() throws Exception {
    this.resolvesTo("if (true) return \'foo\'", "String");
  }
  
  @Test
  public void testIfExpression_04() throws Exception {
    this.resolvesTo("if (true) return \'\' else new StringBuilder", "Serializable & CharSequence");
  }
  
  @Test
  public void testSwitchExpression_1() throws Exception {
    this.resolvesTo("switch true { case true : return \'s\' default: null}", "String");
  }
}
