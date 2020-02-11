/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import org.eclipse.lsp4j.ColoringInformation;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

/**
 * Test for checking the coloring service for the test language.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@Deprecated
@SuppressWarnings("all")
public class ColoringTest extends AbstractTestLangLanguageServerTest {
  private static final String MODEL = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() { } ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo(a: A): string { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("type B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int b");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo(a: A, b: B): int { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("type C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int c");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo(a: A, b: B, c: C): void { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("type Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("boolean t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op main() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void checkColoring() {
    this.initialize();
    Path _path = this.root.toPath();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyModel.");
    _builder.append(this.fileExtension);
    final File file = _path.resolve(_builder.toString()).toFile();
    final String uri = file.toURI().toString();
    this.open(uri, ColoringTest.MODEL);
    final Function1<Map.Entry<String, List<? extends ColoringInformation>>, String> _function = (Map.Entry<String, List<? extends ColoringInformation>> it) -> {
      String _key = it.getKey();
      int _lastIndexOf = it.getKey().lastIndexOf("/");
      int _plus = (_lastIndexOf + 1);
      return _key.substring(_plus);
    };
    final Function1<Map.Entry<String, List<? extends ColoringInformation>>, List<? extends ColoringInformation>> _function_1 = (Map.Entry<String, List<? extends ColoringInformation>> it) -> {
      return it.getValue();
    };
    final String expectation = this.toExpectation(IterableExtensions.<Map.Entry<String, List<? extends ColoringInformation>>, String, List<? extends ColoringInformation>>toMap(this.getColoringParams().entrySet(), _function, _function_1));
    StringConcatenation _builder_1 = new StringConcatenation();
    String _name = file.getName();
    _builder_1.append(_name);
    _builder_1.append(" ->");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" ");
    _builder_1.append("* [[1, 5] .. [1, 6]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[2, 4] .. [2, 7]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[3, 4] .. [3, 7]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[6, 5] .. [6, 6]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[7, 4] .. [7, 7]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[10, 5] .. [10, 6]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[11, 4] .. [11, 7]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[14, 9] .. [14, 10]] -> [1]");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* [[15, 4] .. [15, 8]] -> [1]");
    this.assertEquals(_builder_1.toString(), expectation);
  }
  
  @Override
  protected Class<? extends LanguageClient> getLanguageClientClass() {
    return LanguageClientExtensions.class;
  }
}
