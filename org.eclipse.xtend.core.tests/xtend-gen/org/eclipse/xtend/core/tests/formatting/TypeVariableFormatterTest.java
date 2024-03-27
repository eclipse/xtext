/**
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class TypeVariableFormatterTest extends AbstractFormatterTest {
  private CharSequence paramToFile(final CharSequence string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo");
    _builder.append(string);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public void assertTypeParam(final CharSequence toBeFormatted) {
    this.assertUnformattedEqualsFormatted(this.paramToFile(toBeFormatted));
  }

  @Test
  public void integration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo<T extends Collection<?>, K extends Collection<?>> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new<A extends Collection<?>, B extends Collection<?>>() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends Collection<?>, V extends Collection<?>> void methode() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void tparam1() {
    this.assertTypeParam("<T>");
  }

  @Test
  public void tparam2() {
    this.assertTypeParam("<T, K>");
  }

  @Test
  public void tparamUpperBound() {
    this.assertTypeParam("<T extends String>");
  }

  @Test
  public void tparamUpperBound2() {
    this.assertTypeParam("<T extends Collection<?>>");
  }

  @Test
  public void tparamUpperBound3() {
    this.assertTypeParam("<T extends Collection<?>, K extends Collection<?>>");
  }

  @Test
  public void tparamUpperBound4() {
    this.assertTypeParam("<T extends Collection<?> & List<?>>");
  }
}
