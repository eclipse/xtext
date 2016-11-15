/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.lsp4j.ColoringInformation;
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
@SuppressWarnings("all")
public class ColoringTest extends AbstractTestLangLanguageServerTest {
  private final static String MODEL = new Function0<String>() {
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
    _builder.append(this.fileExtension, "");
    Path _resolve = _path.resolve(_builder.toString());
    final File file = _resolve.toFile();
    URI _uRI = file.toURI();
    final String uri = _uRI.toString();
    this.open(uri, ColoringTest.MODEL);
    Map<String, List<? extends ColoringInformation>> _coloringParams = this.getColoringParams();
    Set<Map.Entry<String, List<? extends ColoringInformation>>> _entrySet = _coloringParams.entrySet();
    final Function1<Map.Entry<String, List<? extends ColoringInformation>>, String> _function = (Map.Entry<String, List<? extends ColoringInformation>> it) -> {
      String _key = it.getKey();
      String _key_1 = it.getKey();
      int _lastIndexOf = _key_1.lastIndexOf("/");
      int _plus = (_lastIndexOf + 1);
      return _key.substring(_plus);
    };
    final Function1<Map.Entry<String, List<? extends ColoringInformation>>, List<? extends ColoringInformation>> _function_1 = (Map.Entry<String, List<? extends ColoringInformation>> it) -> {
      return it.getValue();
    };
    Map<String, List<? extends ColoringInformation>> _map = IterableExtensions.<Map.Entry<String, List<? extends ColoringInformation>>, String, List<? extends ColoringInformation>>toMap(_entrySet, _function, _function_1);
    final String expectation = this.toExpectation(_map);
    StringConcatenation _builder_1 = new StringConcatenation();
    String _name = file.getName();
    _builder_1.append(_name, "");
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
}
