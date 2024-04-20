/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
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
public class XtendEnumFormatterTest extends AbstractFormatterTest {
  @Test
  public void formatPublic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public enum Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatLiteral01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatLiteral02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAR,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAZ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatLiteral03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO,");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAR,");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAZ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatBraces_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void formatBraces_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }
}
