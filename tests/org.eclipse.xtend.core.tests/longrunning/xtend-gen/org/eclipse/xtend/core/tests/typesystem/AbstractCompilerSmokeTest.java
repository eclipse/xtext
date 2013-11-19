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
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractCompilerSmokeTest extends CompilerTest {
  @Inject
  @Extension
  private Oven _oven;
  
  public void testBug_350932_13() throws Exception {
    final String code = ((((((("package x class Z {" + 
      "  def bug(){\n") + 
      "    val x = if (true) return Boolean::FALSE x\n") + 
      "  }\n") + 
      "  def invoke() {\n") + 
      "    val boolean b = bug\n") + 
      "  }\n") + 
      "}\n");
    this.assertNonSmoking(code);
  }
  
  public void testBug_350932_14() throws Exception {
    final String code = ((((((("package x class Z {" + 
      "  def bug(){\n") + 
      "    val x = if (true) return Boolean::FALSE else null x\n") + 
      "  }\n") + 
      "  def invoke() {\n") + 
      "    val boolean b = bug\n") + 
      "  }\n") + 
      "}\n");
    this.assertNonSmoking(code);
  }
  
  public void testBug_352849_02() throws Exception {
    final String code = (((((((((((((((((((("package x\n" + 
      "import java.util.Collection\n") + 
      "import java.util.List\n") + 
      "class Z {") + 
      "  \tdef generate() {\n") + 
      "\t\tval List<CharSequence> seq = null\n") + 
      "\t\tval List<String> strings = null\n") + 
      "\t\tval result1 = seq.addAll2(strings)\n") + 
      "\t\tval Collection<String> test1 = result1\n") + 
      "\t\tval result2 = strings.addAll3(seq)\n") + 
      "\t\tval Collection<String> test2 = result2\n") + 
      "\t}\n") + 
      "\tdef <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n") + 
      "\t    collection.addAll(elements)\n") + 
      "\t    null\n") + 
      "\t}\n") + 
      "\tdef <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n") + 
      "\t    collection.addAll(elements)\n") + 
      "\t    null\n") + 
      "\t}\n") + 
      "}");
    this.assertNonSmoking(code);
  }
  
  public void testBug343096_01() throws Exception {
    this.compileJavaCode("x.Y", 
      ((((("package x class Y {" + 
        "def <T> bug343096() {\n") + 
        "  [T t|switch t {\n") + 
        "    case t : bug343096\n") + 
        "  }]") + 
        "}}"));
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
