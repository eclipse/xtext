/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PreviewCode {
  public static String lineWrappingPreviewText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.FileReader");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class XtendClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def readMovies() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val movies = new FileReader(\'data.csv\').readLines.map[");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("line |line.toFirstUpper.toFirstLower.toFirstLower.toFirstUpper]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return movies");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def List<String> readLines(FileReader fr) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return newArrayList(\"\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public static String defaultPreviewText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Movies {");
    _builder.newLine();
    _builder.append("def settings(XtendFormatterConfig config) {");
    _builder.newLine();
    _builder.append("val List<FormatterSetting> settings = newArrayList()");
    _builder.newLine();
    _builder.append("for (entry : config.namedProperties.entrySet) {");
    _builder.newLine();
    _builder.append("val key = entry.key");
    _builder.newLine();
    _builder.append("val category = key.split(\".\").head");
    _builder.newLine();
    _builder.append("var catEnum = Category::byName(category)");
    _builder.newLine();
    _builder.append("if (catEnum == null)");
    _builder.newLine();
    _builder.append("catEnum = Category::OTHER");
    _builder.newLine();
    _builder.append("settings.add(");
    _builder.newLine();
    _builder.append("createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD, key, key.toFirstUpper,");
    _builder.newLine();
    _builder.append("newArrayList(entry.value.name)))");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("return settings");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public static String newLinePreviewText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.append("import java.io.FileReader");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("@Data class PersonClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property String name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property String vorname");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public static String bracesPreviewText() {
    return PreviewCode.defaultPreviewText();
  }
}
