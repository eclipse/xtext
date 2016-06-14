/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.highlighting;

import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IEditorHighlightingConfigurationProvider;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestLanguageHighlightingProvider implements IEditorHighlightingConfigurationProvider {
  @Override
  public String getConfiguration(final String editorName) {
    if ((Objects.equal(editorName, "EclipseChe") || Objects.equal(editorName, "EclipseOrion"))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#string_doubleQuote\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#string_singleQuote\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#brace_open\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#brace_close\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#bracket_open\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#bracket_close\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#parenthesis_open\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#parenthesis_close\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#number_decimal\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{include: \"orion.lib#number_hex\"},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("match: \"\\\\\\\\b(?:type|string|int|boolean)\\\\\\\\b\", ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("name: \"keyword.json\" ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("]");
      _builder.newLine();
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      return _builder_1.toString();
    }
  }
}
