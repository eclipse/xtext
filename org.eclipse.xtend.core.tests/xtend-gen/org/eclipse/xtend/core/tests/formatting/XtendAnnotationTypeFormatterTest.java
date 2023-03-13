/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendAnnotationTypeFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatPublic() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public annotation Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatAbstract() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract annotation Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatPublicAbstract() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public abstract annotation Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatField01() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatField02() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int baz");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Ignore
  @Test
  public void formatFieldInit01() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Ignore
  @Test
  public void formatFieldInit02() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo = 1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int baz = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Ignore
  @Test
  public void formatFieldInit03() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Ignore
  @Test
  public void formatFieldInit04() {
    final Procedure1<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = 1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val baz = 1 + 1");
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
    _builder.append("annotation Bar {");
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
    _builder.append("annotation Bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }

  @Test
  public void formatFieldAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated int baz");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
}
