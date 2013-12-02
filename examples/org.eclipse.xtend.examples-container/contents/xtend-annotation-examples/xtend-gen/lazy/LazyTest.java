/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package lazy;

import lazy.Lazy;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

@SuppressWarnings("all")
public class LazyTest {
  @Extension
  private XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(Lazy.class);
  
  @Test
  public void testLazy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import lazy.Lazy");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Person {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Lazy String name = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import lazy.Lazy;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Person {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Lazy");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String name;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String _initname() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return \"foo\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getName() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (name==null)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("name = _initname();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return name;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.compilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
