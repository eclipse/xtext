/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendEnumFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatPublic() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public enum Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatLiteral01() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatLiteral02() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
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
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatLiteral03() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Integer>put(XtendFormatterPreferenceKeys.blankLinesBetweenEnumLiterals, Integer.valueOf(1));
    };
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
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatBraces_01() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatBraces_02() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
    };
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
    this.assertFormatted(_function, _builder);
  }
}
