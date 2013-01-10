/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.compiler.AbstractCompilerTests2;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerTests2WithNewTypeSystem extends AbstractCompilerTests2 {
  @Test
  public void testNewThread() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Thread [| ]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final Runnable _function = new Runnable() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public void run() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("Thread _thread = new Thread(_function);");
    _builder_1.newLine();
    _builder_1.append("return _thread;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  @Ignore(value = "TODO Produces verbose code")
  public void testForLoop_01() throws Exception {
    super.testForLoop_01();
  }
  
  @Test
  @Ignore(value = "TODO Produces verbose code")
  public void testForLoop_06() throws Exception {
    super.testForLoop_06();
  }
  
  @Test
  @Ignore(value = "TODO Produces verbose code")
  public void testForLoop_08() throws Exception {
    super.testForLoop_08();
  }
  
  @Test
  @Ignore(value = "TODO Type check fails")
  public void testForLoop_10() throws Exception {
    super.testForLoop_10();
  }
}
