/**
 * Copyright (c) 2014, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import java.util.function.Consumer;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class AnonymousClassFormatterTest extends AbstractFormatterTest {
  @Test
  public void formatSingleMember() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatMultiMember() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int bar");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def foo(String x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatTypeParam() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Iterable<String>() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override iterator() {");
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
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void formatNested() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Iterator");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Iterable<String>() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override iterator() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new Iterator<String>() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("override hasNext() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("true");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("override next() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("override remove() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }
}
