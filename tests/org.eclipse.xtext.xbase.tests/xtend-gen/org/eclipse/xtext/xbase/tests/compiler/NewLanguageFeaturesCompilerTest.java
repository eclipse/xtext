/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.compiler.JavaVersion;
import org.eclipse.xtext.xbase.tests.compiler.AbstractOutputComparingCompilerTests;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class NewLanguageFeaturesCompilerTest extends AbstractOutputComparingCompilerTests {
  @Test
  public void testOverride() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val x = #[\'a\', \'\', \'c\'].filter[!empty] }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final org.eclipse.xtext.xbase.lib.Functions.Function1<String, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function1<String, Boolean>() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Boolean apply(final String it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _isEmpty = it.isEmpty();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Boolean.valueOf((!_isEmpty));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("final Iterable<String> x = org.eclipse.xtext.xbase.lib.IterableExtensions.<String>filter(java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"a\", \"\", \"c\")), _function);");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA6);
  }
  
  @Test
  public void testSwitchOverString() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = switch(\'foo\') {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \'a\': 1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \'b\' + \'c\': 2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default: 3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int _switchResult = (int) 0;");
    _builder_1.newLine();
    _builder_1.append("final String _switchValue = \"foo\";");
    _builder_1.newLine();
    _builder_1.append("switch (_switchValue) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("case \"a\":");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = 1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("case (\"b\" + \"c\"):");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = 2;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_switchResult = 3;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("break;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("final int x = _switchResult;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1, JavaVersion.JAVA7);
  }
}
