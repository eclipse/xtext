/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.compiler.CompilerTest;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractCompilerSmokeTest extends CompilerTest {
  @Inject
  private Oven _oven;
  
  public void testBug_350932_13() throws Exception {
    String _plus = ("package x class Z {" + 
      "  def bug(){\n");
    String _plus_1 = (_plus + 
      "    val x = if (true) return Boolean::FALSE x\n");
    String _plus_2 = (_plus_1 + 
      "  }\n");
    String _plus_3 = (_plus_2 + 
      "  def invoke() {\n");
    String _plus_4 = (_plus_3 + 
      "    val boolean b = bug\n");
    String _plus_5 = (_plus_4 + 
      "  }\n");
    final String code = (_plus_5 + 
      "}\n");
    this.assertNonSmoking(code);
  }
  
  public void testBug_350932_14() throws Exception {
    String _plus = ("package x class Z {" + 
      "  def bug(){\n");
    String _plus_1 = (_plus + 
      "    val x = if (true) return Boolean::FALSE else null x\n");
    String _plus_2 = (_plus_1 + 
      "  }\n");
    String _plus_3 = (_plus_2 + 
      "  def invoke() {\n");
    String _plus_4 = (_plus_3 + 
      "    val boolean b = bug\n");
    String _plus_5 = (_plus_4 + 
      "  }\n");
    final String code = (_plus_5 + 
      "}\n");
    this.assertNonSmoking(code);
  }
  
  public void testBug_352849_02() throws Exception {
    String _plus = ("package x\n" + 
      "import java.util.Collection\n");
    String _plus_1 = (_plus + 
      "import java.util.List\n");
    String _plus_2 = (_plus_1 + 
      "class Z {");
    String _plus_3 = (_plus_2 + 
      "  \tdef generate() {\n");
    String _plus_4 = (_plus_3 + 
      "\t\tval List<CharSequence> seq = null\n");
    String _plus_5 = (_plus_4 + 
      "\t\tval List<String> strings = null\n");
    String _plus_6 = (_plus_5 + 
      "\t\tval result1 = seq.addAll2(strings)\n");
    String _plus_7 = (_plus_6 + 
      "\t\tval Collection<String> test1 = result1\n");
    String _plus_8 = (_plus_7 + 
      "\t\tval result2 = strings.addAll3(seq)\n");
    String _plus_9 = (_plus_8 + 
      "\t\tval Collection<String> test2 = result2\n");
    String _plus_10 = (_plus_9 + 
      "\t}\n");
    String _plus_11 = (_plus_10 + 
      "\tdef <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n");
    String _plus_12 = (_plus_11 + 
      "\t    collection.addAll(elements)\n");
    String _plus_13 = (_plus_12 + 
      "\t    null\n");
    String _plus_14 = (_plus_13 + 
      "\t}\n");
    String _plus_15 = (_plus_14 + 
      "\tdef <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n");
    String _plus_16 = (_plus_15 + 
      "\t    collection.addAll(elements)\n");
    String _plus_17 = (_plus_16 + 
      "\t    null\n");
    String _plus_18 = (_plus_17 + 
      "\t}\n");
    final String code = (_plus_18 + 
      "}");
    this.assertNonSmoking(code);
  }
  
  public void testBug343096_01() throws Exception {
    String _plus = ("package x class Y {" + 
      "def <T> bug343096() {\n");
    String _plus_1 = (_plus + 
      "  [T t|switch t {\n");
    String _plus_2 = (_plus_1 + 
      "    case t : bug343096\n");
    String _plus_3 = (_plus_2 + 
      "  }]");
    String _plus_4 = (_plus_3 + 
      "}}");
    this.compileJavaCode("x.Y", _plus_4);
  }
  
  @Ignore
  @Test
  public void testData_03() throws Exception {
    this.assertNonSmoking("package foo @Data class Bar { val myFlag = true }");
  }
  
  protected String compileToJavaCode(final String xtendCode) {
    try {
      this.assertNonSmoking(xtendCode);
      return super.compileToJavaCode(xtendCode);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract void assertNonSmoking(final CharSequence input) throws Exception;
  
  protected void processFile(final String input) {
    try {
      this._oven.fireproof(input);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
