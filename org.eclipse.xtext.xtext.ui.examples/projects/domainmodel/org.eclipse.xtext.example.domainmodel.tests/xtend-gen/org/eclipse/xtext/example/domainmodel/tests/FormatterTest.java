/**
 * Copyright (c) 2016, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.tests;

import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class FormatterTest extends AbstractFormatterTest {
  /**
   * This example tests if the formatted document equals the unformatted document.
   * This is the most convenient way to test a formatter.
   */
  @Test
  public void example1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("propertyName:String");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op name() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val x = 1 + 2 + 4");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val foo = {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("println()");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("println()");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  /**
   * This example tests whether a messy document is being formatted properly.
   * In contrast to the first example, this approach also allows to test formatting strategies that are input-aware.
   * Example: "Change newLines between tokens to be one at minimum, two at maximum."
   * Here, it depends on the formatters input document whether there will be one or two newLines on the output.
   */
  @Test
  public void example2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {  op  foo  (  )  :  String  {  \"xx\"  }  }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("op foo():String {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\"xx\"");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedTo(_builder, _builder_1);
  }

  /**
   * This example shows how to test property-dependent formatting behavior.
   */
  @Test
  public void example3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo():String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"xx\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Foo {");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("op foo():String {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("\"xx\"");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<String>put(FormatterPreferenceKeys.indentation, " ");
    };
    this.assertFormattedTo(_builder, _builder_1, _function);
  }
}
