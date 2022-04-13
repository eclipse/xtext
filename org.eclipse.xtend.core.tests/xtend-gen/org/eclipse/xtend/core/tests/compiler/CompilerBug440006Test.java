/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug440006Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'\'«FOR i:#{1..2}»«i»«ENDFOR»\'\'\'", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend2.lib.StringConcatenation;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IntegerRange;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public CharSequence test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("StringConcatenation _builder = new StringConcatenation();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("IntegerRange _upTo = new IntegerRange(1, 2);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("for(final IntegerRange i : Collections.<IntegerRange>unmodifiableSet(CollectionLiterals.<IntegerRange>newHashSet(_upTo))) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_builder.append(i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _builder;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void test_012() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'\'«FOR i:#[1..2]»«i»«ENDFOR»\'\'\'", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend2.lib.StringConcatenation;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IntegerRange;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public CharSequence test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("StringConcatenation _builder = new StringConcatenation();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("IntegerRange _upTo = new IntegerRange(1, 2);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("for(final IntegerRange i : Collections.<IntegerRange>unmodifiableList(CollectionLiterals.<IntegerRange>newArrayList(_upTo))) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_builder.append(i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _builder;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
